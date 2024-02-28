package com.heni.task.Repos;

import com.heni.task.Entities.TRANSACTION_TYPE;
import com.heni.task.Entities.Transaction;
import com.heni.task.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Optional<Transaction> findTransactionById(Integer id);
    List<Transaction> findByUserUsernameAndDateBetweenAndTransactionType(String username,
                                                                 LocalDate startDate,
                                                                 LocalDate endDate,
                                                                 TRANSACTION_TYPE transactionType);
    List<Transaction> getTransactionByAmount(double amount);

    void deleteTransactionById(Integer id);
}
