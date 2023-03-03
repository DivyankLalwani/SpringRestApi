package com.example.springrestapiapp.service;

import com.example.springrestapiapp.entity.Bank;
import com.example.springrestapiapp.entity.User;
import com.example.springrestapiapp.model.BankModel;
import com.example.springrestapiapp.model.UserModel;
import com.example.springrestapiapp.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    BankRepository bankRepository;
    public ResponseEntity<Object> createBank(BankModel model) {
        Bank bank = new Bank();
        bank.setBalance(model.getBalance());
        bank.setAccount_type(model.getAccount_type());
        bank.setUser(model.getUser());
        Bank savedBank = bankRepository.save(bank);
        if(bankRepository.findById(savedBank.getBank_id()).isPresent())
            return ResponseEntity.ok("Bank Created Successfully");
        else return ResponseEntity.unprocessableEntity().body("Failed Creating Bank as Specified");
    }
}