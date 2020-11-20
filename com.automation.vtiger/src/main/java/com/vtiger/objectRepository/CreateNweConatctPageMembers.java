package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNweConatctPageMembers {
	
	@FindBy(name="lastname")
	private WebElement lastName_tf;
	
	@FindBy(css ="input[value='  Save  ']")
	private WebElement saveBtn;
	
	public WebElement getLastName_TF()
	{
		return lastName_tf;
	}

	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	

}
