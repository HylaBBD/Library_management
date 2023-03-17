package com.gradprogram.mylibrary.repositories;

import com.gradprogram.mylibrary.models.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {
}
