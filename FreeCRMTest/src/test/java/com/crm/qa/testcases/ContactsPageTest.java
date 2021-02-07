/*
 * hii hero this is for you
 */
package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName ="contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		 testUtil=new TestUtil(); // --- if frame is available // and excel sheet for ddata driver approch
		loginPage=new LoginPage();// accese all the fuction of loginpage class bcoz its not static
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));// bcoz we have to login 1st
		//testUtil.switchToFrame();
		contactsPage= homePage.clickOnContactsLink();
		
	}
	@Test(priority=1)
	public void verifyContactsPageLable() {
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	@Test(priority=2)
	public void selectContactsTest() {
		Assert.assertFalse((boolean) contactsPage.selectContacts());
	}
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	
	
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String fisrtName, String middleName,String lastName,String company) {
		homePage.clickOnNewContactLink();
	
		contactsPage.createNewContact(fisrtName, lastName, middleName, company);
	}
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
