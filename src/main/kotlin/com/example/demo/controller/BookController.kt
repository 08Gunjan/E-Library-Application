package com.example.demo.controller

import com.example.demo.model.Book
import com.example.demo.service.BookService
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")

class BookController(private val bookservice:BookService) {

   // @ExceptionHandler(NoSuchElementException::class)
   // fun handleNotFound(e:NoSuchElementException): ResponseEntity<String> =
     //   ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @GetMapping("books/{startPage}/{pageSize}")
    fun getBooks(@PathVariable startPage:Int, @PathVariable pageSize:Int): Page<Book> = bookservice.getBooks(startPage,pageSize)

    @PostMapping("books")
    fun postBook(@RequestBody book: Book):String = bookservice.addBook(book)


    @GetMapping("books/{Id}")
    fun getBooksById(@PathVariable Id:Int): Optional<Book> = bookservice.getBooksById(Id)

    @DeleteMapping("books/{Id}")
    fun deleteBooksById(@PathVariable Id:Int):String = bookservice.deleteBook(Id)

    @GetMapping("books/author/{AuthorName}")
    fun getBookByAuthor(@PathVariable AuthorName:String):Collection<Book> = bookservice.retrieveBookByAuthor(AuthorName)

    @GetMapping("book/category/{Category}")
    fun getBookByCategory(@PathVariable Category:String):Collection<Book> = bookservice.retrieveBookByCategory(Category)
}