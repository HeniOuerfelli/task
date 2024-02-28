package com.heni.task.Services;

import com.heni.task.DTOs.TransactionDTO;
import com.heni.task.Entities.TRANSACTION_TYPE;
import com.heni.task.Entities.Transaction;
import com.heni.task.Entities.User;
import com.heni.task.Mappers.TransactionMapper;
import com.heni.task.Repos.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository repository;
    private final TransactionMapper mapper;
    public List<TransactionDTO> findAllTransactions(){
        return repository.findAll()
                .stream()
                .map(mapper::toTransactionDTO)
                .collect(Collectors.toList());
    }
    public List<TransactionDTO> getTransactionsDuringAMonth(String username,
                                                            LocalDate startDate,
                                                            LocalDate endDate,
                                                            TRANSACTION_TYPE transactionType){
        return repository.findByUserUsernameAndDateBetweenAndTransactionType(
                username,
                startDate,
                endDate,
                transactionType
        ).stream()
                .map(mapper::toTransactionDTO)
                .collect(Collectors.toList());
    }
}
