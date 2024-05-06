package com.project.bankingapp.service;

import com.project.bankingapp.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface  AccountService {

AccountDto createAccount(AccountDto accountDto);

AccountDto getAccountById(Long id);

AccountDto deposit(Long id, double amount);

AccountDto withdraw(Long id ,double amount);

List<AccountDto> getAllAccounts();

void deleteAccount(Long id);
}
