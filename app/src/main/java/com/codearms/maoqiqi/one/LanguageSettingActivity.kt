package com.codearms.maoqiqi.one

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.language.LanguageManager
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.databinding.ActivityLanguageSettingBinding
import java.util.*

class LanguageSettingActivity : BaseActivity() {

    private val binding: ActivityLanguageSettingBinding by binding(R.layout.activity_language_setting)
    private val languages by lazy { resources.getStringArray(R.array.languages) }
    private val adapter: LanguageAdapter by lazy { LanguageAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        binding.recyclerView.adapter = adapter
    }

    override fun onBackPressed() {
        // super.onBackPressed()
        val intent = Intent(this, LanguageActivity::class.java)
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
    }

    inner class LanguageAdapter : RecyclerView.Adapter<LanguageViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
            return LanguageViewHolder(LayoutInflater.from(this@LanguageSettingActivity).inflate(R.layout.item_language, parent, false))
        }

        override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
            holder.tvLanguage.text = languages[position]
            holder.itemView.setOnClickListener {
                if (position == 0) {
                    LanguageManager.getInstance().setFollowSystemLocale(this@LanguageSettingActivity)
                } else {
                    LanguageManager.getInstance().setLocale(this@LanguageSettingActivity, getLanguageLocale(position))
                }
                recreate()
            }
        }

        override fun getItemCount(): Int = languages.size

        private fun getLanguageLocale(position: Int): Locale = when (position) {
            0 -> Locale.getDefault()
            1 -> Locale("ar") // 阿拉伯语
            2 -> Locale.GERMAN // 德语
            3 -> Locale.ENGLISH // 英语
            4 -> Locale("es") // 西班牙语
            5 -> Locale.FRENCH // 法语
            6 -> Locale("hi") // 印地语
            7 -> Locale("in")// 印度尼西亚语
            8 -> Locale.ITALIAN // 意大利语
            9 -> Locale.JAPAN // 日语
            10 -> Locale.KOREAN // 韩语
            11 -> Locale("pt") // 葡萄牙语
            12 -> Locale("ru") // 俄语
            13 -> Locale("th")  // 泰语
            14 -> Locale("tl") // 菲律宾语
            15 -> Locale("vi")  // 越南语
            16 -> Locale.TRADITIONAL_CHINESE // 繁体中文
            else -> Locale.SIMPLIFIED_CHINESE // 简体中文
        }
    }

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvLanguage: TextView = itemView.findViewById(R.id.tv_language)
    }
}