<%@ page import="com.assignment.assignmentwcd.entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.assignment.assignmentwcd.entity.myenum.ObjStatus" %><%--
  Created by IntelliJ IDEA.
  User: ducnv
  Date: 31/05/2022
  Time: 09:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/admin/components/head.jsp"/>
<body>
<div class="container-scroller">
    <jsp:include page="/admin/components/navbar.jsp"/>
    <div class="container-fluid page-body-wrapper">
        <jsp:include page="/admin/components/sidebar.jsp"/>
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Add Category</h4>
                                <form action="/admin/category/create" method="post" class="forms-sample">
                                    <div class="form-group">
                                        <label for="exampleInputUsername1">Category Name</label>
                                        <input type="text" name="name" class="form-control" id="exampleInputUsername1"
                                               placeholder="Category Name">
                                    </div>
                                    <div class="form-group">
                                        <div class="form-check">
                                            <label class="form-check-label">
                                                <input type="checkbox" checked name="status" class="form-check-input">
                                                Active
                                            </label>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary mr-2">Submit</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-8">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Categories</h4>
                                <div class="table-responsive pt-3">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>
                                                #ID
                                            </th>
                                            <th>
                                                Category Name
                                            </th>
                                            <th>
                                                Status
                                            </th>
                                            <th>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                            List<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
                                            for (Category category : categories) {%>
                                        <%if (category.getStatus() != ObjStatus.DELETED) {%>
                                        <tr>
                                            <td><%=category.getId()%>
                                            </td>
                                            <td><%=category.getName()%>
                                            </td>
                                            <td><%=category.getStatus()%>
                                            </td>
                                            <td>
                                                <div class="btn-group" role="group" aria-label="Basic example">
                                                    <button type="button" class="btn btn-outline-warning"
                                                            data-bs-toggle="modal"
                                                            data-bs-target="#edit-category<%=category.getId()%>">edit
                                                    </button>
                                                    <%if (category.getStatus() != ObjStatus.DELETED) {%>
                                                    <a href="/admin/category/delete?cateId=<%=category.getId()%>"
                                                       class="btn btn-outline-danger">delete</a>
                                                    <%} %>
                                                </div>
                                                <div class="modal fade" id="edit-category<%=category.getId()%>"
                                                     tabindex="-1"
                                                     aria-labelledby="exampleModalLabel<%=category.getId()%>"
                                                     aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <form action="/admin/category/update?cateId=<%=category.getId()%>"
                                                              method="post" class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title"
                                                                    id="exampleModalLabel"><%=category.getName()%>
                                                                </h5>
                                                                <button type="button" class="btn-close"
                                                                        data-bs-dismiss="modal" aria-label="Close">x
                                                                </button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <div class="form-group">
                                                                    <label for="exampleInputUsername1_hehe">Category
                                                                        Name</label>
                                                                    <input type="text" name="name"
                                                                           value="<%=category.getName()%>"
                                                                           class="form-control"
                                                                           id="exampleInputUsername1_hehe"
                                                                           placeholder="Category Name">
                                                                </div>
                                                                <div class="form-group">
                                                                    <div class="form-check">
                                                                        <label class="form-check-label">
                                                                            <input type="checkbox"
                                                                                   <%if(category.getStatus() == ObjStatus.ACTIVE){%>checked<%}%>
                                                                                   name="status"
                                                                                   class="form-check-input">
                                                                            Active
                                                                        </label>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-secondary"
                                                                        data-bs-dismiss="modal">Close
                                                                </button>
                                                                <button type="submit" class="btn btn-primary">Save
                                                                    changes
                                                                </button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>

                                            </td>
                                        </tr>
                                        <%}%><% } %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Button trigger modal -->


    <!-- Modal -->
</div>
<jsp:include page="/admin/components/scripts.jsp"/>
</body>
</html>
