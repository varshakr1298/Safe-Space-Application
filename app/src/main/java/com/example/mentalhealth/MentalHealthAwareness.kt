package com.example.mentalhealth

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mentalhealth.ui.main.SectionsPagerAdapter

class MentalHealthAwareness : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mental_health_awareness)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        tabs.getTabAt(0)!!.setIcon(R.drawable.desc)
        tabs.getTabAt(1)!!.setIcon(R.drawable.myths2)
        tabs.getTabAt(2)!!.setIcon(R.drawable.preventivemeasures)

    }
    inner class SectionsPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if(position==0){
                return com.example.mentalhealth.DescriptionActivity()
            }
            else
                if(position==1){
                    return com.example.mentalhealth.MythsActivity()
                }
                else {
                    return com.example.mentalhealth.PreventionActivity()
                }
        }


        override fun getPageTitle(position: Int): CharSequence? {
            when(position){
                0->return "Description"
                1->return "Myths"
                2->return "Prevention"
            }
            return null
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }
    }
}