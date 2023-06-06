package com.example.plateform.core.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.databinding.ActivityMainBinding
import com.example.plateform.core.adapters.CustomerAdapter
import com.jaredrummler.materialspinner.MaterialSpinner
import dagger.hilt.android.AndroidEntryPoint
import showSnackBar

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var customerData = ArrayList<String>()
    private var selectedCustomerData = ArrayList<String>()
    private lateinit var customerAdapter: CustomerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    fun initView() {
        binding.btnSearch.setOnClickListener(this)
        customerData.add("Please Select Customer")
        customerData.add("Customer 1")
        customerData.add("Customer 2")
        customerData.add("Customer 3")
        customerData.add("Customer 4")
        binding.spinnerCustomers.setItems(customerData)
        binding.spinnerCustomers.setOnItemSelectedListener { view, position, id, item ->
            if (!selectedCustomerData.contains(customerData.get(position))) {
                selectedCustomerData.add(customerData.get(position))
                setUpRecyclerViewCustomers(binding.recyclerList,selectedCustomerData)
            } else {
                showSnackBar("Aleardy Added", window.decorView)
            }
        }

    }

    private fun setUpRecyclerViewCustomers(rvCustomer: RecyclerView?, list:ArrayList<String>) {
        rvCustomer?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        customerAdapter = CustomerAdapter(this, list)
        rvCustomer?.adapter = customerAdapter
    }


    override fun onClick(v: View?) {
        when (v) {
            binding.btnSearch -> {
                goNext(selectedCustomerData)
            }
        }
    }

    private fun goNext(customerData: ArrayList<String>) {
        val intent = Intent(this, CustomerListActivity::class.java)
        intent.putStringArrayListExtra("data", customerData)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        Log.d("OnResume", "Called")
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}