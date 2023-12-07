package com.darko.accountservice.web;

import com.darko.accountservice.clients.CustomerRestClient;
import com.darko.accountservice.entity.BankAccount;
import com.darko.accountservice.models.Customer;
import com.darko.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountController {

    private BankAccountRepository bankAccountRepository;

    private CustomerRestClient customerRestClient;

    public BankAccountController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }


    @GetMapping("/accounts")
    public List<BankAccount> bankAccountList(){
        List<BankAccount> accountList = bankAccountRepository.findAll();
        accountList.forEach(bankAccount -> {
            bankAccount.setCustomer(customerRestClient.findCustomerById(bankAccount.getCustomerId()));
        });

        return accountList;
    }


    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountId(@PathVariable String id){
        BankAccount bankAccount = bankAccountRepository.findById(id).orElse(null);
        assert bankAccount != null;
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
