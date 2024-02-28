package com.heni.task.DTOs;

import com.heni.task.Entities.TRANSACTION_TYPE;

import java.time.LocalDate;

public record TransactionDTO(
        Integer id_user,
        TRANSACTION_TYPE transactionType,
        Long amount,
        LocalDate date
) {
}
