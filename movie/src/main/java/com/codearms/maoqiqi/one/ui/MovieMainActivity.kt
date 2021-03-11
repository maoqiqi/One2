package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.codearms.maoqiqi.one.MovieRoutePath
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.listener.OnToolbarListener
import com.codearms.maoqiqi.one.movie.R

/**
 * 电影主页
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = MovieRoutePath.MOVIE_MAIN)
class MovieMainActivity : BaseActivity(), OnToolbarListener {

    private val tag = "movie_fragment_tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val newFragment: Fragment? = ARouter.getInstance().build(MovieRoutePath.MOVIE_FRAGMENT).navigation() as? Fragment
        addFragment(savedInstanceState, tag, newFragment, R.id.container)
    }

    override fun onToolbar(toolbar: Toolbar?) {
        toolbar?.setNavigationIcon(R.drawable.ic_back)
        toolbar?.title = ""
        setSupportActionBar(toolbar)
    }
}