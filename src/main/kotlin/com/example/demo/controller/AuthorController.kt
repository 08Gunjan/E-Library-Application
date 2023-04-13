package com.example.demo.controller

import com.example.demo.model.Author
import com.example.demo.service.BookService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AuthorController (private val bookService: BookService){

    @GetMapping("/author/{sp}/{ps}")
    fun getAuthor(@PathVariable sp:Int , @PathVariable ps:Int): Page<Author> = bookService.getAuthors(sp,ps)
}