package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codearms.maoqiqi.one.ImageLoader.displayImage
import com.codearms.maoqiqi.one.MarginItemDecoration
import com.codearms.maoqiqi.one.bean.ArticleBean
import com.codearms.maoqiqi.one.home.R
import com.codearms.maoqiqi.one.home.databinding.ItemArticlesBinding
import com.codearms.maoqiqi.one.viewmodel.ArticlesViewModel

class ArticlesFragment : ListFragment() {

    private val viewModel: ArticlesViewModel by viewModels()
    private val articlesAdapter: ArticlesAdapter by lazy { ArticlesAdapter(arrayListOf()) }

    private var from: String? = null
    private var currentId: Int = 0
    private var k: String? = null
    private var isClassify: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            from = it.getString("from", FROM_HOME)
            currentId = it.getInt("id")
            k = it.getString("k")
            isClassify = it.getBoolean("isClassify")
        }
        // 首页不需要
        if (from == FROM_HOME) {
            binding.refreshLayout.apply {
                setEnableRefresh(false)
                setEnableLoadMore(false)
            }
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            isNestedScrollingEnabled = false
//            setHasFixedSize(true)
            adapter = articlesAdapter
            addItemDecoration(MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.dp_12)))
        }
        viewModel.getHomeArticles.observe(viewLifecycleOwner, { articleBeans ->
            Log.e("mfq", articleBeans.toString())
            articlesAdapter.data = articleBeans
            articlesAdapter.notifyDataSetChanged()
        })
    }

    override fun loadData() {
        super.loadData()
        if (from.equals(FROM_HOME)) {
            getData()
        } else {
            binding.refreshLayout.apply {
                setEnableAutoLoadMore(true) // 滚动到底部时触发加载事件
                autoRefresh() // 触发刷新事件
            }
        }
    }

    override fun getData() {
        when (from) {
            // 首页数据
            FROM_HOME -> viewModel.getHomeArticles()
            // 查看某个公众号历史数据
            FROM_WE_CHAT -> viewModel.getWxArticles(currentId, isRefresh)
            // 项目列表数据
            FROM_PROJECT -> viewModel.getProjectArticles(currentId, isRefresh)
            // 知识体系下的文章
            FROM_CLASSIFY -> viewModel.getKnowledgeArticles(currentId, isRefresh)
            // 收藏文章列表
            FROM_COLLECT -> viewModel.getCollect(isRefresh)
            // 搜索
            FROM_SEARCH -> viewModel.query(k, isRefresh)
        }
    }

    inner class ArticlesAdapter(var data: List<ArticleBean>) : RecyclerView.Adapter<ArticlesViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
            return ArticlesViewHolder(LayoutInflater.from(requireActivity()).inflate(R.layout.item_articles, parent, false))
        }

        override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
            val articleBean = data[position]
            // 图片
            if (articleBean.envelopePic == "" || articleBean.envelopePic == "null") {
//                holder.binding.ivProject.visibility = View.GONE
            } else {
                holder.binding.ivProject.visibility = View.VISIBLE
                displayImage(holder.binding.ivProject, articleBean.envelopePic, R.drawable.ic_article_placeholder)
            }
            // 标题
            holder.binding.tvTitle.text = Html.fromHtml(articleBean.title)
            // 描述
            if (articleBean.desc == "" || articleBean.desc == "null") {
                holder.binding.tvDes.visibility = View.GONE
            } else {
                holder.binding.tvDes.visibility = View.VISIBLE
                holder.binding.tvDes.text = Html.fromHtml(articleBean.desc)
            }
            // 作者
            holder.binding.tvAuthor.text = articleBean.author
            // 时间
            holder.binding.tvDate.text = articleBean.niceDate

            holder.binding.ivCollect.setOnClickListener { }
            holder.binding.root.setOnClickListener { }
        }

        override fun getItemCount(): Int = data.size
    }

    inner class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemArticlesBinding = ItemArticlesBinding.bind(itemView)
    }

    companion object {
        const val FROM_HOME = "FROM_HOME"
        const val FROM_WE_CHAT = "FROM_WE_CHAT"
        const val FROM_PROJECT = "FROM_PROJECT"
        const val FROM_CLASSIFY = "FROM_CLASSIFY"
        const val FROM_COLLECT = "FROM_COLLECT"
        const val FROM_SEARCH = "FROM_SEARCH"

        fun newInstance(from: String, id: Int, isClassify: Boolean): ArticlesFragment {
            val bundle = Bundle()
            bundle.putString("from", from)
            bundle.putInt("id", id)
            bundle.putBoolean("isClassify", isClassify)
            return ArticlesFragment().apply { arguments = bundle }
        }

        fun newInstance(from: String, k: String): ArticlesFragment {
            val bundle = Bundle()
            bundle.putString("from", from)
            bundle.putString("k", k)
            bundle.putBoolean("isClassify", false)
            return ArticlesFragment().apply { arguments = bundle }
        }
    }
}