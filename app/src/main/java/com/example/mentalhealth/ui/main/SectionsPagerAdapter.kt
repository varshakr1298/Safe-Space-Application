package com.example.mentalhealth.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mentalhealth.R

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    "Prevention"
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

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