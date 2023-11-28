package com.projectfarrel.infokosuser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.projectfarrel.infokosuser.databinding.ItemPageBinding



class FragmentOne : Fragment() {
    private lateinit var binding : ItemPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ItemPageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}