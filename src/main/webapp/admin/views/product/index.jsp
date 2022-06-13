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
                                             #IDID
                                         </th>
                                         <th>
                                             First name
                                         </th>
                                         <th>
                                             Progress
                                         </th>
                                         <th>
                                             Amount
                                         </th>
                                         <th>
                                             Deadline
                                         </th>
                                     </tr>
                                     </thead>
                                     <tbody>
                                     <tr>
                                         <td>
                                             1
                                         </td>
                                         <td>
                                             Herman Beck
                                         </td>
                                         <td>
                                             <div class="progress">
                                                 <div class="progress-bar bg-success" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                             </div>
                                         </td>
                                         <td>
                                             $ 77.99
                                         </td>
                                         <td>
                                             May 15, 2015
                                         </td>
                                     </tr>

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
