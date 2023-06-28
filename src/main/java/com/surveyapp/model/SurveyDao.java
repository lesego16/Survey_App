package com.surveyapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.surveyapp.jdbc.config.JDBCCONFIG;


public class SurveyDao {
	
	public static final double ROUNDING_FACTOR = 10.0;
	
	public int insertSurvey(Survey survey) throws SQLException{
		
		final String SQL_INSERT = "INSERT INTO survey (last_name, first_name, phone_number, survey_date, age, likes_pizza, likes_pasta, likes_pap_and_wors, likes_beef, likes_other, rate_eat_out, rate_watch_movies, rate_watch_tv, rate_listen_radio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		
		try(Connection connection =  JDBCCONFIG.getConnection();
				//Step 2: create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)){
			    preparedStatement.setString(1, survey.getLastname());
			    preparedStatement.setString(2, survey.getFirstName());
			    preparedStatement.setString(3, survey.getContactNumber());
			    preparedStatement.setDate(4, new java.sql.Date(survey.getDateOfSurvey().getTime()));
			    preparedStatement.setInt(5, survey.getAge());
			    preparedStatement.setBoolean(6,survey.isPizza());
			    preparedStatement.setBoolean(7,survey.isPasta());
			    preparedStatement.setBoolean(8,survey.isPapAndWors());
			    preparedStatement.setBoolean(9, survey.isBeefStirFry());
			    preparedStatement.setBoolean(10, survey.isOther());
			    preparedStatement.setInt(11, survey.getEatOut());
			    preparedStatement.setInt(12, survey.getWatchMovies());
			    preparedStatement.setInt(13, survey.getWatchTV());
			    preparedStatement.setInt(14, survey.getListenToRadio());
			    
			  //Step 3: Execute the query or update query
				result = preparedStatement.executeUpdate();
			    
		}
		
		return result;
		
		
	}
	
	public int getTotalSurveys(){
		
		final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM survey";
		int count = 0;
		
		try(Connection connection =  JDBCCONFIG.getConnection();
				//Step 2: create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_COUNT)){
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					count = resultSet.getInt(1);
				}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
		
	}
	
	public int getAverageAge(){
		
		final String SQL_SELECT_AVERAGE = "SELECT AVG(age) FROM survey";
		int averageAge = 0;
		
		try(Connection connection =  JDBCCONFIG.getConnection();
				//Step 2: create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_AVERAGE)){
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					averageAge = (int) Math.round(resultSet.getDouble(1));
				}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return averageAge;
		
	}
	
	public int getOldestAge(){
		
		final String SQL_MAX = "SELECT MAX(age) FROM survey";
		int oldestAge = 0;
		
		try(Connection connection =  JDBCCONFIG.getConnection();
				//Step 2: create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_MAX)){
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					oldestAge = resultSet.getInt(1);
				}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return oldestAge;
		
		
	}
	
