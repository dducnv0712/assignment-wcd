package com.assignment.assignmentwcd.service;
import com.assignment.assignmentwcd.entity.Account;
import com.assignment.assignmentwcd.model.AccountModel;
import com.assignment.assignmentwcd.model.sqlmodel.MySqlAccountModel;
import com.assignment.assignmentwcd.util.SHA512Hasher;

public class AccountService {
    private final AccountModel accountModel;

    public AccountService() {
        this.accountModel = new MySqlAccountModel();
    }

    public Account register(Account account) {
        String salt = SHA512Hasher.randomString(7);
        String passwordHashed = SHA512Hasher.encode(account.getPassword(), salt);
        account.setPassword(passwordHashed + "." + salt);
        accountModel.Save(account);
        return account;
    }

    public Account login(String phone, String password) {
        Account accountFound = accountModel.findByPhone(phone);
        if (accountFound == null) {
            return null;
        }
        if (SHA512Hasher.checkPassword(accountFound.getPassword(), password)) {
            return accountFound;
        }
        return null;
    }

}
