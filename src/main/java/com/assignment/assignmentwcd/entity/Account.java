package com.assignment.assignmentwcd.entity;

import com.assignment.assignmentwcd.entity.base.BaseEntity;
import com.assignment.assignmentwcd.entity.myenum.ObjStatus;

import java.time.LocalDateTime;

public class Account extends BaseEntity {
    private int id;
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private String passwordConfirm;
    private String address;
    private int roleID;
    private ObjStatus status;

    public Account() {
    }
    public Account(int id, String fullName, String email, String phone, String password, String passwordConfirm, String address, int roleID, ObjStatus status) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.address = address;
        this.roleID = roleID;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public ObjStatus getStatus() {
        return status;
    }

    public void setStatus(ObjStatus status) {
        this.status = status;
    }

    public static final class AccountBuilder {
        protected LocalDateTime createdAt;
        protected LocalDateTime updatedAt;
        protected LocalDateTime deletedAt;
        protected int createdBy;
        protected int updatedBy;
        protected int deletedBy;
        private int id;
        private String fullName;
        private String email;
        private String phone;
        private String password;
        private String passwordConfirm;
        private String address;
        private int roleID;
        private ObjStatus status;

        private AccountBuilder() {
        }

        public static AccountBuilder anAccount() {
            return new AccountBuilder();
        }

        public AccountBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public AccountBuilder withFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public AccountBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public AccountBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public AccountBuilder withPasswordConfirm(String passwordConfirm) {
            this.passwordConfirm = passwordConfirm;
            return this;
        }

        public AccountBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public AccountBuilder withRoleID(int roleID) {
            this.roleID = roleID;
            return this;
        }

        public AccountBuilder withStatus(ObjStatus status) {
            this.status = status;
            return this;
        }

        public AccountBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccountBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public AccountBuilder withDeletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public AccountBuilder withCreatedBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AccountBuilder withUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public AccountBuilder withDeletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.setId(id);
            account.setFullName(fullName);
            account.setEmail(email);
            account.setPhone(phone);
            account.setPassword(password);
            account.setPasswordConfirm(passwordConfirm);
            account.setAddress(address);
            account.setRoleID(roleID);
            account.setStatus(status);
            account.createdAt = this.createdAt;
            account.updatedAt = this.updatedAt;
            account.deletedBy = this.deletedBy;
            account.createdBy = this.createdBy;
            account.updatedBy = this.updatedBy;
            account.deletedAt = this.deletedAt;
            return account;
        }
    }
}
