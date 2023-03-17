package com.gradprogram.mylibrary.repositories;

import com.gradprogram.mylibrary.models.BookGenres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookGenreRepository extends JpaRepository<BookGenres, Long> {
}
