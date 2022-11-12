<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>


<div id="content-wrapper">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">


        <a href="<c:url value="/register"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="h3 mb-0 text-gray-800"></i> Zarejestruj</a>
        <a href="<c:url value="/login"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="h3 mb-0 text-gray-800"></i> Zaloguj</a>


        <a href="<c:url value="/trips"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="h3 mb-0 text-gray-800"></i> Moje wyjazdy</a>

    </div>
</div>
<!-- /.content-wrapper -->

<jsp:include page="footer.jsp"/>