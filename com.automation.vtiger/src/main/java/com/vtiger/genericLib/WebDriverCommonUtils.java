package com.vtiger.genericLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.jcommander.Strings;

import junit.framework.Assert;

public class WebDriverCommonUtils {

	String mainId;
	String childId;

	public void waitForElementTobeVissible(By locatorValue) {
		WebDriverWait wait = new WebDriverWait(_01_finalVersionOfBaseClass.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorValue));

	}

	public void waitForAllElemetsToBeVissible(By locatorValue) {
		WebDriverWait wait = new WebDriverWait(_01_finalVersionOfBaseClass.driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorValue));
	}

	public void pickItemFromAutoSuggestion(List<WebElement> suggetionlist, String item) {

		for (WebElement wb : suggetionlist) {

			String listname = wb.getText();
			if (listname.contains(item))
				wb.click();
			break;
		}
	}

	public void switchToChildWindow() {
		Set<String> allId = _01_finalVersionOfBaseClass.driver.getWindowHandles();

		Iterator<String> itr = allId.iterator();
		mainId = itr.next();
		childId = itr.next();
		_01_finalVersionOfBaseClass.driver.switchTo().window(childId);

	}

	public void switchToMainWindow() {
		_01_finalVersionOfBaseClass.driver.switchTo().window(mainId);
	}

	public void pickItemFormList(WebElement ListElemets, String item) {

		Select s = new Select(ListElemets);
		s.selectByValue(item);
	}

	public List<WebElement> getAllOptionsFromList(WebElement ListElemets) {
		Select s = new Select(ListElemets);
		List<WebElement> options = s.getOptions();
		return options;
	}

	private void waitForAlert() {
		WebDriverWait wait = new WebDriverWait(_01_finalVersionOfBaseClass.driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert() {
		_01_finalVersionOfBaseClass.driver.switchTo().alert().accept();
	}

	public void rejectAlert() {

		_01_finalVersionOfBaseClass.driver.switchTo().alert().dismiss();
	}

	public void validatedAlertMessage(String expMsg) {

		Alert alt = _01_finalVersionOfBaseClass.driver.switchTo().alert();
		String altText = alt.getText();
		// Assert.assertTrue(altText.equalsIgnoreCase(expMsg));
		Assert.assertEquals(altText, expMsg);
		System.out.println("Alert Validate Successfuly");

	}

	public void mouseOverWebElelment(WebElement targetElement) {
		Actions act = new Actions(_01_finalVersionOfBaseClass.driver);
		act.moveToElement(targetElement).perform();
	}

	public void handleDragAndDrop(WebElement sourceElement, WebElement targetElement) {
		Actions act = new Actions(_01_finalVersionOfBaseClass.driver);
		act.dragAndDrop(sourceElement, sourceElement).build().perform();
	}

	public void scrollMainWindow(int horizotalDistance, int verticalDistance) {
		JavascriptExecutor jse = (JavascriptExecutor) _01_finalVersionOfBaseClass.driver;
		jse.executeScript("window.scrollBy(" + horizotalDistance + "," + verticalDistance + ")");
	}

	public void waitUpto(int timeInSec) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void uploadDocumet(WebElement uploadBtn, String filePath) {
		String typeValue = uploadBtn.getAttribute("type");

		if (typeValue.equalsIgnoreCase("file"))
			uploadBtn.sendKeys(filePath);

		else {
			uploadBtn.click();
			StringSelection path = new StringSelection(filePath);
			Toolkit tool = Toolkit.getDefaultToolkit();
			tool.getSystemClipboard().setContents(path, null);

			try {
				Robot r = new Robot();
				waitUpto(500);
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);
				waitUpto(500);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_V);
				waitUpto(500);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);

			} catch (AWTException e) {

				e.printStackTrace();
			}

		}
	}
}
