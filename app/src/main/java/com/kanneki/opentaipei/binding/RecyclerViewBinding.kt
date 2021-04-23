package com.kanneki.opentaipei.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kanneki.opentaipei.model.PlantModel
import com.kanneki.opentaipei.model.ShowTextModel
import com.kanneki.opentaipei.model.ZooModel
import com.kanneki.opentaipei.ui.plantdetail.PlantDetailAdapter
import com.kanneki.opentaipei.ui.zoodetail.ZooDetailAdapter
import com.kanneki.opentaipei.ui.zoolist.ZooListAdapter

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>){

    view.adapter = adapter
}

@BindingAdapter("adapterZooListData")
fun bindAdapterZooListData(view: RecyclerView, list: List<ZooModel>?){

    list?.let {
        (view.adapter as? ZooListAdapter)?.setSectionsData(it)
    }
}

@BindingAdapter("adapterZooDetailData")
fun bindAdapterZooDetailData(view: RecyclerView, list: List<PlantModel>?){

    list?.let {
        (view.adapter as? ZooDetailAdapter)?.setSectionsData(it)
    }
}

@BindingAdapter("adapterPlantDetailData")
fun bindAdapterPlantDetailData(view: RecyclerView, list: List<ShowTextModel>?) {

    list?.let {
        (view.adapter as? PlantDetailAdapter)?.setSectionsData(it)
    }
}