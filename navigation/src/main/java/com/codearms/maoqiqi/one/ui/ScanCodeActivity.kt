package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.one.NavigationRoutePath
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.navigation.R
import com.codearms.maoqiqi.one.navigation.databinding.ActivityScanCodeBinding
import com.codearms.maoqiqi.one.utils.ShareUtils

/**
 * 扫码下载
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = NavigationRoutePath.NAVIGATION_SCAN_CODE)
class ScanCodeActivity : BaseActivity() {

    private val binding: ActivityScanCodeBinding by binding(R.layout.activity_scan_code)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_scan_code, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_share -> {
                ShareUtils.shareText(this, getString(R.string.share_download_content, getString(R.string.download_url)));
                return true
            }
            R.id.menu_star -> {
                Toast.makeText(this, resources.displayMetrics.density.toString(), Toast.LENGTH_SHORT).show()
                // WebViewActivity.start(this, R.color.color_navigation, "", getString(R.string.project_url));
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}