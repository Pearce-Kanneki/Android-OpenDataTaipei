package com.kanneki.opentaipei.model

import com.google.gson.annotations.SerializedName

data class ResultModel<T : Any> (
    @SerializedName("result")
    val result: BaseModel<T>?
)