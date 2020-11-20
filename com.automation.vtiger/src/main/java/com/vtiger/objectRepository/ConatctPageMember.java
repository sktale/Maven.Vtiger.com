package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConatctPageMember {
	

	@FindBy(css="img[title='Create Contact...']")
	private WebElement CreateNewConatctPlusIcon;

}
