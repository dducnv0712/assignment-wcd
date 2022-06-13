package com.assignment.assignmentwcd.controller.admin.Category;

import com.assignment.assignmentwcd.model.sqlmodel.MySqlCategoryModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    private final MySqlCategoryModel categoryModel;
    public DeleteServlet() {
        categoryModel = new MySqlCategoryModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cateId = Integer.parseInt(req.getParameter("cateId"));
        categoryModel.Delete(cateId);
       resp.sendRedirect("/admin/category");
    }
}
