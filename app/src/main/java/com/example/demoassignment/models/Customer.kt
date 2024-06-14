package com.example.demoassignment.models

import com.google.gson.annotations.SerializedName

data class Customer(
   @SerializedName("fName") val name: String,
   @SerializedName("isCow") val isCow: Int,
   @SerializedName("isBuffalo") val isBuffalo: Int,
   @SerializedName("mobileNo") val mobileNo: String,

   )
