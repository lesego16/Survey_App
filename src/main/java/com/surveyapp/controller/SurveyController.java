package com.surveyapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import com.surveyapp.model.Survey;
import com.surveyapp.model.SurveyDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SurveyController extends HttpServlet{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SurveyDao surveyDao;
	
	public SurveyController() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		surveyDao = new SurveyDao();
	}	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		insertIntoDatabase(request, response);
	}
	
	private void insertIntoDatabase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String lastName = request.getParameter("lastname");
		String firstName = request.getParameter("firstname");
		String contactNumber = request.getParameter("contactnumber");
		String surveyDate = request.getParameter("date");
		String age = request.getParameter("age");
		String likePizza = request.getParameter("likes_pizza");
		String likePasta = request.getParameter("likes_pasta");
		String likePapAndWors = request.getParameter("likes_pap_wors");
		String likeBeefStirFry = request.getParameter("beef_stir_fry");
		String likeOther = request.getParameter("other");
		String rateEatOut = request.getParameter("eat");
		String rateWatchMovies = request.getParameter("movies");
		String rateWatchTv = request.getParameter("tv");
		String rateListenRadio = request.getParameter("rd");
		
		if(lastName == null || lastName.isEmpty() || 
				firstName == null || firstName.isEmpty() || 
				contactNumber == null || contactNumber.isEmpty() || 
				surveyDate == null || surveyDate.isEmpty() || 
				age == null || age.isEmpty()) {
			
				request.setAttribute("errormessage", "cannot be empty");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("survey-form.jsp");
				requestDispatcher.forward(request, response);
				return;
		}
		
		if(!contactNumber.matches("^0[0-9]{9}$")) {
			request.setAttribute("contactnumbererrormessage", "Invalid contact number format! Contact number should begin with 0 and followed by 9 digits");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("survey-form.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		
		if(likePizza == null && likePasta == null && likePapAndWors == null && likeBeefStirFry == null && likeOther == null) {
			request.setAttribute("favouritefooderrormessage", "Please select atleast 1 favourite food");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("survey-form.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		
		if((rateEatOut == null || rateWatchMovies == null) || (rateWatchTv == null || rateListenRadio == null)) {
			request.setAttribute("ratinganderrormessage", "Please select the ratings");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("survey-form.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = null;
		
		try {
			utilDate  = dateFormat.parse(surveyDate);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		
		int ageInt = Integer.parseInt(age);
		if(ageInt < 5 || ageInt > 120) {
			request.setAttribute("ageerrormessage", "Age must be betweeen 5 and 120");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("survey-form.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		
		boolean likesPizzaBoolean = Boolean.parseBoolean(likePizza);
		boolean likesPastaBoolean = Boolean.parseBoolean(likePasta);
		boolean likesPapAndWorsBoolean = Boolean.parseBoolean(likePapAndWors);
		boolean likesBeefStirFryBoolean = Boolean.parseBoolean(likeBeefStirFry);
		boolean likesOtherBoolean = Boolean.parseBoolean(likeOther);
		int rateEatOutInt = Integer.parseInt(rateEatOut);
		int rateWatchMoviesInt = Integer.parseInt(rateWatchMovies);
		int rateWatchTvInt = Integer.parseInt(rateWatchTv);
		int rateListenRadioInt = Integer.parseInt(rateListenRadio);
		
		Survey survey = new Survey(lastName, firstName, contactNumber, 
				sqlDate, ageInt, likesPizzaBoolean, likesPastaBoolean, 
				likesPapAndWorsBoolean, likesBeefStirFryBoolean, 
				likesOtherBoolean, rateEatOutInt, rateWatchMoviesInt, 
				rateWatchTvInt, rateListenRadioInt);
		
		
		
		try {
			
			surveyDao.insertSurvey(survey);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
			
		}catch(SQLException e) {
			request.setAttribute("NOTIFICATION", "There was an error submitting the form, Please try again!");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("survey-form.jsp");
			requestDispatcher.forward(request, response);
		}
	}
	
	

}
