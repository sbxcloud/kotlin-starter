package com.sbxcloud.android.kotlin.model

import com.sbxcloud.android.kotlin.binding.SbxModelBinding
import com.sbxcloud.android.sbxcloudsdk.query.annotation.SbxParamField

/**
 * Created by lgguzman on 29/05/17.
 */
class Product ():SbxModelBinding(){

@SbxParamField
    var name: String?=null;

}