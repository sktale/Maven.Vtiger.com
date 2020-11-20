package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPageInformationPageMembers {

	@FindBy(css="span[class='dvHeaderText']")
	private WebElement contactCretedSuccessfulMsg;
	
	public WebElement getContactCreatedSuccessMsg() {
		return contactCretedSuccessfulMsg;
	}
}
