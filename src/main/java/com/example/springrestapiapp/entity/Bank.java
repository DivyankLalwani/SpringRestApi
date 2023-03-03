package com.example.springrestapiapp.entity;

import javax.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long bank_id;

    private String account_type;
    private Double balance;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    User user;


    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public Long getBank_id() {
        return bank_id;
    }

    public void setBank_id(Long bank_id) {
        this.bank_id = bank_id;
    }
}
