package com.example.demo.service

import com.example.demo.model.Author
import com.example.demo.model.AuthorRepository
import com.example.demo.model.Book
import com.example.demo.model.BookRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.cache.annotation.Caching
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class BookService (private val bookRepository:BookRepository, private val authorRepository: AuthorRepository ) {

    fun getBooks(startPage: Int, pageSize: Int): Page<Book> {
        var x: PageRequest = PageRequest.of(startPage,pageSize, Sort.by("bookName"))

       return bookRepository.findAll(x)
    }

    fun getAuthors(sp: Int, ps: Int): Page<Author> {

        var x: PageRequest = PageRequest.of(sp,ps, Sort.by("authorName"))

       return authorRepository.findAll(x)
    }

//    @CachePut(value = arrayOf("bookCache"), key = "#book.id")
    fun addBook(book: Book): String
    {
//        for (category in book.Category) {
//            book.Category.add(category)
//        }
      authorRepository.save(book.author)
      bookRepository.save(book)
        return "book added successfully!"
    }

//    @Cacheable(value = arrayOf("bookCache"), key = "#id")
    fun getBooksById(id: Int): Optional<Book> {
       return bookRepository.findById(id)
    }

//    @CacheEvict(value = arrayOf("bookCache"), key = "#id")
    fun deleteBook(id: Int): String {
      //
   // var book = bookRepository.findByIdOrNull(id)?;
  //  throw Exception
 //   authorRepository.deleteById(book)
       bookRepository.deleteById(id)
        return "book deleted successfully"
    }

    fun retrieveBookByAuthor(authorName: String): Collection<Book> {
        return bookRepository.findAll().filter { it.author.authorName==authorName }
    }

    fun retrieveBookByCategory(category: String): Collection<Book> {
        return bookRepository.findAll().filter{ it.Category.contains(category)}
    }


}