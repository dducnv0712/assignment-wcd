package com.assignment.assignmentwcd.model;

import com.assignment.assignmentwcd.entity.Account;

import java.util.List;

public interface AccountModel {
    boolean Save(Account account);

    List<Account> getAll();

    Account findById(int id);

    Account findByPhone(String phone);

    boolean Update(int id, Account updateAccount);

    boolean Delete(int id);
}
