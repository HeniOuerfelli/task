package com.heni.task.Controllers;

import com.heni.task.DTOs.TransactionDTO;
import com.heni.task.Entities.TRANSACTION_TYPE;
import com.heni.task.Entities.Transaction;
import com.heni.task.Repos.UserRepository;
import com.heni.task.Services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {
    private final TransactionService service;
    @GetMapping("/daily-average")
    public ResponseEntity<Long> getDailyAverage(
            @RequestParam(name = "transaction-type") TRANSACTION_TYPE transactionType
    ){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        LocalDate endDate = LocalDate.now().minusDays(1);
        LocalDate startDate = endDate.minusDays(27);
        List<TransactionDTO> transactions = service.getTransactionsDuringAMonth(username,
                startDate,
                endDate,
                transactionType);
        long totalAmount = transactions
                .stream()
                .mapToLong(TransactionDTO::amount).sum();
        Long dailyAverage = totalAmount / 28;
        return ResponseEntity.ok(dailyAverage);
    }
}
