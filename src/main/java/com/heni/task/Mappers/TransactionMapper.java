package com.heni.task.Mappers;

import com.heni.task.DTOs.TransactionDTO;
import com.heni.task.Entities.Transaction;
import com.heni.task.Entities.User;
import com.heni.task.Repos.UserRepository;
import com.heni.task.Security.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionMapper {
    private final SecurityUtils utils;
    private final UserRepository repository;
    public Transaction toTransaction(TransactionDTO dto){
        if(dto == null){
            throw new NullPointerException("u passed a null dto in parameter");
        }
        Transaction transaction = new Transaction();

        User user = repository.getUserByEmail(utils.getUsername());
        transaction.setAmount(dto.amount());
        transaction.setTransactionType(dto.transactionType());
        transaction.setDate(dto.date());
        transaction.setUser(user);
        return transaction;
    }
    public TransactionDTO toTransactionDTO(Transaction tr){
        return new TransactionDTO(
                repository.getUserByEmail(utils.getUsername()).getId(),
                tr.getTransactionType(),
                tr.getAmount(),
                tr.getDate()
        );
    }
}
