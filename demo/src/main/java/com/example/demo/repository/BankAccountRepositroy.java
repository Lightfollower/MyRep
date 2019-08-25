package com.example.demo.repository;

import com.example.demo.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepositroy extends JpaRepository<BankAccount, Long>{
}