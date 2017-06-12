package com.sbxcloud.android.kotlin.model


import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR
import com.sbxcloud.android.sbxcloudsdk.auth.user.*
import com.sbxcloud.android.sbxcloudsdk.net.auth.SbxUser
import com.sbxcloud.android.sbxcloudsdk.net.observable.SbxUserObservable

/**
 * Created by lgguzman on 29/05/17.
 */
class User () : SbxUserObservable(){

    @SbxNameField
    @get:Bindable
    var name: String=""

    @SbxUsernameField
    @get:Bindable
    var username: String?=null;

    @SbxEmailField
    @get:Bindable
    var email: String=""
        set(value) {
            field = value;
            notifyPropertyChanged(BR.email)
        }

    @SbxPasswordField
    @get:Bindable
    var password: String=""
        set(value) {
            field = value;
            notifyPropertyChanged(BR.email)
        }

    @SbxAuthToken
    var token: String?=null

    constructor(name: String, username: String,email: String,  password: String):this(){
        this.name=name;
        this.username=username;
        this.email=email;
        this.password=password;
    }

    companion object{
        @JvmStatic fun getCurrentUser():User {
            return SbxUser.getCurrentSbxUser(User::class.java) as? User?:user;

        }
        @JvmField
        var user: User = User();
    }


    fun isLogged(): Boolean{
        return User.getCurrentUser().token == null;
    }



}