package com.inoid.submission.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.inoid.submission.R
import com.inoid.submission.ui.movie.airing.MovieAiringFragment
import com.inoid.submission.ui.tvshow.airing.TvShowAiringFragment

class AiringPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tv_show)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieAiringFragment()
            1 -> TvShowAiringFragment()
            else -> Fragment()
        }


    override fun getCount(): Int = TAB_TITLES.size

    override fun getPageTitle(position: Int): CharSequence? = context.resources.getString(TAB_TITLES[position])


}