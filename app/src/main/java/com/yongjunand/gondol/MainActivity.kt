package com.yongjunand.gondol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.yongjunand.gondol.Adapter.MainFragmentStatePagerAdapter

class MainActivity : AppCompatActivity() {
    lateinit var vp_ac_main_frag_pager: ViewPager
    lateinit var tl_ac_main_bottom_menu: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vp_ac_main_frag_pager = findViewById<ViewPager>(R.id.vp_ac_main_frag_pager)
        tl_ac_main_bottom_menu = findViewById(R.id.tl_ac_main_bottom_menu)

        configureBottomNavigation()
    }

    private fun configureBottomNavigation(){
        vp_ac_main_frag_pager.adapter = MainFragmentStatePagerAdapter(supportFragmentManager, 2)

        tl_ac_main_bottom_menu.setupWithViewPager(vp_ac_main_frag_pager)

        val bottomNaviLayout: View = this.layoutInflater.inflate(R.layout.bottom_navigation_tab, null, false)

        tl_ac_main_bottom_menu.getTabAt(0)!!.customView = bottomNaviLayout.findViewById(R.id.btn_bottom_navi_home_tab) as
                RelativeLayout
        tl_ac_main_bottom_menu.getTabAt(1)!!.customView = bottomNaviLayout.findViewById(R.id.btn_bottom_navi_search_tab) as RelativeLayout
    }
}

