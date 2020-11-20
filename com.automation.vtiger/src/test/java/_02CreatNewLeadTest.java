

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.objectRepositary.CreateNewLeadPageMember;
import com.vtiger.objectRepositary.HomePageMember;
import com.vtiger.objectRepositary.LeadpageMember;
import com.vtiger.objectRepositary.LeadsInformationPageMember;
@Listeners(com.vtiger.genericLib.ListnerImplementation.class)
public class _02CreatNewLeadTest extends _01_finalVersionOfBaseClass {
	
	@Test
	private void creatlead() throws IOException {
		// TODO Auto-generated method stub
		
		HomePageMember hp= 	PageFactory.initElements(driver, HomePageMember.class);
		hp.getLeadLink().click();
		
		LeadpageMember lp = PageFactory.initElements(driver, LeadpageMember.class);
		lp.getCreatLeadPlusIcon().click();
		
		CreateNewLeadPageMember cnlp = PageFactory.initElements(driver, CreateNewLeadPageMember.class);
		
		
		cnlp.getLastName_TF().sendKeys(picker.getDataFromExcel("Sheet1", 1, 1));
		cnlp.getCompanyName_TF().sendKeys(picker.getDataFromExcel("Sheet1", 2, 1));
		
		//driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		

		//for listner screenshot fail this 
		cnlp.getSaveBtn().click();
		//driver.findElement(By.cssSelector("input[valu  ']")).click();
		
		LeadsInformationPageMember lip = PageFactory.initElements(driver, LeadsInformationPageMember.class);
		
		String actualResult =lip.getLeadSuccessMsg().getText();
		

		System.out.println(actualResult);
		
		Assert.assertTrue(actualResult.contains
				(picker.getDataFromExcel("Sheet1", 1, 1)));
		
		System.out.println("Create leads succsseful");
		
		
	/*	String 	result = actualResult.contains
			(picker.getDataFromExcel("Sheet1", 1, 1))? "Test Pass" :"Test fail" ; */
		
		
	}

}
