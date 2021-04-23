package com.kanneki.opentaipei.ui.zoolist

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanneki.opentaipei.R
import com.kanneki.opentaipei.model.ZooModel
import com.kanneki.opentaipei.repository.BaseRepository
import com.kanneki.opentaipei.repository.OpenDataTaipei
import com.kanneki.opentaipei.utils.BaseUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class ZooListViewModel : ViewModel() {

    private val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val getErrorMessage: LiveData<Int> get() = errorMessage
    val data: ObservableArrayList<ZooModel> = ObservableArrayList()
    val repository: OpenDataTaipei by lazy {

        BaseRepository()
                .retrofitClient(BaseUrl.baseUrl)
                .create(OpenDataTaipei::class.java)
    }

    fun searchData(searchKey: String = "") {
        viewModelScope.launch {
            repository.getZooData(searchKey)
                    .flowOn(Dispatchers.IO)
                    .catch {

                        errorMessage.postValue(R.string.noInternet)
                    }
                    .collect { result ->
                        data.clear()
                        result.result?.results?.let {

                            data.addAll(it)
                        }
                    }
        }
    }
}