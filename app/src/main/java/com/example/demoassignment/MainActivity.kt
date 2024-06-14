package com.example.demoassignment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoassignment.models.Customer
import com.example.demoassignment.models.CustomerResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

   private lateinit var recyclerView: RecyclerView
   private lateinit var adapter: CustomerAdapter
   private var customerList: List<Customer> = listOf()

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)

      recyclerView = findViewById(R.id.recyclerView)
      recyclerView.layoutManager = LinearLayoutManager(this)

      fetchCustomers()

      val searchView: android.widget.EditText = findViewById(R.id.searchView)
      searchView.addTextChangedListener(object : TextWatcher {
         override fun afterTextChanged(s: Editable?) {
            filter(s.toString())
         }

         override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

         override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
      })
   }

   private fun fetchCustomers() {
      RetrofitClient.apiService.getCustomerDetails(1, 10, 787).enqueue(object : Callback<CustomerResponse> {
         override fun onResponse(call: Call<CustomerResponse>, response: Response<CustomerResponse>) {
            if (response.isSuccessful) {
               Log.e("response" , response.toString())
               customerList = response.body()?.data ?: listOf()
               adapter = CustomerAdapter(customerList)
               recyclerView.adapter = adapter
               Log.e("customer" , customerList.toString())
            }
         }

         override fun onFailure(call: Call<CustomerResponse>, t: Throwable) {
            // Handle failure
            Log.d("response failed" , "failed")
         }
      })
   }

   private fun filter(text: String) {
      val filteredList = customerList.filter { it.name.contains(text, true) }
      adapter = CustomerAdapter(filteredList)
      recyclerView.adapter = adapter
   }
}
