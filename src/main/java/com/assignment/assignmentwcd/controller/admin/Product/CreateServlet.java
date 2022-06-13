package com.assignment.assignmentwcd.controller.admin.Product;

import com.assignment.assignmentwcd.entity.Category;
import com.assignment.assignmentwcd.entity.Product;
import com.assignment.assignmentwcd.entity.myenum.ProductStatus;
import com.assignment.assignmentwcd.model.sqlmodel.MySqlCategoryModel;
import com.assignment.assignmentwcd.model.sqlmodel.MySqlProductModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class CreateServlet extends HttpServlet {
    private final MySqlProductModel productModel;
    private final MySqlCategoryModel categoryModel;

    public CreateServlet() {
        productModel = new MySqlProductModel();
        categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryModel.getAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/admin/views/product/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String image = request.getParameter("image");
        LocalDateTime openingDate = LocalDateTime.parse(request.getParameter("openingDate"));
        String status = request.getParameter("status");
        ProductStatus productStatus = ProductStatus.ON_SALE;
        if (status == null) {
            productStatus = ProductStatus.STOP_SALE;
        }
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategoryId(categoryId);
        product.setImage(image);
        product.setOpeningDate(openingDate);
        product.setStatus(productStatus);
       boolean result = productModel.Save(product);
       if(result) {
           response.sendRedirect("/admin/product");
       }
        response.sendRedirect("/admin/product/create");
    }
}
