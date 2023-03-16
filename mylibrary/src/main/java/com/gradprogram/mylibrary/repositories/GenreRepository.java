package com.gradprogram.mylibrary.repositories;

import com.gradprogram.mylibrary.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
