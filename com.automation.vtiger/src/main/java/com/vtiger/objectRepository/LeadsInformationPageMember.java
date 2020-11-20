package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsInformationPageMember {

	
	@FindBy(css="span[class='dvHeaderText']")
	private WebElement leadSuccessMsg;
	
	
	public WebElement getLeadSuccessMsg() {
		return leadSuccessMsg;
	}
}
