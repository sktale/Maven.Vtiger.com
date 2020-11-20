package com.vtiger.objectRepository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductInformationPageMember {

	@FindBy(css="span[class='lvtHeaderText']")
	private WebElement productCeatedSuccess_msg;
	
	public WebElement getProductCreatedSuccess_Msg() {
		return productCeatedSuccess_msg;
	}
}
