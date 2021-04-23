package com.kanneki.opentaipei.ui.zoolist

import com.kanneki.opentaipei.R
import com.kanneki.opentaipei.base.BaseRecyclerview
import com.kanneki.opentaipei.databinding.ItemZooCellBinding
import com.kanneki.opentaipei.model.ZooModel

class ZooListAdapter(private val callback:(ZooModel) -> Unit)
    :BaseRecyclerview<ZooModel, ItemZooCellBinding>(){

    override fun getLayoutResId(): Int = R.layout.item_zoo_cell

    override fun setItemData(holder: ItemZooCellBinding, data: ZooModel) {
        holder.apply {
            item = data
            root.setOnClickListener { callback(data) }
        }
    }
}