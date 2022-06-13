package com.assignment.assignmentwcd.controller.admin.Product;

import com.assignment.assignmentwcd.entity.Product;
import com.assignment.assignmentwcd.entity.myenum.ProductStatus;
import com.assignment.assignmentwcd.model.sqlmodel.MySqlProductModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

public class UpdateServlet extends HttpServlet {
    private final MySqlProductModel productModel;
    public UpdateServlet() {
        productModel = new MySqlProductModel();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String image = req.getParameter("image");
        LocalDateTime openingDate = req.getParameter("openingDate").equals("") ? null : LocalDateTime.parse(req.getParameter("openingDate"));
        String status = req.getParameter("status");
        ProductStatus productStatus = ProductStatus.ON_SALE;
        if (status == null) {
            productStatus = ProductStatus.STOP_SALE;
        }
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategoryId(categoryId);
        product.setImage(image);
        product.setOpeningDate(openingDate);
        product.setStatus(productStatus);
        boolean result = productModel.Update(id,product);
        if(result) {
            resp.sendRedirect("/admin/product");
        }
    }
}
