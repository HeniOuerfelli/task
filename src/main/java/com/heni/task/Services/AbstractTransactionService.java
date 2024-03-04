package com.heni.task.Services;

import com.heni.task.DTOs.TransactionDTO;
import com.heni.task.Entities.TRANSACTION_TYPE;

import java.time.LocalDate;
import java.util.List;

public interface AbstractTransactionService {
    void saveTransaction(TransactionDTO dto);
    TransactionDTO findTransactionById(Integer id);
    List<TransactionDTO> findAllTransactions();
    Long getDailyAverage(TRANSACTION_TYPE transactionType);
}
