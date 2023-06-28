<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Bootstrap/bootstrap.css">
<link rel="stylesheet" href="Css/styles.css">
<title>surveyresults | App</title>
</head>

<body>
    <jsp:include page="navbar.jsp"></jsp:include>

    <div class="container">
    <form method="post" action="<%= request.getContextPath()%>/ResultsController">
	    		<div class="d-flex justify-content-between mt-4 mb-2">
	            <div>
	                <div>Total number of surveys:</div>
	                <div>Average age:</div>
	                <div>Oldest person who participated in survey:</div>
	                <div>Youngest person who participated in survey:</div>
	            </div>
	            <div>
	                <div>${totalSurvey}</div>
	                <div>${averageAge}</div>
	                <div>${oldestPerson}</div>
	                <div>${youngestPeron}</div>
	            </div>
	        </div>
	        <div class="d-flex justify-content-between mt-4 mb-2">
	            <div>
	                <div>Percentage of people who like pizza:</div>
	                <div>Percentage of people who like pasta:</div>
	                <div>Percentage of people who like pap and wors:</div>
	            </div>
	            <div>
	                <div>${likePizza}%</div>
	                <div>${likePasta}%</div>
	                <div>${likePapAndWors}%</div>
	            </div>
	        </div>
	        <div class="d-flex justify-content-between mt-4 mb-4">
	            <div>
	                <div>People like to eat out:</div>
	                <div>People like to watch movies:</div>
	                <div>People like to watch TV:</div>
	                <div>People like to listen to the radio:</div>
	            </div>
	            <div>
	                <div>${rateEatOut}</div>
	                <div>${rateWatchMovies}</div>
	                <div>${rateWatchTv}</div>
	                <div>${rateListenRadio}</div>
	            </div>
	        </div>
	        	<button type="submit" name="btn-ok" class="btn btn-primary btn-lg btn-block d-block mx-auto">ok</button>
    		</form>
    </div>

</body>
</html>