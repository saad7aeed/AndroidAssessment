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
import com.example.plateform.utils.CustomTextView


class PostCommentAdapter(
    private val context: Context,
    private var dataList: ArrayList<CommentsSection>

) :
    RecyclerView.Adapter<PostCommentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list_comments,
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
            viewHolder.commentorProfileImage?.setImageDrawable(
                ResourcesCompat.getDrawable(
                    context.resources,
                    R.drawable.profile_image_other,
                    null
                )
            )
            viewHolder.commentorName?.text = itemAtPos.commenterProfileName
            viewHolder.commentorName?.text = itemAtPos.commenterProfileName
            if (itemAtPos.commenterProfileWithTick){
                viewHolder.commentorGreenTick?.visibility = View.VISIBLE
            }else{
                viewHolder.commentorGreenTick?.visibility = View.GONE
            }
            viewHolder.commentorTag?.text = itemAtPos.commenterProfileTag
            viewHolder.commentorComment?.text = itemAtPos.commenterComment
            viewHolder.commentorLikeCount?.text = itemAtPos.commenterCommentsLikesCount.toString()
            viewHolder.commentorCommentCount?.text = itemAtPos.commenterCommentsCounts.toString()

            val layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            viewHolder.subCommentSection?.layoutManager = layoutManager
            val bagDetailsAdapter =
                        PostSubCommentAdapter(
                            context,
                            itemAtPos.subCommentsSection,
                        )
            viewHolder.subCommentSection?.adapter = bagDetailsAdapter
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var commentorProfileImage: ImageView? = itemView.findViewById(R.id.commentorProfileImage)
        var commentorName: CustomTextView? = itemView.findViewById(R.id.commentorName)
        var commentorGreenTick: ImageView? = itemView.findViewById(R.id.commentorGreenTick)
        var commentorTag: CustomTextView? = itemView.findViewById(R.id.commentorTag)
        var commentorComment: CustomTextView? = itemView.findViewById(R.id.commentorComment)
        var commentorLikeCount: CustomTextView? = itemView.findViewById(R.id.commentorLikeCount)
        var commentorCommentCount: CustomTextView? = itemView.findViewById(R.id.commentorCommentCount)
        var subCommentSection: RecyclerView? = itemView.findViewById(R.id.subCommentSection)
    }

//    interface BookingClickListener {
//        fun onBookingClick(position: Int, itemAtPos: String)
//        fun onMissingBagClick(bookingRef: String, bookingJourneyReference: String)
//        fun bagsCounter(arrivalPassengersData: ArrayList<com.project.androidairportr.core.ccd.model.viewjobs.arrivalbookingsummary.response.ArrivalPassengersData>): Int
//    }
}