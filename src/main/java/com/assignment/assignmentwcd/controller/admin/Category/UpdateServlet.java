package com.assignment.assignmentwcd.controller.admin.Category;

import com.assignment.assignmentwcd.entity.Category;
import com.assignment.assignmentwcd.entity.myenum.ObjStatus;
import com.assignment.assignmentwcd.model.sqlmodel.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {
    private final MySqlCategoryModel categoryModel;
    public UpdateServlet() {
        categoryModel = new MySqlCategoryModel();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cateId = Integer.parseInt(req.getParameter("cateId"));
        String name = req.getParameter("name");
        String status = req.getParameter("status");
        ObjStatus statusValue = ObjStatus.ACTIVE;
        if(status  == null) {
            statusValue = ObjStatus.DEACTIVE;
        }
        Category category = new Category();
        category.setName(name);
        category.setStatus(statusValue);
        categoryModel.Update(cateId,category);
        resp.sendRedirect("/admin/category");
    }
}
