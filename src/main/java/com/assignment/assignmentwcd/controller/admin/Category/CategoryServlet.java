package com.assignment.assignmentwcd.controller.admin.Category;

import com.assignment.assignmentwcd.entity.Category;
import com.assignment.assignmentwcd.model.sqlmodel.MySqlCategoryModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

public class CategoryServlet extends HttpServlet {
    private final MySqlCategoryModel categoryModel;
    public CategoryServlet() {
        categoryModel = new MySqlCategoryModel();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryModel.getAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/admin/views/category/index.jsp").forward(request, response);
    }
}
