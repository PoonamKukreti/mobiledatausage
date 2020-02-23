package com.pokotechnologies.sgdatausage.domain

import androidx.lifecycle.MutableLiveData
import com.pokotechnologies.sgdatausage.model.DataUsageResponse
import com.pokotechnologies.sgdatausage.model.YearDataUsage
import com.pokotechnologies.sgdatausage.rest.ApiServiceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Double

object DataUsageUseCase {
    private val mutableLiveData = MutableLiveData<DataUsageResponse>()

    fun getMutableLiveData(resourceId: String): MutableLiveData<DataUsageResponse> {
        val apiService = ApiServiceResponse.create()
        var call = apiService.getMobileDataUsage(
            resourceId,
            "5"
        )
        call.enqueue(object : Callback<DataUsageResponse> {
            override fun onResponse(call: Call<DataUsageResponse>, response: Response<DataUsageResponse>) {
                val apiResponse = response.body()

                val resultList = response.body()!!.data?.recordList

                for (record in resultList!!) {

                    val parts = record.quarter?.split("-")

                    try {
                        val year = parts?.get(0)?.let { Integer.parseInt(it) }
                        val quarter = parts?.get(1)

                        if (year != null) {
                            if (year > 2007) {

                                val yearDataUsage = YearDataUsage()
                                yearDataUsage.year = year

                                /*val quarterUsage = QuarterUsage()
                                quarterUsage.quarter = quarter
                                quarterUsage.usage = record.dataVolume?.let { Double.parseDouble(it) }
                                quarter?.let { yearDataUsage.setDataForQuarter(it, quarterUsage) }

                                var isExists = false
                                for (yearRecord in resultList) {
                                    if (yearRecord.year === year) {
                                        isExists = true
                                        yearRecord.da(quarter, quarterUsage)
                                    }
                                }

                                if (!isExists) {
                                    mDataUsageList.add(yearDataUsage)
                                }
*/
                            }
                        }

                    } catch (e: NumberFormatException) {

                    } catch (e: IllegalArgumentException) {

                    }

                }
                mutableLiveData.value = apiResponse
            }

            override fun onFailure(call: Call<DataUsageResponse>, t: Throwable) {
            }
        })
        return mutableLiveData
    }

}
