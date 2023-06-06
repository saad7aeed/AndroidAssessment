package com.example.plateform.core.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class PostDataModel(
    @SerializedName("profileImage")
    var profileImage: String? = null,
    @SerializedName("profileName")
    var profileName: String? = null,
    @SerializedName("profileWithTick")
    var profileWithTick: Boolean = false,
    @SerializedName("profileWithCm")
    var profileWithCm: String? = null,
    @SerializedName("profileWithKg")
    var profileWithKg: String? = null,
    @SerializedName("profileWithTagMsg")
    var profileWithTagMsg: String? = null,
    @SerializedName("greenTagMessage")
    var greenTagMessage: String? = null,
    @SerializedName("titleMessage")
    var titleMessage: String? = null,
    @SerializedName("descriptionMessage")
    var descriptionMessage: String? = null,
    @SerializedName("postImageUrl")
    var postImageUrl: String? = null,
    @SerializedName("likeCount")
    var likeCount: Int = 0,
    @SerializedName("commentsCount")
    var commentsCount: Int = 0,
    @SerializedName("comments")
    var comments: ArrayList<CommentsSection> = ArrayList()
) : Parcelable