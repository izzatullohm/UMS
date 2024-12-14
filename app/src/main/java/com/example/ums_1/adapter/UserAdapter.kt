package com.example.ums_1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ums_1.databinding.ItemRvBinding
import com.example.ums_1.models.MyInfo

class RvAdapter(var list:ArrayList<MyInfo> = ArrayList(), private val onItemClick:(MyInfo)->Unit):RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(var itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(myInfo: MyInfo) {
            itemRvBinding.tvBolim.text = myInfo.title
            itemRvBinding.tvCod.text = myInfo.ussdCode
            itemRvBinding.tvMalumot.text = myInfo.about
            itemRvBinding.root.setOnClickListener {
                onItemClick(myInfo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}