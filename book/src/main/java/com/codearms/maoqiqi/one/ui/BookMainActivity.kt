package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.codearms.maoqiqi.one.BookRoutePath
import com.codearms.maoqiqi.one.FragmentManagerUtils.addFragment
import com.codearms.maoqiqi.one.StatusBarUtils.setFullScreen
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.book.R
import com.codearms.maoqiqi.one.listener.OnToolbarListener

/**
 * 图书主页
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = BookRoutePath.BOOK_MAIN)
class BookMainActivity : BaseActivity(), OnToolbarListener {

    private val tag = "book_fragment_tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFullScreen(true, true)
        val newFragment: Fragment? = ARouter.getInstance().build(BookRoutePath.BOOK_FRAGMENT).navigation() as? Fragment
        addFragment(R.id.container, newFragment, tag, savedInstanceState)
    }

    override fun onToolbar(toolbar: Toolbar?) {
        toolbar?.setNavigationIcon(R.drawable.ic_back)
//        toolbar?.title = ""
        setSupportActionBar(toolbar)
    }
}