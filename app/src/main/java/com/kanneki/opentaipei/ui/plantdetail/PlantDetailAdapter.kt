package com.kanneki.opentaipei.ui.plantdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kanneki.opentaipei.R
import com.kanneki.opentaipei.databinding.ItemPlantCellBinding
import com.kanneki.opentaipei.databinding.ItemPlantHeaderBinding
import com.kanneki.opentaipei.model.ShowTextModel

class PlantDetailAdapter
    : RecyclerView.Adapter<PlantDetailAdapter.ViewHolder>() {

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
    }

    private var titleImager: String? = null
    private val sections = ArrayList<ShowTextModel>()

    fun setSectionsData(list: List<ShowTextModel>) {
        sections.clear()
        sections.addAll(list)
        notifyDataSetChanged()
    }

    fun searchTitleImager(str: String) {
        titleImager = str
        notifyItemChanged(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        when(viewType){
            TYPE_HEADER -> {
                val binding = DataBindingUtil.inflate<ItemPlantHeaderBinding>(
                        inflater,
                        R.layout.item_plant_header,
                        parent,
                        false
                )

                return ViewHolder(binding)
            }
            else -> {
                val binding = DataBindingUtil.inflate<ItemPlantCellBinding>(
                        inflater,
                        R.layout.item_plant_cell,
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
                    it.data = titleImager
                }
            }
            TYPE_ITEM -> {
                holder.regularItemBinding?.let {
                    it.data = sections[position - 1]
                }
            }
        }
    }

    override fun getItemCount(): Int = sections.size + 1

    override fun getItemViewType(position: Int): Int {

        return if (position == 0) {
            TYPE_HEADER
        } else {
            TYPE_ITEM
        }
    }

    inner class ViewHolder : RecyclerView.ViewHolder {
        var headerBinding: ItemPlantHeaderBinding? = null
        var regularItemBinding: ItemPlantCellBinding? = null

        constructor(binding: ItemPlantHeaderBinding) : super(binding.root) {
            headerBinding = binding
        }

        constructor(binding: ItemPlantCellBinding) : super(binding.root) {
            regularItemBinding = binding
        }
    }
}