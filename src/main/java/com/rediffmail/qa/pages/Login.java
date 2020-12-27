package com.rediffmail.qa.pages;

import com.rediffmail.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends TestBase {

	
	//PageFactory or ObjectRepository OR
	
	@FindBy(name= "username")
	WebElement username;
	
	@FindBy(name= "password")
	WebElement password;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]")
	WebElement LogInBtn;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div[2]/form/div[2]/div/a/u")
	WebElement SignInBtn;
	
	//initializing the page objects
	public Login() {
		   
		PageFactory.initElements(driver, this);		
	}
	//Actions-
	public String ValidateLoginPageTitle() {
			
		return driver.getTitle();	
	}
	
	public HomePage login(String un, String psw) {
		
		username.sendKeys(un);
		password.sendKeys(psw);
		LogInBtn.click();
		
		return new HomePage();
	}
	
	
	
	
	
}
