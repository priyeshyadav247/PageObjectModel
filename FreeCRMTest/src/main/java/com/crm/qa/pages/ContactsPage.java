
/*
 * hii this is for GIT purpose
 */
package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//div[@id='main-nav']/div[3]/a[1]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement middleName;
	
	@FindBy(xpath="//div[@id='main-content']/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/input[1]")
	WebElement company;
	
	@FindBy(xpath="//button[contains(@class,'ui linkedin')]")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[@id='main-content']/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/label[1]")
	WebElement checkContacts;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public boolean selectContacts() {
		return checkContacts.isSelected();
		//driver.findElement(By.xpath("//div[@id='main-content']/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[7]/td[1]/div[1]/label[1]")).click();
	}
	
	// for creating new contact and save it 
	public void createNewContact(String ftName,String ltName,String miName, String comp) {
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		middleName.sendKeys(miName);
		company.sendKeys(comp);
		saveBtn.click();
	}
	
	
	
	
	
}
