package com.makemyTrip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactoryFinder;

public class LoginPage {

	@FindBy(id="hsw_search_button")
	private WebElement searchButton;
	
	@FindBy(xpath = "hsw_search_button")
	private WebElement searchBtn;	

	@FindBy(how = How.XPATH, xpath = "hsw_search_button")
	private List<WebElement> searchBtns;	

}
