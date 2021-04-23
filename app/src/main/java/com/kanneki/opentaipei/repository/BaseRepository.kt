package com.kanneki.opentaipei.repository

import me.sianaki.flowretrofitadapter.FlowCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class BaseRepository {

    private val TIMEOUT_NUMBER = 30L

    fun okhttpClient() = OkHttpClient().newBuilder()
        .connectTimeout(TIMEOUT_NUMBER, TimeUnit.SECONDS)
        .build()

    fun retrofitClient(baseUrl: String) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(FlowCallAdapterFactory.create())
        .client(okhttpClient())
        .build()
}