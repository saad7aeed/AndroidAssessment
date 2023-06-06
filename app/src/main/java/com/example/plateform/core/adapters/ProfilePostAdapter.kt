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
import com.example.plateform.core.model.PostDataModel
import com.example.plateform.utils.CustomTextView


class ProfilePostAdapter(
    private val context: Context,
    private var dataList: ArrayList<PostDataModel>

) :
    RecyclerView.Adapter<ProfilePostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list,
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
            viewHolder.profileImage?.setImageDrawable(
                ResourcesCompat.getDrawable(
                    context.resources,
                    R.drawable.profile_image,
                    null
                )
            )
            viewHolder.profileName?.text = itemAtPos.profileName
            viewHolder.profileCMKG?.text = itemAtPos.profileWithCm+itemAtPos.profileWithKg
            if (itemAtPos.profileWithTick){
                viewHolder.profileWithTick?.visibility = View.VISIBLE
            }else{
                viewHolder.profileWithTick?.visibility = View.GONE
            }
            viewHolder.profileTag?.text = itemAtPos.profileWithTagMsg
            viewHolder.profileGreenTagMessage?.text = itemAtPos.greenTagMessage
            viewHolder.postTitle?.text = itemAtPos.titleMessage
            viewHolder.postDes?.text = itemAtPos.descriptionMessage
            viewHolder.postImage?.setImageDrawable(
                ResourcesCompat.getDrawable(
                    context.resources,
                    R.drawable.post_image,
                    null
                )
            )
            viewHolder.likesCount?.text = itemAtPos.likeCount.toString()
            viewHolder.commentsCount?.text = itemAtPos.commentsCount.toString()

            val layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            viewHolder.commentSection?.layoutManager = layoutManager
            val bagDetailsAdapter =
                PostCommentAdapter(
                            context,
                            itemAtPos.comments
                        )
            viewHolder.commentSection?.adapter = bagDetailsAdapter

//            val layoutManager1 =
//                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//            rvBagsUnSigned?.layoutManager = layoutManager1
//            val bagDetailsAdapterUnsigned =
//                CcdCollectionMorePassengerBagsAdapter(context, itemAtPos.arrivalPassengersData)
//            rvBagsUnSigned?.adapter = bagDetailsAdapterUnsigned
//
//            Log.d("SET", "DATA")
//
//            rvBagsUnSigned?.visibility = View.GONE
//            moreBagsBox?.setOnClickListener {
//                if (rvBagsUnSigned?.visibility == View.VISIBLE) {
//                    rvBagsUnSigned?.visibility = View.GONE
//                    dropDownArrow?.setImageResource(R.drawable.dropdown)
//                } else {
//                    rvBagsUnSigned?.visibility = View.VISIBLE
//                    dropDownArrow?.setImageResource(R.drawable.dropup)
//                }
//            }
//            missingBagsBox?.setOnClickListener {
//                itemAtPos.bookingReference?.let { it1 ->
//                    itemAtPos.bookingJourneyReference?.let { it2 ->
//                        bookingClick.onMissingBagClick(
//                            it1,
//                            it2
//                        )
//                    }
//                }
//            }
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var profileImage: ImageView? = itemView.findViewById(R.id.profileImage)
        var profileName: CustomTextView? = itemView.findViewById(R.id.profileName)
        var profileCMKG: CustomTextView? = itemView.findViewById(R.id.profileCMKG)
        var profileWithTick: ImageView? = itemView.findViewById(R.id.profileWithTick)
        var profileTag: CustomTextView? = itemView.findViewById(R.id.profileTag)
        var profileGreenTagMessage: CustomTextView? = itemView.findViewById(R.id.profileGreenTagMessage)
        var postTitle: CustomTextView? = itemView.findViewById(R.id.postTitle)
        var postDes: CustomTextView? = itemView.findViewById(R.id.postDes)
        var postImage: ImageView? = itemView.findViewById(R.id.postImage)
        var likesCount: CustomTextView? = itemView.findViewById(R.id.likesCount)
        var commentsCount: CustomTextView? = itemView.findViewById(R.id.commentsCount)
        var commentSection: RecyclerView? = itemView.findViewById(R.id.commentSection)
    }

//    interface BookingClickListener {
//        fun onBookingClick(position: Int, itemAtPos: String)
//        fun onMissingBagClick(bookingRef: String, bookingJourneyReference: String)
//        fun bagsCounter(arrivalPassengersData: ArrayList<com.project.androidairportr.core.ccd.model.viewjobs.arrivalbookingsummary.response.ArrivalPassengersData>): Int
//    }
}