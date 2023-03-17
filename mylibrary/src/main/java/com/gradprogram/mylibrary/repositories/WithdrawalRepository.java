package com.gradprogram.mylibrary.repositories;

import com.gradprogram.mylibrary.models.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
}
