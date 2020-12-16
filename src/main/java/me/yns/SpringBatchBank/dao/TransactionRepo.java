package me.yns.SpringBatchBank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import me.yns.SpringBatchBank.Entities.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

}
