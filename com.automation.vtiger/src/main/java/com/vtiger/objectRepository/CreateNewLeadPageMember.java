package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewLeadPageMember {
	
	@FindBy(name="lastname")
	private WebElement lastName_tf;
	
	@FindBy(name="company")
	private WebElement companyName_tf;
	
	@FindBy(css ="input[value='  Save  ']")
	private WebElement saveBtn;
	
	
	public WebElement getLastName_TF()
	{
		return lastName_tf;
	}
	
	public WebElement getCompanyName_TF()
	{
		return companyName_tf;
	}
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
}
