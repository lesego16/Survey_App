<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Bootstrap/bootstrap.css">
<link rel="stylesheet" href="Css/styles.css">
<title>surveyform | App</title>
</head>
<body>
    <jsp:include page="navbar.jsp"></jsp:include>

    <div class="container mt-4">
        <h3 class="mb-4">Take our Survey</h3>
        <div style="color: red">${ NOTIFICATION }</div>
        <form method="post" action="<%= request.getContextPath()%>/SurveyController">
            <div class="row mb-3">
                <label for="inputEmail3" class="col-sm-2 col-form-label">Surname</label>
                <div class="col-sm-10">
                	<div style="color: red">${ errormessage }</div>
                    <input type="text" name="lastname" class="form-control" id="inputEmail3">
                </div>
            </div>
            <div class="row mb-3">
                <label for="inputPassword3" class="col-sm-2 col-form-label">First Name</label>
                <div class="col-sm-10">
                    <input type="text" name="firstname" class="form-control" id="inputPassword3">
                </div>
            </div>
            <div class="row mb-3">
                <label for="inputEmail3" class="col-sm-2 col-form-label">Contact Number</label>
                <div class="col-sm-10">
                	<div style="color: red">${ contactnumbererrormessage }</div>
                    <input type="text" name="contactnumber" class="form-control" id="inputEmail3">
                </div>
            </div>
            <div class="row mb-3">
                <label for="inputPassword3" class="col-sm-2 col-form-label">Date</label>
                <div class="col-sm-10">
                    <input type="date" name="date" class="form-control" id="inputPassword3">
                </div>
            </div>
            <div class="row mb-3">
                <label for="inputPassword3" class="col-sm-2 col-form-label">Age</label>
                <div class="col-sm-10">
                	<div style="color: red">${ ageerrormessage }</div>
                    <input type="text" name="age" class="form-control" id="inputPassword3">
                </div>
            </div>
            <div style="color: red">${ favouritefooderrormessage }</div>
            <fieldset class="row mb-3">
                <legend class="col-form-label col-sm-2 pt-0">What is your favourite food? (You can choose more than 1)
                </legend>
                <div class="col-sm-10">
                    <div class="row mb-3">
                        <div class="col-sm-10 offset-sm-2">
                            <div class="form-check">
                                <input class="form-check-input" name="likes_pizza" type="checkbox" id="gridCheck1" value="true">
                                <label class="form-check-label" for="gridCheck1">
                                    Pizza
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-sm-10 offset-sm-2">
                            <div class="form-check">
                                <input class="form-check-input" name="likes_pasta" type="checkbox" id="gridCheck1" value="true">
                                <label class="form-check-label" for="gridCheck1">
                                    Pasta
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-sm-10 offset-sm-2">
                            <div class="form-check">
                                <input class="form-check-input" name="likes_pap_wors" type="checkbox" id="gridCheck1" value="true">
                                <label class="form-check-label" for="gridCheck1">
                                    Pap and Wors
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-sm-10 offset-sm-2">
                            <div class="form-check">
                                <input class="form-check-input" name="beef_stir_fry" type="checkbox" id="gridCheck1" value="true">
                                <label class="form-check-label" for="gridCheck1">
                                    Beef Stir Fry
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-sm-10 offset-sm-2">
                            <div class="form-check">
                                <input class="form-check-input" name="other" type="checkbox" id="gridCheck1" value="true">
                                <label class="form-check-label" for="gridCheck1">
                                    Other
                                </label>
                            </div>
                        </div>
                    </div>
                </div>

            </fieldset>

			<div style="color: red">${ ratinganderrormessage }</div>
            <h6>on a scale of 1 to 5 indicate whether you strongly disagree</h6>
            <section class="intro">
                <div class="bg-image h-100">
                    <div class="mask d-flex align-items-center h-100">
                        <div class="container">
                            <div class="row justify-content-center">
                                <div class="col-12">
                                    <div class="card bg">
                                        <div class="card-body">
                                            <div class="table-responsive">
                                                <table class="table table-hover mb-0">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col"></th>
                                                            <th scope="col">Strongly agree(1)</th>
                                                            <th scope="col">Agree(2)</th>
                                                            <th scope="col">Neutral(3)</th>
                                                            <th scope="col">Disagree(4)</th>
                                                            <th scope="col">Strongly disagree(5)</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <th scope="row">I like to eat out</th>
                                                            <td><input type="radio" name="eat" value="1"></td>
                                                            <td><input type="radio" name="eat" value="2"></td>
                                                            <td><input type="radio" name="eat" value="3"></td>
                                                            <td><input type="radio" name="eat" value="4"></td>
                                                            <td><input type="radio" name="eat" value="5"></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">I like to watch movies</th>
                                                            <td><input type="radio" name="movies" value="1"></td>
                                                            <td><input type="radio" name="movies" value="2"></td>
                                                            <td><input type="radio" name="movies" value="3"></td>
                                                            <td><input type="radio" name="movies" value="4"></td>
                                                            <td><input type="radio" name="movies" value="4"></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">I like to watch TV</th>
                                                            <td><input type="radio" name="tv" value="1"></td>
                                                            <td><input type="radio" name="tv" value="2"></td>
                                                            <td><input type="radio" name="tv" value="3"></td>
                                                            <td><input type="radio" name="tv" value="4"></td>
                                                            <td><input type="radio" name="tv" value="5"></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">I like to listen to the radio</th>
                                                            <td><input type="radio" name="rd" value="1"></td>
                                                            <td><input type="radio" name="rd" value="2"></td>
                                                            <td><input type="radio" name="rd" value="3"></td>
                                                            <td><input type="radio" name="rd" value="4"></td>
                                                            <td><input type="radio" name="rd" value="5"></td>
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
            </section>

            <button type="submit" class="btn btn-primary mb-4">Submit</button>
        </form>
    </div>

    <script src="Bootstrap/bootstrap.js"></script>
</body>
</html>