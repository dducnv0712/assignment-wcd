package com.assignment.assignmentwcd;

import com.assignment.assignmentwcd.entity.Account;
import com.assignment.assignmentwcd.entity.Category;
import com.assignment.assignmentwcd.entity.myenum.ObjStatus;
import com.assignment.assignmentwcd.model.sqlmodel.MySqlAccountModel;
import com.assignment.assignmentwcd.model.sqlmodel.MySqlCategoryModel;
import com.assignment.assignmentwcd.service.AccountService;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Runtest {
    @Test
    public void testSaveAccount() {
        AccountService accountService = new AccountService();
        MySqlAccountModel accountModel = new MySqlAccountModel();
        Account account = new Account();
        account.setFullName("Nguyen Van Duc");
        account.setPhone("09898989899");
        account.setEmail("test@exx.com");
        account.setPassword("123456");
        account.setPasswordConfirm("123456");
        account.setAddress("HN");
        account.setRoleID(1);
        account.setStatus(ObjStatus.ACTIVE);
        account = accountService.register(account);
    }
    @Test
    void testLogin() {
//        AccountService accountService = new AccountService();
//        Account account = accountService.login("0989898989", "123456");
//        System.out.println(account);
        MySqlAccountModel accountModel = new MySqlAccountModel();
        Account account = accountModel.findByPhone("09898989899");
        System.out.println(account.getAddress());
    }
    @Test
    void saveCategory(){
        MySqlCategoryModel categoryModel = new MySqlCategoryModel();
        Category category = new Category();
        category.setName("Camera");
        category.setStatus(ObjStatus.ACTIVE);
        boolean result = categoryModel.Save(category);
        System.out.println(result);
    }
    @Test
    void getAllCategory(){
        MySqlCategoryModel categoryModel = new MySqlCategoryModel();
        List<Category> categories = categoryModel.getAll();
        for (Category category : categories) {
            System.out.println(category.getName());
        }
    }
    @Test
    void findById(){
        MySqlCategoryModel categoryModel = new MySqlCategoryModel();
        Category category = categoryModel.findById(1);
        System.out.println(category.getName());
    }
    @Test
    void updateCategory(){
        MySqlCategoryModel categoryModel = new MySqlCategoryModel();
        Category category = new Category();
        category.setName("Latop 1");
        category.setStatus(ObjStatus.ACTIVE);
        boolean result =categoryModel.Update(1,category);
        System.out.println(result);
    }
    @Test
    void deleteCategory(){
        MySqlCategoryModel categoryModel = new MySqlCategoryModel();
        boolean result = categoryModel.Delete(2);
        System.out.println(result);
    }


}
