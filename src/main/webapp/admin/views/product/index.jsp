<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.assignment.assignmentwcd.entity.myenum.ObjStatus" %>
<%@ page import="com.assignment.assignmentwcd.entity.Product" %>
<%@ page import="com.assignment.assignmentwcd.entity.Category" %>
<%@ page import="com.assignment.assignmentwcd.entity.myenum.ProductStatus" %><%--
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
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Bordered table</h4>
                                <p class="card-description">
                                    Add class <code>.table-bordered</code>
                                </p>
                                <div class="table-responsive pt-3">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>
                                                #ID
                                            </th>
                                            <th>
                                                Name
                                            </th>
                                            <th>
                                                Image
                                            </th>
                                            <th>
                                                Price
                                            </th>
                                            <th>
                                                Category
                                            </th>
                                            <th>
                                                Opening Date
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
                                            List<Product> products = (ArrayList<Product>) request.getAttribute("products");
                                            for (Product product : products) {
                                        %>
                                        <tr>
                                            <td>
                                                <%=product.getId()%>
                                            </td>
                                            <td>
                                                <%=product.getName()%>
                                            </td>
                                            <td>
                                                <img src="<%=product.getImage()%>" alt="<%=product.getName()%>"
                                                     style="width: 200px; height: 200px; object-fit: contain">
                                            </td>
                                            <td>
                                                <%=product.getPrice()%>
                                            </td>
                                            <td>
                                                <%=product.getCategoryId()%>
                                            </td>
                                            <td>
                                                <%=product.getOpeningDate()%>
                                            </td>
                                            <td>
                                                <%=product.getStatus()%>
                                            </td>
                                            <td>
                                                <div class="btn-group" role="group" aria-label="Basic example">
                                                    <button type="button" class="btn btn-outline-info"
                                                            data-bs-toggle="modal"
                                                            data-bs-target="#info-product<%=product.getId()%>">Details
                                                    </button>
                                                    <div class="modal fade" id="info-product<%=product.getId()%>"
                                                         tabindex="-1" aria-labelledby="infoproduct<%=product.getId()%>"
                                                         aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title"
                                                                        id="infoproduct<%=product.getId()%>">
                                                                        Details <%=product.getName()%>
                                                                    </h5>
                                                                    <button type="button" class="btn-close"
                                                                            data-bs-dismiss="modal"
                                                                            aria-label="Close"></button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    ...
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary"
                                                                            data-bs-dismiss="modal">Close
                                                                    </button>
                                                                    <button type="button" class="btn btn-primary">Save
                                                                        changes
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <button type="button" class="btn btn-outline-warning"
                                                            data-bs-toggle="modal"
                                                            data-bs-target="#edit-product<%=product.getId()%>">edit
                                                    </button>
                                                    <div class="modal fade" id="edit-product<%=product.getId()%>"
                                                         tabindex="-1"
                                                         aria-labelledby="#editproduct<%=product.getId()%>"
                                                         aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <form action="/admin/category/update?productId=<%=product.getId()%>"
                                                                  method="post" class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title"
                                                                        id="editproduct<%=product.getId()%>">
                                                                        Edit <%=product.getName()%>
                                                                    </h5>
                                                                    <button type="button" class="btn-close"
                                                                            data-bs-dismiss="modal"
                                                                            aria-label="Close"></button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <div>
                                                                        <img src="<%=product.getImage()%>" style="width: 200px; height: 200px ; object-fit: contain"/>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="exampleInputUsername1">Product
                                                                            Name</label>
                                                                        <input type="text"
                                                                               value="<%=product.getName()%>"
                                                                               class="form-control"
                                                                               id="exampleInputUsername1" name="name"
                                                                               placeholder="Product Name">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="exampleInputEmail1">Image</label>
                                                                        <input type="text"
                                                                               value="<%=product.getImage()%>"
                                                                               class="form-control"
                                                                               id="exampleInputEmail1" name="image"
                                                                               placeholder="Image url">
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-6">
                                                                            <div class="form-group">
                                                                                <label for="haha">Price</label>
                                                                                <input value="<%=product.getPrice()%>" type="text" class="form-control"
                                                                                       id="haha" name="price"
                                                                                       placeholder="Price">
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-6">
                                                                            <div class="form-group">
                                                                                <label for="exampleInputPassword1">Opening
                                                                                    Date</label>
                                                                                <input type="date" class="form-control"
                                                                                       name="openingDate"
                                                                                       id="exampleInputPassword1"
                                                                                       placeholder="Opening Date">
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="category">Single select box using
                                                                            select 2</label>
                                                                        <select id="category" name="categoryId"
                                                                                class="js-example-basic-single w-100">
                                                                            <%
                                                                                List<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
                                                                                for (Category category : categories) {%>
                                                                            <% if (category.getStatus() == ObjStatus.ACTIVE) {%>
                                                                            <option
                                                                                    <%
                                                                                        if (product.getCategoryId() == category.getId()) {
                                                                                    %>
                                                                                    selected
                                                                                    <%
                                                                                        }
                                                                                    %>
                                                                                    value="<%=category.getId()%>">
                                                                                <%=category.getName()%>
                                                                            </option>
                                                                            <%}%>
                                                                            <%}%>
                                                                        </select>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="exampleTextarea1">Textarea</label>
                                                                        <textarea name="description"
                                                                                  class="form-control"
                                                                                  id="exampleTextarea1"
                                                                                  rows="4"><%=product.getDescription()%></textarea>
                                                                    </div>
                                                                    <div class="form-check form-check-flat form-check-primary">
                                                                        <label class="form-check-label">
                                                                            <input <% if (product.getStatus() == ProductStatus.ON_SALE) {%>checked<%  }%>
                                                                                    type="checkbox" name="status"
                                                                                   class="form-check-input">
                                                                            ON SALE
                                                                        </label>
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
                                                    <a href="/admin/product/delete?productId=<%=product.getId()%>"
                                                       class="btn btn-outline-danger">Delete</a>
                                                </div>
                                            </td>
                                        </tr>
                                        <%
                                            }
                                        %>


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
