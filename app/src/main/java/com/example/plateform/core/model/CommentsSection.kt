package com.example.plateform.core.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class CommentsSection(
    @SerializedName("commenterProfileImageUrl")
    var commenterProfileImageUrl: String? = null,
    @SerializedName("commenterProfileName")
    var commenterProfileName: String? = null,
    @SerializedName("commenterProfileWithTick")
    var commenterProfileWithTick: Boolean = false,
    @SerializedName("commenterProfileTag")
    var commenterProfileTag: String? = null,
    @SerializedName("commenterComment")
    var commenterComment: String? = null,
    @SerializedName("commenterCommentsLikesCount")
    var commenterCommentsLikesCount: Int = 0,
    @SerializedName("commenterCommentsCounts")
    var commenterCommentsCounts: Int = 0,
    @SerializedName("subCommentsSection")
    var subCommentsSection: ArrayList<SubCommentsSection> = ArrayList()
) : Parcelable