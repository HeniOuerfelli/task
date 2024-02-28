package com.heni.task.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private Integer id;
    private Long amount;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private TRANSACTION_TYPE transactionType;
    @ManyToOne()
    @JoinColumn(name = "id_user")
    User user;
}
