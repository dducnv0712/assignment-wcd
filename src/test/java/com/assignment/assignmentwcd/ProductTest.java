package com.assignment.assignmentwcd;
import com.assignment.assignmentwcd.entity.Product;
import com.assignment.assignmentwcd.entity.myenum.ProductStatus;
import com.assignment.assignmentwcd.model.sqlmodel.MySqlProductModel;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class ProductTest {
    MySqlProductModel productModel = new MySqlProductModel();
    @Test
    void testSaveProduct() {
        Product product = new Product();
        product.setName("Camera");
        product.setPrice(100000);
        product.setCategoryId(1);
        product.setDescription("Camera");
        product.setImage("https://www.google.com/");
        product.setOpeningDate(LocalDateTime.now());
        product.setStatus(ProductStatus.getAccountStatus(1));
        boolean result = productModel.Save(product);
        System.out.println(result);
    }
    @Test
    void testGetAllProduct() {
        List<Product> products = productModel.getAll();
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }
    @Test
    void testFindById() {
        Product product = productModel.findById(1);
        System.out.println(product.getName());
    }
    @Test
    void testUpdateProduct() {
        Product product = productModel.findById(1);
        product.setName("Camera 1");
        product.setPrice(100000);
        product.setCategoryId(1);
        product.setDescription("Camera 1");
        product.setImage("https://www.google.com/hello");
        product.setOpeningDate(LocalDateTime.now());
        product.setStatus(ProductStatus.getAccountStatus(1));
        boolean result = productModel.Update(1,product);
        System.out.println(result);
    }
    @Test
    void testDeleteProduct() {
        boolean result = productModel.Delete(1);
        System.out.println(result);
    }

}
