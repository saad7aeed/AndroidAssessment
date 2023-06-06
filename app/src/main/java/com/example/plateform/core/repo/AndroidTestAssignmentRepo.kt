package com.example.plateform.core.repo

import com.example.plateform.data.remote.RemoteDataSource
import com.example.plateform.data.remote.performGetOperation
import javax.inject.Inject

class AndroidTestAssignmentRepo@Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) {
    fun getSpecificSearchDetails(searchReference: String) =
        performGetOperation(
            networkCall = { remoteDataSource.getSpecificSearchDetails(searchReference) }
        )
}