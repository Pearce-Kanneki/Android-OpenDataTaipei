package com.kanneki.opentaipei.ui.zoodetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kanneki.opentaipei.R
import com.kanneki.opentaipei.databinding.ItemZooDetailHeaderBinding
import com.kanneki.opentaipei.databinding.ItemZooDetialCellBinding
import com.kanneki.opentaipei.model.PlantModel
import com.kanneki.opentaipei.model.ZooModel
import kotlinx.android.synthetic.main.item_zoo_detail_header.view.*

class ZooDetailAdapter(private val callback:(PlantModel?, String?) -> Unit)
    : RecyclerView.Adapter<ZooDetailAdapter.ViewHolder>(){

    companion object{
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
    }

    private var headerData: ZooModel? = null
    private val sections = ArrayList<PlantModel>()

    fun setSectionsData(list: List<PlantModel>){
        sections.clear()
        sections.addAll(list)
        notifyDataSetChanged()
    }

    fun searchHeaderdata(data: ZooModel){
        headerData = data
        notifyItemChanged(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        when(viewType){
            TYPE_HEADER -> {
                val binding = DataBindingUtil.inflate<ItemZooDetailHeaderBinding>(
                        inflater,
                        R.layout.item_zoo_detail_header,
                        parent,
                        false
                )

                return ViewHolder(binding)
            }
            else -> {
                val binding = DataBindingUtil.inflate<ItemZooDetialCellBinding>(
                        inflater,
                        R.layout.item_zoo_detial_cell,
                        parent,
                        false
                )

                return ViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when(holder.itemViewType){

            TYPE_HEADER -> {
                holder.headerBinding?.let {
                    it.data = headerData
                    it.root.webTextView.setOnClickListener {
                        callback(null, headerData?.eURL)
                    }
                }
            }
            TYPE_ITEM -> {
                holder.regularItemBinding?.let {
                    it.item = sections[position - 1]
                    it.root.setOnClickListener { callback(sections[position - 1], null) }
                }
            }
        }
    }

    override fun getItemCount(): Int = sections.size + 1

    override fun getItemViewType(position: Int): Int {

        return if (position == 0){
            TYPE_HEADER
        } else {
            TYPE_ITEM
        }
    }


    inner class ViewHolder : RecyclerView.ViewHolder {
        var headerBinding: ItemZooDetailHeaderBinding? = null
        var regularItemBinding: ItemZooDetialCellBinding? = null

        constructor(binding: ItemZooDetailHeaderBinding) : super(binding.root) {
            headerBinding = binding
        }

        constructor(binding: ItemZooDetialCellBinding) : super(binding.root) {
            regularItemBinding = binding
        }
    }

}