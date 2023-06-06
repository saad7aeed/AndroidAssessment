package com.example.plateform.utils.databindingutlis

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.plateform.core.adapters.CustomerListAdapter
import com.example.plateform.core.adapters.FeedBackAdapter
import com.example.plateform.core.adapters.WorkFlowAdapter
import kotlin.collections.ArrayList

@BindingAdapter("customerList")
fun bindingRecyclerViewCustomerList(
    view: RecyclerView,
    dataList: ArrayList<String>?
) {
    if (dataList?.isEmpty() == true)
        return
    val layoutManager = view.layoutManager
    if (layoutManager == null)
        view.layoutManager = LinearLayoutManager(view.context)
    var adapter = view.adapter
    if (adapter == null) {
        adapter = dataList?.let {
           CustomerListAdapter(view.context, it)
        }
        view.adapter = adapter
    }
}

@BindingAdapter("workFlowList")
fun bindingRecyclerViewWorkFlowList(
    view: RecyclerView,
    dataList: ArrayList<String>?
) {
    if (dataList?.isEmpty() == true)
        return
    val layoutManager = view.layoutManager
    if (layoutManager == null)
        view.layoutManager = LinearLayoutManager(view.context)
    var adapter = view.adapter
    if (adapter == null) {
        adapter = dataList?.let {
            WorkFlowAdapter(view.context, it)
        }
        view.adapter = adapter
    }
}

@BindingAdapter("feedBackList")
fun bindingRecyclerViewFeedBackList(
    view: RecyclerView,
    dataList: ArrayList<String>?
) {
    if (dataList?.isEmpty() == true)
        return
    val layoutManager = view.layoutManager
    if (layoutManager == null)
        view.layoutManager = LinearLayoutManager(view.context)
    var adapter = view.adapter
    if (adapter == null) {
        adapter = dataList?.let {
            FeedBackAdapter(view.context, it)
        }
        view.adapter = adapter
    }
}
