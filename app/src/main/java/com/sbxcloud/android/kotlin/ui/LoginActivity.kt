package com.sbxcloud.android.kotlin.ui

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.sbxcloud.android.kotlin.R
import com.sbxcloud.android.kotlin.databinding.ActivityLoginBinding
import com.sbxcloud.android.kotlin.model.User
import com.sbxcloud.android.sbxcloudsdk.net.callback.SbxSimpleResponse
import java.lang.Exception
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val binding: ActivityLoginBinding by lazy {
        DataBindingUtil.setContentView<ActivityLoginBinding>(this,R.layout.activity_login);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.user=User.getCurrentUser();
        binding.buttonSignup.setOnClickListener { view ->
                User.getCurrentUser().
                logInBackground( object : SbxSimpleResponse<User>{
            override fun onSuccess (user: User? ){ runOnUiThread { Toast.makeText(this@LoginActivity,resources.getString(R.string.sbx_login_success_message), Toast.LENGTH_LONG).show() } }
            override fun onError(e: Exception) { runOnUiThread { Toast.makeText(this@LoginActivity,e.message, Toast.LENGTH_LONG).show() } }
        } ) }
    }


}
