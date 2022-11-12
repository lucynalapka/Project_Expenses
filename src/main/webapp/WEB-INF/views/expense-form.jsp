<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: cyluna--%>
<%--  Date: 01.11.2022--%>
<%--  Time: 15:57--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Podaj poniesione wydatki na wyjazd</h1>--%>
<%--<form:form method="post" modelAttribute="expense">--%>
<%--    <div>--%>
<%--        <form:label path="name">Nazwa</form:label>--%>
<%--        <form:input path="name"/>--%>
<%--            &lt;%&ndash;    <form:errors path="title" cssStyle="color: red"/>&ndash;%&gt;--%>
<%--    </div>--%>
<%--    <div>--%>
<%--    <form:label path="amount">Koszt</form:label>--%>
<%--    <form:input path="amount"/>--%>
<%--    &lt;%&ndash;    <form:errors path="title" cssStyle="color: red"/>&ndash;%&gt;--%>
<%--    </div>--%>
<%--    <div>--%>
<%--&lt;%&ndash;        <form:label path="paidFor">Osoby uczestniczące w danym koszcie</form:label>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <form:select path="paidFor" items="${paidFor}" itemLabel="name" itemValue="id"/>&ndash;%&gt;--%>
<%--            &lt;%&ndash;    <form:errors path="title" cssStyle="color: red"/>&ndash;%&gt;--%>
<%--        <form:select class="form-control" path="paidFor" multiple="true">--%>
<%--            <form:option value="-" label="--Osoby uczestniczące w danym koszcie--"/>--%>
<%--            <form:options itemValue="id" itemLabel="name" items="${paidFor}"/>--%>
<%--        </form:select>--%>
<%--    </div>--%>


<%--    <form:button>Zapisz</form:button>--%>
<%--</form:form>--%>
<%--</body>--%>
<%--</html>--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800"></h1>
        <a href="<c:url value="/expenses"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i>Dodaj wydatki </a>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Podaj poniesione wydatki na wyjazd</h6>
        </div>
        <form:form method="post" modelAttribute="expense">
            <div class="card-body">
                <div class="form-group">
                    <form:label path="name" for="name">Nazwa</form:label>
                    <form:input path="name" name="name" type="text" class="form-control" id="name" placeholder="Nazwa"/>
                </div>
                <div class="form-group">
                    <form:label path="amount" for="place">Wartość</form:label>
                    <form:input path="amount" name="amount" type="text" class="form-control" id="amount" placeholder="Wartość"/>
                        <%--          <label for="place">Miejsce</label>--%>
                        <%--          <input name="place" type="text" class="form-control" id="place" placeholder="Miejsce">--%>
                </div>

                <div class="form-group">

                    <form:select class="form-control" path="paidFor" multiple="true">
                        <form:option value="-" label="--Wybierz partycypujących w kosztach--"/>
                        <form:options itemValue="id" itemLabel="name" items="${paidFor}"/>
                    </form:select>
<%--                    <form:select class="form-control" path="paidFor" multiple="true">--%>
<%--                        <form:option value="-" label="--Osoby uczestniczące w danym koszcie--"/>--%>
<%--                        <form:options itemValue="id" itemLabel="name" items="${paidFor}"/>--%>
<%--                    </form:select>--%>

                </div>
                    <%--        <button type="submit" class="btn btn-primary">Zapisz</button>--%>
                <form:button  type="submit" class="btn btn-primary">Zapisz</form:button>

            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form:form>
    </div>
</div>
<jsp:include page="footer.jsp"/>