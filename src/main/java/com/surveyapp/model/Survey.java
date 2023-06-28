package com.surveyapp.model;

import java.util.Date;

public class Survey{
	
	private String lastname;
	private String firstName;
	private String contactNumber;
	private Date dateOfSurvey;
	private int age;
	private boolean pizza;
	private boolean pasta;
	private boolean papAndWors;
	private boolean beefStirFry;
	private boolean other;
	private int eatOut;
	private int watchMovies;
	private int watchTV;
	private int listenToRadio;
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Date getDateOfSurvey() {
		return dateOfSurvey;
	}
	public void setDateOfSurvey(Date dateOfSurvey) {
		this.dateOfSurvey = dateOfSurvey;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isPizza() {
		return pizza;
	}
	public void setPizza(boolean pizza) {
		this.pizza = pizza;
	}
	public boolean isPasta() {
		return pasta;
	}
	public void setPasta(boolean pasta) {
		this.pasta = pasta;
	}
	public boolean isPapAndWors() {
		return papAndWors;
	}
	public void setPapAndWors(boolean papAndWors) {
		this.papAndWors = papAndWors;
	}
	public boolean isBeefStirFry() {
		return beefStirFry;
	}
	public void setBeefStirFry(boolean beefStirFry) {
		this.beefStirFry = beefStirFry;
	}
	public boolean isOther() {
		return other;
	}
	public void setOther(boolean other) {
		this.other = other;
	}
	public int getEatOut() {
		return eatOut;
	}
	public void setEatOut(int eatOut) {
		this.eatOut = eatOut;
	}
	public int getWatchMovies() {
		return watchMovies;
	}
	public void setWatchMovies(int watchMovies) {
		this.watchMovies = watchMovies;
	}
	public int getWatchTV() {
		return watchTV;
	}
	public void setWatchTV(int watchTV) {
		this.watchTV = watchTV;
	}
	public int getListenToRadio() {
		return listenToRadio;
	}
	public void setListenToRadio(int listenToRadio) {
		this.listenToRadio = listenToRadio;
	}
	public Survey(String lastname, String firstName, String contactNumber, Date dateOfSurvey, int age, boolean pizza,
			boolean pasta, boolean papAndWors, boolean beefStirFry, boolean other, int eatOut, int watchMovies,
			int watchTV, int listenToRadio) {
		super();
		this.lastname = lastname;
		this.firstName = firstName;
		this.contactNumber = contactNumber;
		this.dateOfSurvey = dateOfSurvey;
		this.age = age;
		this.pizza = pizza;
		this.pasta = pasta;
		this.papAndWors = papAndWors;
		this.beefStirFry = beefStirFry;
		this.other = other;
		this.eatOut = eatOut;
		this.watchMovies = watchMovies;
		this.watchTV = watchTV;
		this.listenToRadio = listenToRadio;
	}
	public Survey() {
		
	}

}
