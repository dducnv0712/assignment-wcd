package com.assignment.assignmentwcd.model;

import com.assignment.assignmentwcd.entity.Product;

import java.util.List;

public interface ProductModel {
    boolean Save(Product product);

    List<Product> getAll();

    Product findById(int id);


    boolean Update(int id, Product productUpdate);

    boolean Delete(int id);
}
