package com.example.plateform.core.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.BR
import com.example.android.R
import com.example.android.databinding.ActivitySearchListBinding
import com.example.plateform.core.interfaces.CustomerActivityInterface
import com.example.plateform.core.model.ItemList
import com.kaopiz.kprogresshud.KProgressHUD
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerListActivity : AppCompatActivity(), CustomerActivityInterface {

    private lateinit var binding: ActivitySearchListBinding
    open lateinit var loaderDialog: KProgressHUD

    private var itemList = mutableListOf<ItemList>()
    private lateinit var customerList: ArrayList<String>
    private var workFlowList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_list)
        binding.setVariable(BR.data, itemList)
        binding.setVariable(BR.onClick, this)

        customerList = intent.getStringArrayListExtra("data")!!

        initView()
        setUpRecyclerViewForCustomer()
        setUpRecyclerViewForWorkFlow()
    }

    fun initView() {
        loaderDialog = KProgressHUD(this)
        workFlowList.add("1")
        workFlowList.add("2")
        workFlowList.add("3")
        workFlowList.add("4")

    }

    private fun setUpRecyclerViewForCustomer() {
        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.customerRev.layoutManager = layoutManager
        binding.setVariable(BR.data, customerList)
    }
     private fun setUpRecyclerViewForWorkFlow() {
        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.customerRev.layoutManager = layoutManager
        binding.setVariable(BR.workFlowData, workFlowList)
    }

    override fun onCustomerCLick(customerName: String) {
        val intent = Intent(this, FormActivity::class.java)
        startActivity(intent)
    }


    override fun onBackClick() {
        finish()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}