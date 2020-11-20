package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageMembers {
	
	@FindBy(css ="img[title='Create Product...']")
	private WebElement createProductplusIcon;
	
	public WebElement getcreateProductplusIcon() {
		return createProductplusIcon;
	}

}
