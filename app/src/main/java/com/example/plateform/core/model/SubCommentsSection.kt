package com.example.plateform.core.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class SubCommentsSection(
    @SerializedName("subCommenterProfileImageUrl")
    var subCommenterProfileImageUrl: String? = null,
    @SerializedName("subCommenterProfileName")
    var subCommenterProfileName: String? = null,
    @SerializedName("subCommenterProfileWithTick")
    var subCommenterProfileWithTick: Boolean = false,
    @SerializedName("subCommenterProfileTag")
    var subCommenterProfileTag: String? = null,
    @SerializedName("subCommenterComments")
    var subCommenterComments: String? = null,
    @SerializedName("subCommenterCommentsLikesCount")
    var subCommenterCommentsLikesCount: Int = 0,
    @SerializedName("subCommenterCommentsSubCommentsCount")
    var subCommenterCommentsSubCommentsCount: Int = 0
) : Parcelable