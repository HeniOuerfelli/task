package com.heni.task.Repos;

import com.heni.task.DTOs.TransactionDTO;
import com.heni.task.Entities.TRANSACTION_TYPE;
import com.heni.task.Entities.Transaction;
import com.heni.task.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Optional<Transaction> findTransactionById(Integer id);
    @Query("""
    SELECT SUM(t.amount)
    FROM Transaction t
    WHERE t.date BETWEEN :startDate AND :endDate
    AND t.user.email = :username
    AND t.transactionType = :transactionType
""")
    Long findByUserUsernameAndDateBetweenAndTransactionType(@Param("username") String username,
                                                            @Param("startDate") LocalDate startDate,
                                                            @Param("endDate") LocalDate endDate,
                                                            @Param("transactionType") TRANSACTION_TYPE transactionType);
    List<Transaction> getTransactionByAmount(double amount);

    void deleteTransactionById(Integer id);
}
