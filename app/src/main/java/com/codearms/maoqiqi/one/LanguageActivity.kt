package com.codearms.maoqiqi.one

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.RelativeLayout
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.databinding.ActivityLanguageBinding

class LanguageActivity : BaseActivity() {

    private val binding: ActivityLanguageBinding by binding(R.layout.activity_language)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)

        val dp22: Int = resources.getDimensionPixelSize(R.dimen.dp_22)
        val dp24: Int = resources.getDimensionPixelSize(R.dimen.dp_24)
        val dp40: Int = resources.getDimensionPixelSize(R.dimen.dp_40)


        val rlParamsSelected: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(dp22, dp40)
        rlParamsSelected.addRule(RelativeLayout.CENTER_IN_PARENT)

        binding.ivTextColor.layoutParams = rlParamsSelected
        binding.rlTextColor.setOnClickListener { binding.ivTextColor.startAnimation(getAnimationSmall()) }
    }

    private fun getAnimationSmall(): Animation = ScaleAnimation(
        1.3f, 1f, 1.3f, 1f,
        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
    )
        .apply {
            interpolator = AccelerateDecelerateInterpolator()
            duration = 150
            fillAfter = true
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_language, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if (item.itemId == R.id.menu_language) {
            startActivity(Intent(this, LanguageSettingActivity::class.java))
        }
        return true
    }
}