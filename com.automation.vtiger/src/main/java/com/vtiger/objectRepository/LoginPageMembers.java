package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageMembers {

	@FindBy(name="user_name")
	private WebElement username_tf;
	
	@FindBy(name="user_password")
	private WebElement password_tf;
	
	@FindBy(id="submitButton")
	private WebElement login_btn;
	
	@FindBy(xpath ="You must specify")
	private WebElement error_msg;
	
	
	

//	public LoginPageMembers(WebDriver driver) {
//
//		username_tf = driver.findElement(By.name("user_name"));
//		password_tf = driver.findElement(By.name("user_password"));
//		login_btn = driver.findElement(By.id("submitButton"));
//
//	}

	public WebElement getUsernameField() {
		return username_tf;

	}
	public WebElement getPasswordField() {
		return password_tf;

	}public WebElement getloginBtn() {
		return login_btn;

	}
	public WebElement getErrorMsg() {
		return error_msg;
	}

	
	//creating generaic reuseable libraries
	public void loginToApp(String username,String password) {
		username_tf.sendKeys(username);
		password_tf.sendKeys(password);
		login_btn.click();
	}
}
