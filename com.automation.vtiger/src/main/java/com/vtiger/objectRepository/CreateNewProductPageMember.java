package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewProductPageMember {

	@FindBy(name="productname")
	private WebElement productName_tf;
	
	@FindBy(css="input[value='  Save  ']")
	private WebElement saveBtn;
	
	public WebElement getProductName_TF() {
		return productName_tf;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
}
