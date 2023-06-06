package com.example.plateform.core.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class PostDataArrayModel(
    @SerializedName("postDataArrayList")
    var postDataArrayList: ArrayList<PostDataModel> = ArrayList()
) : Parcelable