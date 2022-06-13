package com.assignment.assignmentwcd.controller.admin.Product;

import com.assignment.assignmentwcd.model.sqlmodel.MySqlProductModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    private final MySqlProductModel productModel;
    public DeleteServlet() {
        productModel = new MySqlProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("productId"));
        boolean result = productModel.Delete(id);
        response.sendRedirect("/admin/product");
    }

}
