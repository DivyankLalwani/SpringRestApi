package com.example.springrestapiapp.model;

import com.example.springrestapiapp.entity.User;

public class BankModel {

    private Long bank_id;
    private String account_type;
    private Double balance;

    private User user;

    @Override
    public String toString() {
        return "BankModel{" +
                "account_type='" + account_type + '\'' +
                ", balance=" + balance +
                ", user=" + user +
                '}';
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
