package com.prueba.sqlite.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prueba.sqlite.Adapters.ProductsAdapter
import com.prueba.sqlite.DB.DataBaseHandler
import com.prueba.sqlite.Models.Product
import com.prueba.sqlite.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    var adapter : ProductsAdapter? = null
    lateinit var listProducts : List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val dbHandler = DataBaseHandler(this, null)
        listProducts = dbHandler.getAllProducts()

        adapter = ProductsAdapter(dbHandler.getAllProducts(), this, { view, category -> openActivity(view, category) })

        ListRecyclerView.layoutManager = LinearLayoutManager(this)
        ListRecyclerView.adapter = adapter
    }

    private fun openActivity(view: View, product: Product) {
        Toast.makeText(this, "Nombre:" + product.name, Toast.LENGTH_LONG).show()

        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }


}
