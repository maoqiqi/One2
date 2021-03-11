package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.*
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.music.R
import com.codearms.maoqiqi.one.music.databinding.FragmentMusicListBinding
import com.codearms.maoqiqi.one.ui.MusicUtils

/**
 * 音乐列表
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
class MusicListFragment : BaseFragment() {

    private val binding: FragmentMusicListBinding by binding()
    private var position: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_music_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        position = arguments?.getInt("position") ?: 0
        setHasOptionsMenu(true)
        binding.tv.text = "MusicListFragment:$position"
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        // if (parentFragment != null && !parentFragment!!.userVisibleHint) return
        when (position) {
            MusicUtils.TYPE_SONG -> inflater.inflate(R.menu.menu_songs_sort_by, menu)
            MusicUtils.TYPE_ARTIST -> inflater.inflate(R.menu.menu_artist_sort_by, menu)
            MusicUtils.TYPE_ALBUM -> inflater.inflate(R.menu.menu_album_sort_by, menu)
            MusicUtils.TYPE_FOLDER -> {
            }
        }
    }

    companion object {
        fun newInstance(position: Int): MusicListFragment {
            val args = Bundle()
            args.putInt("position", position)
            val fragment = MusicListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}