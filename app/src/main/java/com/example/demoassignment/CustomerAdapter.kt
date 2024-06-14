package com.example.demoassignment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoassignment.models.Customer
import com.squareup.picasso.Picasso

class CustomerAdapter(private val customers: List<Customer>) : RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

   class CustomerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      val nameTextView: TextView = itemView.findViewById(R.id.customerName)
      val animalImageView: ImageView = itemView.findViewById(R.id.animalImage)
      val mobileNoTextView : TextView = itemView.findViewById(R.id.mobileNumber)
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_customer, parent, false)
      return CustomerViewHolder(view)
   }

   override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
      val customer = customers[position]
      holder.nameTextView.text = customer.name
      holder.mobileNoTextView.text = customer.mobileNo
      holder.nameTextView.setTextColor(when (position % 3) {
         0 -> android.graphics.Color.RED
         1 -> android.graphics.Color.GREEN
         else -> android.graphics.Color.BLUE
      })

      val imageRes = if (customer.isCow == 1) R.drawable.cow else R.drawable.buffalo
      Picasso.get().load(imageRes).into(holder.animalImageView)
   }

   override fun getItemCount() = customers.size
}
