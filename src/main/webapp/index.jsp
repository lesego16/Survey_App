<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Bootstrap/bootstrap.css">
<link rel="stylesheet" href="Css/styles.css">
<title>Survey | App</title>
</head>
<body class="scroll">
    <jsp:include page="navbar.jsp"></jsp:include>

    <section class="vh-100">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="wrapper card shadow-2-strong" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">
                            <a href="survey-form.jsp" class="btn btn-primary btn-lg btn-block" type="submit">fill out
                                survey</a><br><br>
                                <form method="get" action="<%= request.getContextPath()%>/ResultsController">
                                	<button name="view-survey" class="btn btn-primary btn-lg btn-block" type="submit">view survey</button>
                                </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script src="Bootstrap/bootstrap.js"></script>
</body>
</html>