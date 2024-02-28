package com.heni.task.Mappers;

import com.heni.task.DTOs.TransactionDTO;
import com.heni.task.Entities.Transaction;
import com.heni.task.Entities.User;
import org.springframework.stereotype.Service;

@Service
public class TransactionMapper {
    public Transaction toTransaction(TransactionDTO dto){
        if(dto == null){
            throw new NullPointerException("u passed a null dto in parameter");
        }
        Transaction transaction = new Transaction();
        User user = new User();
        user.setId(dto.id_user());
        transaction.setAmount(dto.amount());
        transaction.setTransactionType(dto.transactionType());
        transaction.setDate(dto.date());
        transaction.setUser(user);
        return transaction;
    }
    public TransactionDTO toTransactionDTO(Transaction tr){
        return new TransactionDTO(
                tr.getUser().getId(),
                tr.getTransactionType(),
                tr.getAmount(),
                tr.getDate()
        );
    }
}
