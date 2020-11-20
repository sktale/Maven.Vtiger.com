package test1;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericLib._01_finalVersionOfBaseClass;
import com.vtiger.objectRepository.CreateNewProductPageMember;
import com.vtiger.objectRepository.HomePageMember;
import com.vtiger.objectRepository.ProductInformationPageMember;
import com.vtiger.objectRepository.ProductPageMembers;

import junit.framework.Assert;
@Listeners(com.vtiger.genericLib.ListnerImplementation.class)
public class _02CreatNewProductTest extends _01_finalVersionOfBaseClass {

	@Test
	private void cretwNewProduct() throws IOException {
		// TODO Auto-generated method stub
		HomePageMember hp= 	PageFactory.initElements(driver, HomePageMember.class);
		hp.getProductLink().click();
		
		
		ProductPageMembers pp = PageFactory.initElements(driver, ProductPageMembers.class);
		pp.getcreateProductplusIcon().click();
		
		CreateNewProductPageMember cnpp = PageFactory.initElements(driver, CreateNewProductPageMember.class);
				
		cnpp.getProductName_TF().sendKeys(picker.getDataFromExcel("Sheet1", 14, 2));

		//for listner screenshot fail this 
		cnpp.getSaveBtn().click();
	//	driver.findElement(By.cssSelector("input[valu  ']")).click();
		
		
		ProductInformationPageMember pip = PageFactory.initElements(driver, ProductInformationPageMember.class);
		
		
		String actualResult = pip.getProductCreatedSuccess_Msg().getText();
		System.out.println(actualResult);
	//String result =	actualResult.contains(picker.getDataFromExcel("Sheet1", 14, 2)) ? "Test Pass" : "Test fail";

		Assert.assertTrue(actualResult.contains(picker.getDataFromExcel("Sheet1", 14, 2)));
		Reporter.log("Product created successful",true);
		
	}

}
