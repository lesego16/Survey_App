package com.surveyapp.controller;

import java.io.IOException;

import com.surveyapp.model.SurveyDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ResultsController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SurveyDao surveyDao;
	

	
	public ResultsController() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		surveyDao = new SurveyDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int totalSurvey = surveyDao.getTotalSurveys();
		int averageAge = surveyDao.getAverageAge();
		int oldestPerson = surveyDao.getOldestAge();
		int youngestPeron = surveyDao. getYoungestAge();
		
		double likePizza = surveyDao.getPizzaPercentage();
		double likePasta = surveyDao.getPastaPercentage();
		double likePapAndWors = surveyDao.getPapAndWorsPercentage();
		
		double rateEatOut = surveyDao.getAverageRatingEatOut();
		double rateWatchMovies = surveyDao.getAverageRatingWatchMovies();
		double rateWatchTv = surveyDao.getAverageRatingWatchTV();
		double rateListenRadio = surveyDao.getAverageRatingListenRadio();
		
		request.setAttribute("totalSurvey", totalSurvey);
		request.setAttribute("averageAge", averageAge);
		request.setAttribute("oldestPerson", oldestPerson);
		request.setAttribute("youngestPeron", youngestPeron);
		
		request.setAttribute("likePizza", likePizza);
		request.setAttribute("likePasta", likePasta);
		request.setAttribute("likePapAndWors", likePapAndWors);
		
		request.setAttribute("rateEatOut", rateEatOut);
		request.setAttribute("rateWatchMovies", rateWatchMovies);
		request.setAttribute("rateWatchTv", rateWatchTv);
		request.setAttribute("rateListenRadio", rateListenRadio);
		
		if(request.getParameter("view-survey") != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("survey-results.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btn-ok") != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}
	
	
}