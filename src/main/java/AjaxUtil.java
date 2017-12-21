package main.java;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxUtil {
	
	
		
		public static boolean waitForAjax(WebDriver driver) {

			WebDriverWait wait = new WebDriverWait(driver, 30);

			ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
				
				public Boolean apply(WebDriver driver) {
					try {
						return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
					} catch (Exception e) {

						return true;
					}
				}
			};

			ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
				
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
							.equals("complete");
				}
			};

			return wait.until(jQueryLoad) && wait.until(jsLoad);
		}
		
	 

}
