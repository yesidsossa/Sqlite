package com.prueba.sqlite.Models

class Product {

    var id: Int = 0
    var name: String? = null
    var photo: String? = null
    var description: String? = null
    var price: String? = null

    constructor(id: Int, name: String?, photo: String?, description: String?, price: String?) {
        this.id = id
        this.name = name
        this.photo = photo
        this.description = description
        this.price = price
    }

}