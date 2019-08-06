package com.prueba.sqlite.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prueba.sqlite.DB.DataBaseHandler
import com.prueba.sqlite.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dbHandler = DataBaseHandler(this, null)
        var producto = dbHandler.getAllProductsId("1")

        Picasso
            .with(this)
            .load(producto.photo)
            .into(imgDetail)
        tvName.text = producto.name
        tvPrice.text = producto.price
        tvDescription.text = producto.description



    }
}
