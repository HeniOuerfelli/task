package com.heni.task.Services;

import com.heni.task.DTOs.TransactionDTO;
import com.heni.task.Entities.TRANSACTION_TYPE;
import com.heni.task.Mappers.TransactionMapper;
import com.heni.task.Repos.TransactionRepository;
import com.heni.task.Security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService implements AbstractTransactionService{
    private final TransactionRepository repository;
    private final TransactionMapper mapper;
    private final SecurityUtils utils;
    public void saveTransaction(TransactionDTO dto) {
        repository.save(mapper.toTransaction(dto));
    }
    public TransactionDTO findTransactionById(Integer id){
        return mapper.toTransactionDTO(repository.findTransactionById(id)
                .orElseThrow());
    }
    public List<TransactionDTO> findAllTransactions(){
        return repository.findAll()
                .stream()
                .map(mapper::toTransactionDTO)
                .collect(Collectors.toList());
    }
    public Long getDailyAverage(TRANSACTION_TYPE transactionType){
        LocalDate endDate = LocalDate.now().minusDays(1);
        LocalDate startDate = endDate.minusDays(27);
        long totalAmount = repository.findByUserUsernameAndDateBetweenAndTransactionType(utils.getUsername(),
                startDate,
                endDate,
                transactionType);

        return totalAmount / 28;
    }
}
