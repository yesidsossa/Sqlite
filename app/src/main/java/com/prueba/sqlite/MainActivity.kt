package com.prueba.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.prueba.sqlite.DB.DataBaseHandler
import com.prueba.sqlite.Models.Product
import android.content.Intent
import com.prueba.sqlite.Activities.ListActivity


class MainActivity : AppCompatActivity() {

    private lateinit var product : Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHandler = DataBaseHandler(this, null)
        dbHandler.deleteProducts();

        for (i in 1..20) {

            product = Product(i,"Producto"+i,"http://lorempixel.com/500/500/food","Este es el producto numero "+i,"9000")
            dbHandler.addProduct(product)
            Log.d("PRODUCTO","Guardando producto" +i)

        }

        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent);

    }
}
