package com.example.demo.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne

@Repository
interface BookRepository: JpaRepository<Book, Int>

@Entity
data class Book (
    @Id
    var Id: Int=1,
    var bookName: String="English",
    var noOfPages: Int=101,
    @ManyToOne
    var author: Author = Author(
        13,
        "Sam"
    ),
    var isbn_no: Int=10,
    var added_on: LocalDateTime= LocalDateTime.now(),
    var Category:ArrayList<String> = ArrayList(),
    //val Category: <String> = mutableListOf<String>()
    )

