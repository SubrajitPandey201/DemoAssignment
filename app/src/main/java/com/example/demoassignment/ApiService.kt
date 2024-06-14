package com.example.demoassignment

import com.example.demoassignment.models.CustomerResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
   @GET("/api/CustomerDetails/GetCustomerDetails")
   fun getCustomerDetails(
      @Query("pageno") pageno: Int,
      @Query("pagesize") pagesize: Int,
      @Query("UnitId") unitId: Int
   ): Call<CustomerResponse>
}
