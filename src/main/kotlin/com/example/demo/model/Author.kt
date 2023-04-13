package com.example.demo.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.Entity
import javax.persistence.Id


@Repository
interface AuthorRepository: JpaRepository<Author, Int>

@Entity
class Author (
    @Id
    var authorId: Int=1,
    var authorName: String="sam"

)