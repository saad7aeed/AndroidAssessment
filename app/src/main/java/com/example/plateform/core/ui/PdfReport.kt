package com.example.plateform.core.ui

import android.os.Build
import android.os.Bundle
import android.print.PrintAttributes
import android.print.PrintDocumentAdapter
import android.print.PrintManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.android.R
import com.example.android.databinding.ActivityPdfReportBinding
import java.io.File

class PdfReport : AppCompatActivity() {
    private lateinit var binding: ActivityPdfReportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfReportBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPrintRep.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                val printManager = getSystemService(PRINT_SERVICE) as PrintManager
                val printAdapter: PrintDocumentAdapter =
                    binding.productqualityAPL.createPrintDocumentAdapter()
                val jobName = getString(R.string.app_name) + " Print Test"
                printManager.print(
                    jobName, printAdapter,
                    PrintAttributes.Builder().build()
                )
            }
        }

        initView()
    }

    fun initView(){
        binding.productqualityAPL.loadUrl("file:///android_asset/index.html")
        binding.productqualityAPL.addJavascriptInterface(this, "android")

        binding.productqualityAPL.settings.javaScriptEnabled = true
        binding.productqualityAPL.settings.builtInZoomControls = true
    }

//    fun createDIR() {
//        val folder: File =
//            File(AnnotationTarget.FILE)
//        var success = true
//        if (!folder.exists()) {
//            success = folder.mkdirs()
//        }
//        if (success) {
//            // Do something on success
//            Log.d("If", "Create")
//        } else {
//            // Do something else on failure
//            Log.d("Else", "Not Create")
//        }
//    }
}