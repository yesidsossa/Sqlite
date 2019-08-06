package com.prueba.sqlite.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prueba.sqlite.Models.Product
import com.prueba.sqlite.R
import kotlinx.android.synthetic.main.product_item.view.*

class ProductsAdapter(val items : List<Product>, val context: Context,val onClickListener: (View, Product) -> Unit) : RecyclerView.Adapter<ViewHolder>(){

    lateinit var listener : View.OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = items[position]

        holder?.tvProducto?.text = items.get(position).name
        holder?.tvPrice?.text = items.get(position).price

        holder.itemView.setOnClickListener {
                view -> onClickListener.invoke(view, producto)
        }
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) , View.OnClickListener {

    // Holds the TextView that will add each animal to
    val tvProducto = view.tvProducto
    val tvPrice = view.tvPrice

    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}