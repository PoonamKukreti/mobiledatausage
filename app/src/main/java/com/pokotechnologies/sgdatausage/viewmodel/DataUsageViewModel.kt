package com.pokotechnologies.sgdatausage.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pokotechnologies.sgdatausage.domain.DataUsageUseCase
import com.pokotechnologies.sgdatausage.model.DataUsageResponse
import com.pokotechnologies.sgdatausage.rest.ApiServiceResponse
import com.pokotechnologies.sgdatausage.util.Constants


class DataUsageViewModel : ViewModel() {
    lateinit var resourceId :String


    var apiResponse: ApiServiceResponse? = null

    val allDataUsage: MutableLiveData<DataUsageResponse>
        get() = DataUsageUseCase.getMutableLiveData(
           resourceId
        )

    init {
        apiResponse = ApiServiceResponse()
    }

    fun sendResourceId(resourceId: String) {
        this.resourceId = resourceId
    }
}

