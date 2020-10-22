package com.inoid.submission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inoid.submission.ui.home.AiringPagerAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sectionPagerAdapter = AiringPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionPagerAdapter
        tabs_layout.setupWithViewPager(view_pager)


    }
}