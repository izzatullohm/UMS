package com.example.ums_1.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.ums_1.R
import com.example.ums_1.databinding.FragmentHomeBinding
import com.example.ums_1.utils.InfoStatus


class HomeFragment : Fragment() {
    lateinit var binding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.apply {
            cardTariflar.setOnClickListener { nextFragment(InfoStatus.TARIFLAR) }
            cardDaqiqalar.setOnClickListener { nextFragment(InfoStatus.DAQIQALAR) }
            cardInternet.setOnClickListener { nextFragment(InfoStatus.INTERNET) }
            cardXizmatlar.setOnClickListener { nextFragment(InfoStatus.XIZMATLAR) }
            cardSms.setOnClickListener { nextFragment(InfoStatus.SMS) }
            cardNews.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://mobi.uz/uz/")
                startActivity(intent)
            }
        }
        return binding.root
    }
    fun nextFragment(status: InfoStatus){
        findNavController().navigate(R.id.listFragment, bundleOf("keyInfo" to status))
    }
}
