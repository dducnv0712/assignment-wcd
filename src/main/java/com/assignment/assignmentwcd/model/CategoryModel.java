package com.assignment.assignmentwcd.model;

import com.assignment.assignmentwcd.entity.Account;
import com.assignment.assignmentwcd.entity.Category;

import java.util.List;

public interface CategoryModel {
    boolean Save(Category category);

    List<Category> getAll();

    Category findById(int id);


    boolean Update(int id, Category updateCategory);

    boolean Delete(int id);
}
