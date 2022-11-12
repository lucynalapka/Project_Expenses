<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Moje wyjazdy</h1>
        <a href="<c:url value="/trips/create"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Dodaj wyjazd</a>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Lista wyjazdów</h6>
        </div>

        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <h3 class="m-0 font-weight-bold text-primary">Koszt na osobę: ${expense.settle} zł</h3>
                    </tr>
                    <tr>
                        <td>
                            <a href="<c:url value="/trips"/>"
                               class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                                <i class="h3 mb-0 text-gray-800"></i> Powrót</a>
                        </td>
                    </tr>

                </table>
            </div>
        </div>
    </div>
</div>
<!-- /.container-fluid -->
<jsp:include page="footer.jsp"/>