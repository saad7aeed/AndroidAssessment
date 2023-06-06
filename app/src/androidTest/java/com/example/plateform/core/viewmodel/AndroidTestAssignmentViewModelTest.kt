package com.example.plateform.core.viewmodel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.plateform.core.repo.AndroidTestAssignmentRepo
import com.example.plateform.data.remote.ApiService
import com.example.plateform.data.remote.RemoteDataSource
import com.example.plateform.utils.AppConstants
import com.google.gson.GsonBuilder
import junit.framework.TestCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@RunWith(AndroidJUnit4::class)
class AndroidTestAssignmentViewModelTest: TestCase(){

    private lateinit var viewModel: AndroidTestAssignmentViewModel
    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    @Before
    public override fun setUp() {
        super.setUp()

        val context = ApplicationProvider.getApplicationContext<Context>()
        val gson= GsonBuilder().create()
        val client = OkHttpClient.Builder().build()
        val retrofit =
            Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        val apiService : ApiService = retrofit.create(ApiService::class.java)
        val remoteDataSource = RemoteDataSource(apiService)
        val repo = AndroidTestAssignmentRepo(remoteDataSource)
        viewModel = AndroidTestAssignmentViewModel(repo)

    }

    @Test
    fun testViewModelWithValidData(){
        var searchWord = "foo"
        GlobalScope.launch {
            viewModel.setSearchReference(searchWord)
        }
    }

    @Test
    fun testViewModelWithInValidData(){
        var searchWord = ""
        GlobalScope.launch {
            viewModel.setSearchReference(searchWord)
        }
    }


}