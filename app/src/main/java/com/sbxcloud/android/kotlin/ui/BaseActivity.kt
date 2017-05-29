package com.sbxcloud.android.kotlin.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.sbxcloud.android.kotlin.R
import com.sbxcloud.android.sbxcloudsdk.auth.SbxAuth

/**
 * Created by lgguzman on 29/05/17.
 */
open class BaseActivity  : android.support.v7.app.AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SbxAuth.initializeIfIsNecessary(this@BaseActivity,resources.getString(R.string.sbx_domain).toInt(),resources.getString(R.string.sbx_app_key));
    }
}