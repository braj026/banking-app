package com.project.bankingapp.repository;

import com.project.bankingapp.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account , Long> {
}
