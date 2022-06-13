package com.assignment.assignmentwcd.controller.admin.Product;

import com.assignment.assignmentwcd.entity.Category;
import com.assignment.assignmentwcd.entity.Product;
import com.assignment.assignmentwcd.model.sqlmodel.MySqlCategoryModel;
import com.assignment.assignmentwcd.model.sqlmodel.MySqlProductModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {
    private final MySqlProductModel productModel;
    private final MySqlCategoryModel categoryModel;

    public ProductServlet() {
        productModel = new MySqlProductModel();
        categoryModel = new MySqlCategoryModel();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productModel.getAll();
        request.setAttribute("products", products);
        List<Category> categories = categoryModel.getAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/admin/views/product/index.jsp").forward(request, response);
    }

}
