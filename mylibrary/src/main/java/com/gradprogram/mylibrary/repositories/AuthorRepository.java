package com.gradprogram.mylibrary.repositories;

import com.gradprogram.mylibrary.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
