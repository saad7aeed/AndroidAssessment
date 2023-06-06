package com.example.plateform.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.plateform.core.model.SearchListModel
import com.example.plateform.core.repo.AndroidTestAssignmentRepo
import com.example.plateform.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidTestAssignmentViewModel @Inject constructor(
    private val androidTestAssignmentRepo: AndroidTestAssignmentRepo,
) : ViewModel() {

    private val _searchReference = MutableLiveData<String>()


    private val searchDetail = _searchReference.switchMap { token ->
        androidTestAssignmentRepo.getSpecificSearchDetails(token)
    }


    //LiveData
    val androidTestAssignmentResp: LiveData<Resource<SearchListModel>> = searchDetail


    //Functions
    fun setSearchReference(
        searchRef: String
    ) {
        _searchReference.value = searchRef
    }
}