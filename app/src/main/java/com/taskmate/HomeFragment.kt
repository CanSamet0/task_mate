package com.taskmate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.taskmate.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding= FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPagerAdapter()
    }

    private val fragmentList = arrayListOf(
        WaitingFragment(), CompletedFragment()
    )

    private val tabTitles = arrayListOf(
        "Bekleyen","Tamamlanan"
    )

    private fun initViewPagerAdapter() {
        val viewPager = binding.vpHome
        adapter = ViewPagerAdapter(childFragmentManager, viewLifecycleOwner.lifecycle, fragmentList)
        viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayoutHomeFragment, viewPager){tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}