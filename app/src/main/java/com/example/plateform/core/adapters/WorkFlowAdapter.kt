package com.example.plateform.core.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.R
import com.example.android.databinding.WorkflowListBinding

class WorkFlowAdapter(
    private val context: Context,
    private var dataList: ArrayList<String>
) :
    RecyclerView.Adapter<WorkFlowAdapter.BindViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder {

        val rootView =
            WorkflowListBinding.inflate(LayoutInflater.from(context), parent, false)

        return BindViewHolder(rootView)

    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(viewHolder: BindViewHolder, position: Int) {
        val item = dataList[position]

        viewHolder.itemBinding.counter.text = item.toString()

        viewHolder.itemBinding.showHideInputStage.setOnClickListener {
            if (viewHolder.itemBinding.workFlowBox.visibility == View.VISIBLE) {
                viewHolder.itemBinding.workFlowBox.visibility = View.GONE
                viewHolder.itemBinding.showHideInputStage.setImageDrawable(context.getDrawable(R.drawable.icon_angle_down))
            } else {
                viewHolder.itemBinding.workFlowBox.visibility = View.VISIBLE
                viewHolder.itemBinding.showHideInputStage.setImageDrawable(context.getDrawable(R.drawable.icon_angle_up))

            }
        }

        viewHolder.itemBinding.showHideDetailintimatetoo.setOnClickListener {
            if (viewHolder.itemBinding.iniatedToo.visibility == View.VISIBLE) {
                viewHolder.itemBinding.iniatedToo.visibility = View.GONE
                viewHolder.itemBinding.showHideDetailintimatetoo.setImageDrawable(context.getDrawable(R.drawable.icon_angle_down))

            } else {
                viewHolder.itemBinding.iniatedToo.visibility = View.VISIBLE
                viewHolder.itemBinding.showHideDetailintimatetoo.setImageDrawable(context.getDrawable(R.drawable.icon_angle_up))

            }
        }

        viewHolder.itemBinding.showHideDetailfeedbacktoo.setOnClickListener {
            if (viewHolder.itemBinding.feedbackList.visibility == View.VISIBLE) {
                viewHolder.itemBinding.feedbackList.visibility = View.GONE
                viewHolder.itemBinding.showHideDetailfeedbacktoo.setImageDrawable(context.getDrawable(R.drawable.icon_angle_down))

            } else {
                viewHolder.itemBinding.feedbackList.visibility = View.VISIBLE
                viewHolder.itemBinding.showHideDetailfeedbacktoo.setImageDrawable(context.getDrawable(R.drawable.icon_angle_up))

            }
        }

        val layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewHolder.itemBinding.feedbackList.layoutManager = layoutManager

        var adapter = FeedBackAdapter(context,dataList)
        viewHolder.itemBinding.feedbackList.adapter = adapter

    }


    class BindViewHolder(val itemBinding: WorkflowListBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

}