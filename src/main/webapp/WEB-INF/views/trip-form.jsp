<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cyluna
  Date: 31.10.2022
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800"></h1>
        <a href="<c:url value="/trips"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Lista wyjazdów</a>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Dodaj wyjazd</h6>
        </div>
        <form:form method="post" modelAttribute="trip">
            <div class="card-body">
                <div class="form-group">
                    <form:label path="name" for="name">Nazwa</form:label>
                    <form:input path="name" name="name" type="text" class="form-control" id="name" placeholder="Nazwa"/>
                </div>
                <div class="form-group">
                    <form:label path="place" for="place">Miejsce</form:label>
                    <form:input path="place" name="place" type="text" class="form-control" id="place"
                                placeholder="Miejsce"/>
                </div>
                <div class="form-group">
                    <form:label path="date" for="date">Data</form:label>
                    <form:input path="date" name="date" type="text" class="form-control" id="date" placeholder="Data"/>
                </div>
                <div class="form-group">
                    <form:select class="form-control" path="users" multiple="true">
                        <form:option value="-" label="--Wybierz uczestników--"/>
                        <form:options itemValue="id" itemLabel="name" items="${users}"/>
                    </form:select>
                </div>

                <form:button type="submit" class="btn btn-primary">Zapisz</form:button>

            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form:form>
    </div>
</div>
<jsp:include page="footer.jsp"/>
