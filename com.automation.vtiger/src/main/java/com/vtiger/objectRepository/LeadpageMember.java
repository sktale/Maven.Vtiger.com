package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadpageMember {
	
	@FindBy(css="img[title='Create Lead...']")
	private WebElement createLeadPlusIncon;
	
	public WebElement getCreatLeadPlusIcon() {
		return createLeadPlusIncon;
	}

}
