package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.one.MusicRoutePath
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.listener.OnToolbarListener
import com.codearms.maoqiqi.one.music.R

/**
 * 音乐主页
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = MusicRoutePath.MUSIC_MAIN)
class MusicMainActivity : BaseActivity(), OnToolbarListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onToolbar(toolbar: Toolbar?) {
        toolbar?.setNavigationIcon(R.drawable.ic_back)
        setSupportActionBar(toolbar)
    }
}