package com.gradprogram.mylibrary.repositories;

import com.gradprogram.mylibrary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
