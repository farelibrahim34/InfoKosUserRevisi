package com.projectfarrel.infokosuser
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.projectfarrel.infokosuser.databinding.ItemPage2Binding



class FragmentTwo : Fragment() {
    private lateinit var binding: ItemPage2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemPage2Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

}