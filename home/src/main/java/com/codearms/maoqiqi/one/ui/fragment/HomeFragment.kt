package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.os.Looper
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.log.LogUtils
import com.codearms.maoqiqi.one.AppUtils.getAppVersionCode
import com.codearms.maoqiqi.one.AppUtils.getAppVersionName
import com.codearms.maoqiqi.one.FragmentManagerUtils.addFragment
import com.codearms.maoqiqi.one.HomeRoutePath
import com.codearms.maoqiqi.one.ImageLoader.displayImage
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.bean.BannerBean
import com.codearms.maoqiqi.one.home.R
import com.codearms.maoqiqi.one.home.databinding.FragmentHomeBinding
import com.codearms.maoqiqi.one.listener.OnToolbarListener
import com.codearms.maoqiqi.one.viewmodel.HomeViewModel
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.indicator.CircleIndicator

/**
 * 首页
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = HomeRoutePath.HOME_FRAGMENT)
class HomeFragment : BaseFragment() {

    private val binding: FragmentHomeBinding by binding()
    private val viewModel: HomeViewModel by viewModels()
    private val bannerAdapter: HomeBannerAdapter by lazy { HomeBannerAdapter(arrayListOf()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.swipeRefreshLayout.apply {
            setColorSchemeResources(R.color.color_home, R.color.color_news, R.color.color_book, R.color.color_music, R.color.color_movie)
            isEnabled = false
        }
        binding.banner.apply {
            adapter = bannerAdapter
            // 添加生命周期观察者
            addBannerLifecycleObserver(this@HomeFragment)
            indicator = CircleIndicator(requireContext())
        }
        viewModel.banner.observe(viewLifecycleOwner, { bannerBeanList ->
            binding.swipeRefreshLayout.isRefreshing = false
            bannerAdapter.setDatas(bannerBeanList)
            bannerAdapter.notifyDataSetChanged()
        })
        binding.apply {
            tvUsefulSites.setOnClickListener {}
            tvNavigation.setOnClickListener {}
            tvWeChat.setOnClickListener {}
            tvKnowledge.setOnClickListener {}
            tvProject.setOnClickListener {}
        }
        val newFragment = ArticlesFragment.newInstance(ArticlesFragment.FROM_HOME, 0, true)
        addFragment(R.id.container, newFragment, "articles_fragment_tag", savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        // activity?.javaClass?.getMethod("associateToolbar", Toolbar::class.java)?.invoke(activity, binding.toolbar)
        if (activity is OnToolbarListener) (activity as OnToolbarListener).onToolbar(binding.toolbar)
    }

    override fun loadData() {
        super.loadData()
        binding.swipeRefreshLayout.isRefreshing = true
        LogUtils.e("====" + (Looper.getMainLooper().thread == Thread.currentThread()))
        viewModel.getBanner()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        if (isShow) inflater.inflate(R.menu.menu_search, menu)
        // if (isShow) inflater.inflate(R.menu.menu_home, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (isShow) LogUtils.v(logInfo, "item:${item.itemId}")
        when (item.itemId) {
            R.id.menu_search -> {
                Toast.makeText(context, "${context.getAppVersionCode()}--${context.getAppVersionName()}", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    inner class HomeBannerAdapter(data: List<BannerBean>) : BannerAdapter<BannerBean, HomeBannerViewHolder>(data) {

        override fun onCreateHolder(parent: ViewGroup?, viewType: Int): HomeBannerViewHolder {
            return HomeBannerViewHolder(LayoutInflater.from(requireActivity()).inflate(R.layout.item_home_banner, parent, false))
        }

        override fun onBindView(holder: HomeBannerViewHolder?, bannerBean: BannerBean?, position: Int, size: Int) {
            if (holder != null && bannerBean != null) {
                displayImage(holder.ivBanner, bannerBean.imagePath)
                holder.tvTitle.text = bannerBean.title
            }
        }
    }

    inner class HomeBannerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivBanner: ImageView = view.findViewById(R.id.iv_banner)
        var tvTitle: TextView = view.findViewById(R.id.tv_title)
    }
}