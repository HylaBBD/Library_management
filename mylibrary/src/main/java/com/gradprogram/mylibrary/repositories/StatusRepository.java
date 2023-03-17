package com.gradprogram.mylibrary.repositories;

import com.gradprogram.mylibrary.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
