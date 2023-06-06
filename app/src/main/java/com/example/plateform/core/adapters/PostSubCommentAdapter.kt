package com.example.plateform.core.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.R
import com.example.plateform.core.model.CommentsSection
import com.example.plateform.core.model.PostDataModel
import com.example.plateform.core.model.SubCommentsSection
import com.example.plateform.utils.CustomTextView


class PostSubCommentAdapter(
    private val context: Context,
    private var dataList: ArrayList<SubCommentsSection>

) :
    RecyclerView.Adapter<PostSubCommentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list_sub_comments,
                null
            )
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder)
        {
            val itemAtPos = dataList[position]
            viewHolder.subCommentorProfileImage?.setImageDrawable(
                ResourcesCompat.getDrawable(
                    context.resources,
                    R.drawable.profile_image_other,
                    null
                )
            )
            viewHolder.subCommentorName?.text = itemAtPos.subCommenterProfileName
            viewHolder.subCommentorTag?.text = itemAtPos.subCommenterProfileTag
            viewHolder.subCommentorComment?.text = itemAtPos.subCommenterComments
            viewHolder.subCommentorLikeCount?.text = itemAtPos.subCommenterCommentsLikesCount.toString()
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var subCommentorProfileImage: ImageView? = itemView.findViewById(R.id.subCommentorProfileImage)
        var subCommentorName: CustomTextView? = itemView.findViewById(R.id.subCommentorName)
        var subCommentorTag: CustomTextView? = itemView.findViewById(R.id.subCommentorTag)
        var subCommentorComment: CustomTextView? = itemView.findViewById(R.id.subCommentorComment)
        var subCommentorLikeCount: CustomTextView? = itemView.findViewById(R.id.subCommentorLikeCount)
    }

//    interface BookingClickListener {
//        fun onBookingClick(position: Int, itemAtPos: String)
//        fun onMissingBagClick(bookingRef: String, bookingJourneyReference: String)
//        fun bagsCounter(arrivalPassengersData: ArrayList<com.project.androidairportr.core.ccd.model.viewjobs.arrivalbookingsummary.response.ArrivalPassengersData>): Int
//    }
}