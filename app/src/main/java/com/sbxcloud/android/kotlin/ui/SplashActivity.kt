package com.sbxcloud.android.kotlin.ui

import android.util.Log
import com.sbxcloud.android.kotlin.R
import com.sbxcloud.android.sbxcloudsdk.auth.SbxAuth
import com.sbxcloud.android.sbxcloudsdk.net.callback.SbxSimpleResponse
import com.sbxcloud.android.sbxcloudsdk.net.cloudscript.SbxCloudScript
import org.json.JSONObject
import java.lang.Exception


/**
 * Created by lgguzman on 29/05/17.
 */

class SplashActivity() : BaseActivity(){

    override fun onCreate(savedInstanceState: android.os.Bundle? ) {
        super.onCreate(savedInstanceState);
        val intent = android.content.Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}