	public int getYoungestAge(){
		
		final String SQL_MIN = "SELECT MIN(age) FROM survey";
		int youngestAge = 0;
		
		try(Connection connection =  JDBCCONFIG.getConnection();
				//Step 2: create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_MIN)){
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					youngestAge = resultSet.getInt(1);
				}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return youngestAge;
		
	}
	
	
	public int getCountOfFavouriteFood(String SQL_COUNT){
		
		int count = 0;
		
		try(Connection connection =  JDBCCONFIG.getConnection();
				//Step 2: create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_COUNT)){
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					count = resultSet.getInt(1);
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int getCountOfPizza() {
		
		final String SQL_COUNT = "SELECT COUNT(*) FROM survey WHERE likes_pizza = true";
		
		return getCountOfFavouriteFood(SQL_COUNT);
		
	}
	
	public int getCountOfPasta() {
		
		final String SQL_COUNT = "SELECT COUNT(*) FROM survey WHERE likes_pasta = true";
		
		return getCountOfFavouriteFood(SQL_COUNT);
		
	}
	
	public int getCountOfPapAndWors() {
		
		final String SQL_COUNT = "SELECT COUNT(*) FROM survey WHERE likes_pap_and_wors = true";
		
		return getCountOfFavouriteFood(SQL_COUNT);
		
	}
	
	public double getPizzaPercentage() {
		
		int totalSurvey = getTotalSurveys();
		int totalPizzaLikes = getCountOfPizza();
		double percentage = 0.0;
		
		if(totalSurvey > 0) {
			
			percentage = ((double)totalPizzaLikes/totalSurvey)*100;
			percentage = Math.round(percentage*ROUNDING_FACTOR)/ROUNDING_FACTOR;
		}
		
		return percentage;
	}
	
	public double getPastaPercentage() {
		
		int totalSurvey = getTotalSurveys();
		int totalPastaLikes = getCountOfPasta();
		double percentage = 0.0;
		
		if(totalSurvey > 0) {
			
			percentage = ((double)totalPastaLikes/totalSurvey)*100;
			percentage = Math.round(percentage*ROUNDING_FACTOR)/ROUNDING_FACTOR;
		}
		
		return percentage;
	}
	
	public double getPapAndWorsPercentage() {
		
		int totalSurvey = getTotalSurveys();
		int totalPapAndWors = getCountOfPapAndWors();
		double percentage = 0.0;
			
		percentage = ((double)totalPapAndWors/totalSurvey)*100;
		percentage = Math.round(percentage*10.0)/10.0;
		
		return percentage;
	}
	
	public int getSumOfRating(String SQL_SUM) {
		
		int totalRating = 0;
		
		try(Connection connection =  JDBCCONFIG.getConnection();
				//Step 2: create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SUM)){
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					totalRating = resultSet.getInt(1);
				}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalRating;
	}
	
	public int getSumOfEatOut() {
		
		final String SQL_SUM = "SELECT SUM(rate_eat_out) FROM survey";
		
		return  getSumOfRating(SQL_SUM);
		
	}
	
	public int getSumWatchMovies() {
		
		final String SQL_SUM = "SELECT SUM(rate_watch_movies) FROM survey";
		
		return  getSumOfRating(SQL_SUM);
		
	}
	
	public int getSumWatchTV() {
		
		final String SQL_SUM = "SELECT SUM(rate_watch_tv) FROM survey";
		
		return  getSumOfRating(SQL_SUM);
		
	}
	
	public int getSumListenRadio() {
		
		final String SQL_SUM = "SELECT SUM(rate_listen_radio) FROM survey";
		
		return  getSumOfRating(SQL_SUM);
		
	}
	
	public double getAverageRatingEatOut() {
		
		int sumOfEatOut = getSumOfEatOut();
		int totalSurveys = getTotalSurveys();
		double averageRating = (double)sumOfEatOut/totalSurveys;
		
		
		averageRating = Math.round(averageRating*ROUNDING_FACTOR)/ROUNDING_FACTOR;
		
		return averageRating;
	}
	
	public double getAverageRatingWatchMovies() {
		
		int sumOfWatchMovies = getSumWatchMovies();
		int totalSurveys = getTotalSurveys();
		double averageRating = (double)sumOfWatchMovies/totalSurveys;
		
		
		averageRating = Math.round(averageRating*ROUNDING_FACTOR)/ROUNDING_FACTOR;
		
		return averageRating;
	}
	
	public double getAverageRatingWatchTV() {
		
		int sumOfWatchTV = getSumWatchTV();
		int totalSurveys = getTotalSurveys();
		double averageRating = (double)sumOfWatchTV/totalSurveys;
		
		
		averageRating = Math.round(averageRating*ROUNDING_FACTOR)/ROUNDING_FACTOR;
		
		return averageRating;
	}
	
	public double getAverageRatingListenRadio() {
		
		int sumOfListenRadio = getSumListenRadio();
		int totalSurveys = getTotalSurveys();
		double averageRating = (double)sumOfListenRadio/totalSurveys;
		
		
		averageRating = Math.round(averageRating*ROUNDING_FACTOR)/ROUNDING_FACTOR;
		
		return averageRating;
	}
	

}


