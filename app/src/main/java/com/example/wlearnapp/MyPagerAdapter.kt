package com.example.wlearnapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0->{
                //create 3 fragments
                ExerciseOne()
            }
            1->{
                ExerciseTwo()
            }
            2->{
                 ExerciseThree()
            }
            else->{
                return ExerciseFour()
            }

            //this for tab position
        }
    }

    override fun getCount(): Int {
        return 4
        //this will return 3 tabs
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0->"TCP/IP&\nOSI Model"
            1->"ARQ"
            2->{
                "Routing\nProtocols"
            }
            else->{
                return "TCP Congestion Control"
            }
            //set tab titles
        }
    }
}