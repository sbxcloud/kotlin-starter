package com.sbxcloud.android.kotlin.ui

import com.sbxcloud.android.kotlin.R
import com.sbxcloud.android.sbxcloudsdk.auth.SbxAuth


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

