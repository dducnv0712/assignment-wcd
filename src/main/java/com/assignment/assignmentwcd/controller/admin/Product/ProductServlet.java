package com.assignment.assignmentwcd.controller.admin.Product;

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
    public ProductServlet() {
        productModel = new MySqlProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productModel.getAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/admin/views/product/index.jsp").forward(request, response);
    }

}
