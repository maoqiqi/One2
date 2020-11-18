package com.codearms.maoqiqi.one.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.codearms.maoqiqi.one.listener.OnToolbarListener
import com.codearms.maoqiqi.one.music.R

class MusicActivity : AppCompatActivity(), OnToolbarListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onToolbar(toolbar: Toolbar?) {
        setSupportActionBar(toolbar)
    }
}