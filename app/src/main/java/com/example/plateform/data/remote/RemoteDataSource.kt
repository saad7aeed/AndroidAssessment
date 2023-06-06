package com.example.plateform.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService,
) : BaseDataSource() {

    suspend fun getSpecificSearchDetails(searchReference: String) =
        getResult {
            apiService.getSpecificSearchDetails(searchReference)
        }
}