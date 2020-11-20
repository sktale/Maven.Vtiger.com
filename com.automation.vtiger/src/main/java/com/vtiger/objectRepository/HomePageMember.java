package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericLib._01_finalVersionOfBaseClass;
 



public class HomePageMember {
	
	@FindBy(xpath="//td[@class='genHeaderSmall']/following-sibling::td[1]")
	private WebElement signOutDD;
	
	@FindBy(linkText="Sign Out")
	private  WebElement logout_Link;
	
	@FindBy(linkText="Leads")
	private WebElement leadLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	
	public WebElement getSignOutDD()
	{
		return signOutDD;
	}
	
	public WebElement getLogout_Linkn()
	{
		return logout_Link;
	}
	
	public WebElement getLeadLink()
	{
		return leadLink;
	}
	
	public WebElement getProductLink() {
		return productLink;
	}
	
	public WebElement getContactLink() {
		return contactLink;
	}
	public void signOutfromApp()
	{
		Actions act = new  Actions (_01_finalVersionOfBaseClass.driver);
		act.moveToElement(signOutDD).perform();
		logout_Link.click();
	}

}
