package com.kanneki.opentaipei.repository

import com.kanneki.opentaipei.model.PlantModel
import com.kanneki.opentaipei.model.ResultModel
import com.kanneki.opentaipei.model.ZooModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenDataTaipei {

    @GET("5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
    fun getZooData(
            @Query("q") searchKey: String,
            @Query("limit") limit: Int? = null,
            @Query("offset") offset: Int? = null,
            @Query("scope") scope: String = "resourceAquire"
    ): Flow<ResultModel<ZooModel>>

    @GET("f18de02f-b6c9-47c0-8cda-50efad621c14")
    fun getPlantData(
            @Query("q") searchKey: String,
            @Query("limit") limit: Int? = null,
            @Query("offset") offset: Int? = null,
            @Query("scope") scope: String = "resourceAquire"
    ): Flow<ResultModel<PlantModel>>
}