<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.assignment.assignmentwcd.entity.myenum.ObjStatus" %>
<%@ page import="com.assignment.assignmentwcd.entity.Category" %><%--
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
                    <div class="col-7">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Add Product</h4>
                                <form action="/admin/product/create" method="post" class="forms-sample">
                                    <div class="form-group">
                                        <label for="exampleInputUsername1">Product Name</label>
                                        <input type="text" class="form-control" id="exampleInputUsername1" name="name"
                                               placeholder="Product Name">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Image</label>
                                        <input type="text" class="form-control" id="exampleInputEmail1" name="image"
                                               placeholder="Image url">
                                    </div>
                                    <div class="row">
                                        <div class="col-6">
                                            <div class="form-group">
                                                <label for="haha">Price</label>
                                                <input type="text" class="form-control" id="haha" name="price"
                                                       placeholder="Price">
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="form-group">
                                                <label for="exampleInputPassword1">Opening Date</label>
                                                <input type="date" class="form-control" name="openingDate"
                                                       id="exampleInputPassword1" placeholder="Opening Date">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="category">Single select box using select 2</label>
                                        <select id="category" name="categoryId" class="js-example-basic-single w-100">
                                            <%
                                                List<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
                                                for (Category category : categories) {%>
                                            <% if (category.getStatus() == ObjStatus.ACTIVE) {%>
                                            <option value="<%=category.getId()%>">
                                                <%=category.getName()%>
                                            </option>
                                            <%}%>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleTextarea1">Textarea</label>
                                        <textarea name="description" class="form-control" id="exampleTextarea1" rows="4"></textarea>
                                    </div>
                                    <div class="form-check form-check-flat form-check-primary">
                                        <label class="form-check-label">
                                            <input type="checkbox" name="status" class="form-check-input">
                                            Active
                                        </label>
                                    </div>
                                    <button type="submit" class="btn btn-primary mr-2">Submit</button>
                                    <button class="btn btn-light">Cancel</button>
                                </form>
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
