package com.kanneki.opentaipei.ui.plantdetail

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.kanneki.opentaipei.model.PlantModel
import com.kanneki.opentaipei.model.ShowTextModel

class PlantDetailViewModel: ViewModel() {

    val data: ObservableArrayList<ShowTextModel> = ObservableArrayList()
    val imageUrl: ObservableField<String> = ObservableField()
    val toolBarText: ObservableField<String> = ObservableField()

    fun setImageUrl(str: String){
        imageUrl.set(str)
    }

    fun setToolBarText(str: String){
        toolBarText.set(str)
    }

    fun setData(model: PlantModel, titleList: List<String>){
        data.clear()

        data.add(ShowTextModel(model.fNameCh ?: "", model.fNameLatin ?: ""))
        titleList.forEachIndexed { index, title ->

            val contentText = when(index){
                0 -> model.fAlsoKnown
                1 -> model.fBrief
                2 -> model.fFeature
                3 -> model.fFunctionApplication
                else -> ""
            }

            data.add(ShowTextModel(title, contentText ?: ""))
        }

    }
}