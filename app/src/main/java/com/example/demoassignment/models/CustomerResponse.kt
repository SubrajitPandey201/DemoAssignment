package com.example.demoassignment.models

import com.google.gson.annotations.SerializedName

data class CustomerResponse(
   @SerializedName("responseData") val data: List<Customer>,
   @SerializedName("total") val total: Int
)
