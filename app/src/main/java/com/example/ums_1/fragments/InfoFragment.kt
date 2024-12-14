package com.example.ums_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ums_1.databinding.FragmentInfoBinding
import com.example.ums_1.models.MyInfo


class InfoFragment : Fragment() {
    private val binding by lazy { FragmentInfoBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myInfo = arguments?.getSerializable("keyInfo") as MyInfo
        binding.tvTitle.text = myInfo.title
        binding.tvAboutShort.text = myInfo.ussdCode
        binding.tvAbout.text = myInfo.about
        return binding.root
    }
}