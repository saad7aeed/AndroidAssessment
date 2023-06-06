package com.example.plateform.data.remote

import com.example.plateform.core.model.SearchListModel
import com.example.plateform.utils.AppConstants
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET(AppConstants.GET_SEARCH_DETAIL)
    suspend fun getSpecificSearchDetails(
        @Query("q") searchReference: String,
    ): Response<SearchListModel>

}