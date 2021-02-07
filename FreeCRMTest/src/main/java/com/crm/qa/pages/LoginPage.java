package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory-ObjectRepository:
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(@class,'ui fluid')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@href='https://api.cogmento.com/register']")
	WebElement signUpBtn;
	
	//Initilization:
	public LoginPage() {
		PageFactory.initElements(driver, this);// this -- means current class object // driver-  all the variables is initialize in driver.
	}
	
	//Actions:
	public String validateLoginPageTile()
	{
	return driver.getTitle();
	}
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage(); // returing home class object
	}
	
}
