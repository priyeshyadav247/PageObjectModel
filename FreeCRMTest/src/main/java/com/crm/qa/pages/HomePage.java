package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[text()='Priyesh Yadav']")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@href='/contacts']//span[1]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@href='/contacts']/following-sibling::button[1]")
	WebElement newcontactsLink;
	
	@FindBy(xpath="//a[@href='/deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@href='/tasks']//span[1]")
	WebElement tasksLink;
	
	// Initialize the PageObject
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
		
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();// if we click on cotacts ,it should return contacts page object
	}
	

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();// if we click on deals ,it should return deals page object
	}
	
	public TaskPage clickOnTasksLink() {
		tasksLink.click();
		return new TaskPage();// like that
	}
	
	public void clickOnNewContactLink() {
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newcontactsLink.click();
	}
}
