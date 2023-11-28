package com.projectfarrel.infokosuser

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.projectfarrel.infokosuser.databinding.ItemPage3Binding
import com.projectfarrel.infokosuser.view.HomeActivity


class FragmentThree : Fragment() {
    private lateinit var binding : ItemPage3Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemPage3Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tvLogin.setOnClickListener {
            startActivity(Intent(context, HomeActivity::class.java))

        }

    }}