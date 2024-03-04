package com.heni.task.Controllers;

import com.heni.task.DTOs.TransactionDTO;
import com.heni.task.Entities.TRANSACTION_TYPE;
import com.heni.task.Entities.Transaction;
import com.heni.task.Services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService service;
    @PostMapping
    public void saveTransaction(@RequestBody TransactionDTO dto){
        service.saveTransaction(dto);
    }
    @GetMapping
    public List<TransactionDTO> findAllTransactions(){
        return service.findAllTransactions();
    }
    @GetMapping("/{transaction-id}")
    public ResponseEntity<TransactionDTO> findTransactionById(
            @PathVariable("transaction-id") Integer id
    ){
        return ResponseEntity.ok(service.findTransactionById(id));
    }
    @GetMapping("/daily-average")
    public ResponseEntity<Long> getDailyAverage(
            @RequestParam(name = "transaction-type") TRANSACTION_TYPE transactionType
    ){

        return ResponseEntity.ok(service.getDailyAverage(transactionType));
    }

}
