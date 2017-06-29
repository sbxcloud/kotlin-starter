package com.sbxcloud.android.kotlin.ui

import android.databinding.Bindable
import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.sbxcloud.android.kotlin.R
import com.sbxcloud.android.kotlin.databinding.ActivityLoginBinding
import com.sbxcloud.android.kotlin.model.User
import com.sbxcloud.android.sbxcloudsdk.net.callback.SbxSimpleResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import java.lang.Exception
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    val loginView: ObservableField<Boolean> = ObservableField<Boolean>()
    val loading: ObservableField<Boolean> = ObservableField<Boolean>()
    val binding: ActivityLoginBinding by lazy {
        DataBindingUtil.setContentView<ActivityLoginBinding>(this,R.layout.activity_login);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.user=User.getCurrentUser()
        binding.activity=this
        iniUi();
    }

    fun iniUi(){
        loginView.set(true)
        loading.set(false)
        setSupportActionBar(binding.loginToolbar)
        toogle()
    }

    fun buttonAction(view: View){
        if(loginView.get()){
            User.getCurrentUser().logIn(User::class.java)
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { loading.set(true)  }
                    .doFinally { loading.set(false) }
                    .subscribe(Consumer { showToast(R.string.sbx_login_success_message) }, Consumer { t -> showToast(t.message) })

        }else{
            User.getCurrentUser().signUp(User::class.java)
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe {loading.set(true)  }
                    .doFinally { loading.set(false) }
                    .subscribe(Consumer { showToast(R.string.sbx_sign_success_message) }, Consumer { t -> showToast(t.message) })
        }
    }

    fun linkAction(view: View){
        TransitionManager.beginDelayedTransition(binding.linearContainer)
        loginView.set(false)
        toogle()
    }

    /**
     * To show <- on Toolbar
     */
    fun toogle(){
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(!loginView.get())
        getSupportActionBar()?.setDisplayShowHomeEnabled(!loginView.get())
    }

    /**
     * to back Login
     */
    override fun onSupportNavigateUp(): Boolean {
        TransitionManager.beginDelayedTransition(binding.linearContainer)
        loginView.set(true)
        toogle()
        return true;
    }

}
