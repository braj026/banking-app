package com.project.bankingapp.controller;
import com.project.bankingapp.dto.AccountDto;
import com.project.bankingapp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //add account restApi
    @PostMapping(value = "/add")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //get account restAPI
@GetMapping("{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable long id){
        AccountDto accountDto=accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

  //Deposit REST API
    @PutMapping("/{id}/deposit")
 public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                          @RequestBody Map<String ,Double> request){
        Double amount=request.get("amount");
       AccountDto accountDto= accountService.deposit(id,amount);
       return ResponseEntity.ok(accountDto);
 }
    //Withdraw REST API
    @PutMapping("{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id ,
                                              @RequestBody Map<String, Double> request){
       double amount=request.get("amount");
       AccountDto accountDto=accountService.withdraw(id,amount);
       return  ResponseEntity.ok(accountDto);

    }
    //Get All Account TEST API
    @GetMapping
    public  ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accountDtoList=accountService.getAllAccounts();
        return ResponseEntity.ok(accountDtoList);
    }

    //Delete Account REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted Successfully");
    }
}
