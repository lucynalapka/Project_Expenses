<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Lista wydatków</h1>
        <a href="<c:url value="/expenses/create"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Dodaj wydatek</a>
        <a href="<c:url value="/trips"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Powrót do Moich wyjazdów</a>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Lista wydatków</h6>
        </div>

        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <th>id</th>
                        <th>Nazwa</th>
                        <th>Koszt</th>
                        <th>Osoby uczestniczące w danym koszcie</th>
                        <th>Akcja</th>
                    </tr>
                    <c:forEach items="${items}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.amount}</td>
                            <td>
                                <c:forEach items="${item.paidFor}" var="user">
                                    <p>${user.name}</p>
                                </c:forEach>
                            </td>


                            <td>
                                <a href="<c:url value="/expenses/delete/${item.id}"/>"
                                   class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                                    <i class="h3 mb-0 text-gray-800"></i>Usuń</a>
                                <a href="<c:url value="/expenses/update/${item.id}"/>"
                                   class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                                    <i class="h3 mb-0 text-gray-800"></i>Edytuj</a>
                            </td>
                        </tr>

                    </c:forEach>

                </table>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table">

                            <c:set var="amountTotal" value="${0}"/>
                            <c:forEach var="item" items="${items}">
                                <c:set var="amountTotal" value="${amountTotal + item.amount}"/>
                            </c:forEach>
                            <tr>
                                <h3 class="m-0 font-weight-bold text-primary">Całkowity koszt: ${amountTotal} zł</h3>
                            </tr>

                        </table>

                        <table class="table">

                            <td>
                                <c:set var="amountPerPerson" value="${0}"/>
                                <c:set var="amountPerPerson" value="${amountTotal / noOfPerson}"/>
                            </td>

                            <tr>
                                <h3 class="m-0 font-weight-bold text-primary">Koszt na
                                    osobę: ${amountPerPerson}, ${item.settle}
                                    zł</h3>
                            </tr>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- /.container-fluid -->
    <jsp:include page="footer.jsp"/>
