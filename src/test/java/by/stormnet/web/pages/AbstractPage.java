package by.stormnet.web.pages;

import by.stormnet.automation.core.FrameworkCore;
import by.stormnet.automation.core.utils.PauseLenght;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AbstractPage extends FrameworkCore {
    private static WebDriver driver = getInstance();

    public WebDriver getDriver() {
        return driver;
    }

    public void openUrl(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, 10);
            waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLenght.MAX.value());
            waiter.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    public static By getElementBy(String element) {
        return By.xpath(element);
    }

    public static By getElementByClass(String element) {
        return By.className(element);
    }

    public WebElement getElement(String element) {
        return driver.findElement(By.xpath(element));
    }

    public WebElement getElementC(String element) {
        return driver.findElement(By.className(element));
    }

    public List<WebElement> getElements(String element) {
        return driver.findElements(By.xpath(element));
    }

    public List<String> getTabs() {
        Set<String> wh = driver.getWindowHandles();
        List<String> list = new ArrayList<>(wh);
        return list;
    }

    public void navigateToTab(int num, List<String> webHendlers) {
        driver.switchTo().window(webHendlers.get(num));
    }

    public int getResultsNumber(String element) {
        String str = getElement(element).getText();
        String[] transfer = str.split(" ");
        return Integer.valueOf(transfer[0]);
    }

    public void jsExe (WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

   /* public int getResolusionNumber(String element) {
        String str = getElement(element).getText();
        String[] transfer = str.split(".|\"");
        return Integer.valueOf(transfer[0]);
    }*/

}
