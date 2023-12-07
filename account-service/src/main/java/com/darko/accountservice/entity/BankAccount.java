package com.darko.accountservice.entity;

import com.darko.accountservice.enums.AccountType;
import com.darko.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity@Getter@Setter@NoArgsConstructor@AllArgsConstructor@Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Long customerId;
    @Transient
    private Customer customer;
}
