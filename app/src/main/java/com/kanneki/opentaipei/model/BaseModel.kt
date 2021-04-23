package com.kanneki.opentaipei.model
import com.google.gson.annotations.SerializedName

data class BaseModel<T: Any>(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("sort")
    val sort: String?,
    @SerializedName("results")
    val results: List<T>
)