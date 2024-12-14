package com.example.ums_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.ums_1.R
import com.example.ums_1.adapter.RvAdapter
import com.example.ums_1.databinding.FragmentListBinding
import com.example.ums_1.models.MyInfo
import com.example.ums_1.utils.InfoStatus
import com.example.ums_1.utils.MyData

class ListFragment : Fragment() {
    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }
    lateinit var infoStatus: InfoStatus
    lateinit var rvAdapter: RvAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        infoStatus = arguments?.getSerializable("keyInfo") as InfoStatus

        val dataList = when(infoStatus){
            InfoStatus.TARIFLAR->MyData.tarifList
            InfoStatus.DAQIQALAR->MyData.daqiqalarList
            InfoStatus.INTERNET->MyData.internetList
            InfoStatus.XIZMATLAR->MyData.xizmatList
            InfoStatus.SMS->MyData.smsList
        }
        rvAdapter = RvAdapter(dataList) { selectedItem ->
            val bundle = Bundle().apply {
                putSerializable("keyInfo", selectedItem)
            }
            findNavController().navigate(R.id.action_listFragment_to_infoFragment, bundle)
        }
        binding.rv.adapter = rvAdapter

        return binding.root
    }
}