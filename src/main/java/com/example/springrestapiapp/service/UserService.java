package com.example.springrestapiapp.service;

import com.example.springrestapiapp.entity.Bank;
import com.example.springrestapiapp.entity.User;
import com.example.springrestapiapp.model.UserModel;
import com.example.springrestapiapp.repository.BankRepository;
import com.example.springrestapiapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BankRepository bankRepository;

    public ResponseEntity<Object> createUser(UserModel model) {
        User user = new User();
        if(userRepository.findByEmail(model.getEmail()).isPresent()){
            System.out.println("The email is already present");
            return ResponseEntity.badRequest().body("The Email is already Present, Failed to Create new User");
        } else {
            user.setFirstName(model.getFirstName());
            user.setLastName(model.getLastName());
            user.setMobile(model.getMobile());
            user.setEmail(model.getEmail());
//            user.setBanks(model.getBanks());
            User savedUser = userRepository.save(user);
            if(userRepository.findById(savedUser.getId()).isPresent())
                return ResponseEntity.ok("User Created Successfully");
            else return ResponseEntity.unprocessableEntity().body("Failed Creating User as Specified");
        }
    }


    public List<Object> getAllUsers(Long id)
    {
        List<Object> users = new ArrayList();
        users = Collections.singletonList(userRepository.findAllActiveUsersWithBank(id));
//        userRepository.findAll().forEach(users::add);
        return users;
    }

    public List<Bank> getAllBanks()
    {
        List<Bank> banks = new ArrayList();
        bankRepository.findAll().forEach(banks::add);
        return banks;
    }
    public void delete(Long id)
    {
        userRepository.deleteById(id);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
