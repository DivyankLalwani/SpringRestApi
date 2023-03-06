package com.example.springrestapiapp.controller;

import com.example.springrestapiapp.entity.Bank;
import com.example.springrestapiapp.entity.User;
import com.example.springrestapiapp.model.BankModel;
import com.example.springrestapiapp.model.UserModel;
import com.example.springrestapiapp.service.BankService;
import com.example.springrestapiapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private UserService userService;

    @Autowired
    private BankService bankService;


    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody UserModel model) {

        return userService.createUser(model);
    }

    @PostMapping("/bank")
    public ResponseEntity<Object> createBank(@RequestBody BankModel bank){

        return bankService.createBank(bank);
    }
    @GetMapping("/userBank/{id}")
    public List<Bank> retriveAllUsers(@PathVariable Long id)
    {
        Optional<User> userOptional= userService.findById(id);
        if(!userOptional.isPresent())
        {
            System.out.println("User not present");
            return null;
        }
        System.out.println(userOptional);
        return userOptional.get().getBanks();
    }
    @GetMapping("/getdata/{id}")
    private List<Object> getAllUsers(@PathVariable("id") Long id)
    {
        return userService.getAllUsers(id);
    }
    @GetMapping("/getbanks")
    private List<Bank> getAllUsersWithBank()
    {
        return userService.getAllBanks();
    }

    @DeleteMapping("/delete/{id}")
    private void deleteStudent(@PathVariable("id") Long id)
    {
        userService.delete(id);
    }
}
