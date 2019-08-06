package com.prueba.sqlite.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.prueba.sqlite.Models.Product



class DataBaseHandler(context: Context, factory: SQLiteDatabase.CursorFactory?) :SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {

        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE " +
                TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME + " TEXT," +
                COLUMN_PHOTO + " TEXT," +
                COLUMN_DESCRIPTION + " TEXT," +
                COLUMN_PRICE + " TEXT" +
                ")")

        db.execSQL(CREATE_PRODUCTS_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }
    fun deleteProducts()
    {
        val db = this.writableDatabase
        db.delete(TABLE_NAME,null,null)
        db.close()

    }

    fun addProduct(product: Product) {

        val values = ContentValues()
        values.put(COLUMN_ID, product.id)
        values.put(COLUMN_NAME, product.name)
        values.put(COLUMN_PHOTO, product.photo)
        values.put(COLUMN_DESCRIPTION, product.description)
        values.put(COLUMN_PRICE, product.price)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllProducts(): List<Product> {


        val products: ArrayList<Product> = ArrayList()

        val db = this.readableDatabase
        val c = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

       (1 .. c.count).map {
            c.moveToNext()


           products.add( Product(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4)))


        }
        db.close()
        return products
    }
    fun getAllProductsId(id: String): Product {

        val db = this.readableDatabase
        val campos = arrayOf("id","name", "photo","description","price")
        val args = arrayOf(id)
        val c = db.query("$TABLE_NAME", campos, "id=", args, null, null, null)

        if(c.isFirst)
        {
            c.moveToNext()
          return  Product(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4))
        }

        db.close()
        return  Product(1,"Nombre del producto: Ninguno","http://lorempixel.com/500/500/food","Descripcion:","Precio del producto: 0000")
    }

    companion object {
        private val DATABASE_VERSION = 3
        private val DATABASE_NAME = "purchases.db"
        val TABLE_NAME = "products"
        val COLUMN_ID = "id"
        val COLUMN_NAME = "name"
        val COLUMN_PHOTO = "photo"
        val COLUMN_DESCRIPTION = "description"
        val COLUMN_PRICE = "price"
    }
}