package com.sistemas51.horarioslavalle.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sistemas51.horarioslavalle.api.RetrofitBuilder
import com.sistemas51.horarioslavalle.repository.HourRepository
import com.sistemas51.horarioslavalle.resource.Resource
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    val apiRequest = HourRepository(RetrofitBuilder.buildService())
    var liveData = MutableLiveData<Resource<String>>()

    fun requestHours(){
    viewModelScope.launch {
        liveData.postValue(Resource.loading())
        try {
          liveData.postValue(Resource.success(data = apiRequest.getHours()))
        }catch (e: Exception){
            liveData.postValue(Resource.error(e.message,e.message))
        }
    }

    }

}