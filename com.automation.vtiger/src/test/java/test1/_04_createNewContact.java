package test1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericLib._01_finalVersionOfBaseClass;
@Listeners(com.vtiger.genericLib.ListnerImplementation.class)
public class _04_createNewContact  extends _01_finalVersionOfBaseClass{
	
	@Test
	
	private void createNewContact() throws Exception {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				driver.findElement(By.linkText("Contacts")).click();
				// here use soft assert to validate contact page displaying or no
				
				String actulTitle = driver.getTitle();
				String expectedTitle = picker.getDataFromExcel("Sheet1", 16, 2);
				//create object in baseclass
				System.out.println(actulTitle);
				soft.assertTrue(actulTitle.contains("Contacts"));
				
				
				driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
				
				driver.findElement(By.name("lastname")).sendKeys(picker.getDataFromExcel("Sheet1", 15, 2));
				
				
				
				//for listner screenshot fail this 
				driver.findElement(By.cssSelector("input[value='  Save  ']")).click();
				
				//driver.findElement(By.cssSelector("input[va ']")).click();
				
				
				
				
				
				
				String actualResult = driver.findElement(By.cssSelector("span[class='dvHeaderText']")).getText();
				System.out.println(actualResult);
			String result =	actualResult.contains(picker.getDataFromExcel("Sheet1", 15, 2)) ? "Test Pass" : "Test fail";
			System.out.println(result);
				
				
				//>>>>>Hard assert for TestCase Validation
				Assert.assertTrue(actualResult.contains(picker.getDataFromExcel("Sheet1", 15, 2)));

				
				soft.assertAll();
	}

}
