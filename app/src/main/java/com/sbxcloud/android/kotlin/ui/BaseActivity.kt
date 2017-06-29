package com.sbxcloud.android.kotlin.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.IntegerRes
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.sbxcloud.android.kotlin.R
import com.sbxcloud.android.sbxcloudsdk.auth.SbxAuth

/**
 * Created by lgguzman on 29/05/17.
 */
open class BaseActivity  : android.support.v7.app.AppCompatActivity(){

    var progressBar:  ProgressBar?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SbxAuth.initializeIfIsNecessary(this@BaseActivity,resources.getString(R.string.sbx_domain).toInt(),resources.getString(R.string.sbx_app_key));
    }

    fun showToast(id:Int){
        Toast.makeText(this@BaseActivity, resources.getString(id), Toast.LENGTH_LONG).show()
    }

    fun showToast(message:String?){
        Toast.makeText(this@BaseActivity, message, Toast.LENGTH_LONG).show()
    }



}