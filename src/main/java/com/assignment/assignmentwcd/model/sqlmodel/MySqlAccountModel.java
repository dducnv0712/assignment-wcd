package com.assignment.assignmentwcd.model.sqlmodel;

import com.assignment.assignmentwcd.entity.Account;
import com.assignment.assignmentwcd.model.AccountModel;
import com.assignment.assignmentwcd.model.constant.SqlConstant;
import com.assignment.assignmentwcd.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class MySqlAccountModel implements AccountModel {
    Connection connection = ConnectionHelper.getConnection();
    @Override
    public boolean Save(Account account) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ACCOUNT_INSERT);
            preparedStatement.setString(1, account.getFullName());
            preparedStatement.setString(2, account.getPhone());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setInt(4, account.getRoleID());
            preparedStatement.setString(5, account.getPassword());
            preparedStatement.setString(6,account.getAddress());
            preparedStatement.setString(7,account.getCreatedAt().toString());
            preparedStatement.setString(8,account.getUpdatedAt().toString());
            preparedStatement.setInt(9,account.getStatus().getValue());
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public Account findByPhone(String phone) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.ACCOUNT_FIND_BY_PHONE);
            preparedStatement.setString(1, phone);
            preparedStatement.setInt(2, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setFullName(resultSet.getString("fullName"));
                account.setPhone(resultSet.getString("phone"));
                account.setEmail(resultSet.getString("email"));
                account.setRoleID(resultSet.getInt("roleId"));
                return account;
            }
            return null;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean Update(int id, Account updateAccount) {
        return false;
    }

    @Override
    public boolean Delete(int id) {
        return false;
    }
}
