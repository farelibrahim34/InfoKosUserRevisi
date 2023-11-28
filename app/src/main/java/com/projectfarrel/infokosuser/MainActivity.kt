package com.projectfarrel.infokosuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.projectfarrel.infokosuser.adapter.ViewPagerFragmentAdapter
import com.projectfarrel.infokosuser.databinding.ActivityMainBinding

import me.relex.circleindicator.CircleIndicator3


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val data = mutableListOf<String>()
    private var fragmentList = ArrayList<Fragment>()
    private lateinit var viewPager: ViewPager2
    private lateinit var indicator: CircleIndicator3
    private lateinit var btnNext: Button
    private lateinit var btnBack: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        castView()
        addToList()
        fragmentList.add(FragmentOne())
        fragmentList.add(FragmentTwo())
        fragmentList.add(FragmentThree())

        // viewPager.adapter = ViewPagerAdapter(data, this)
        viewPager.adapter = ViewPagerFragmentAdapter(this, fragmentList)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        indicator.setViewPager(viewPager)

//        binding.btnNext.setOnClickListener {
//            viewPager.apply {
//                beginFakeDrag()
//                fakeDragBy(-10f)
//                endFakeDrag()
//            }
//        }

//        binding.btnBack.setOnClickListener {
//            viewPager.apply {
//                beginFakeDrag()
//                fakeDragBy(10f)
//                endFakeDrag()
//            }
//        }
    }

    private fun castView() {
        viewPager = binding.viewPager2
        indicator = binding.indicator
//        btnNext = binding.btnNext
//        btnBack = binding.btnBack

    }

    private fun addToList() {
        for (item in 1..3) {
            data.add("item $item")
        }
    }

    }


