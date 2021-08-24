package com.example.claseinicial

public open class Book {
    var title: String?
    var author: String?
    var genre: String?
    var description: String
    var existence: Int? = 0


    constructor(title: String?, author: String?, genre: String?, description: String, existence: Int?) {
        this.title = title
        this.author = author
        this.genre = genre
        this.description = description
        this.existence = existence
    }
}