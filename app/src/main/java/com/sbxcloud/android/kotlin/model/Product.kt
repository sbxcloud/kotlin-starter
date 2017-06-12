package com.sbxcloud.android.kotlin.model


import com.sbxcloud.android.sbxcloudsdk.net.observable.SbxModelObservable
import com.sbxcloud.android.sbxcloudsdk.query.annotation.SbxParamField

/**
 * Created by lgguzman on 29/05/17.
 */
class Product ():SbxModelObservable(){

@SbxParamField
    var name: String?=null;

}