package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.music.R
import com.codearms.maoqiqi.one.ui.MusicUtils

/**
 * TODO
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
class MusicListFragment : BaseFragment() {

    private var position: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_music_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        position = arguments?.getInt("position") ?: 0
        Log.e("info", "position=$position")
        setHasOptionsMenu(true)
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