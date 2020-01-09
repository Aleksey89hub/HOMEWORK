package by.stormnet.web.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import javax.xml.ws.WebEndpoint;
import java.util.List;
import java.util.Random;

public class OnlinerFilterPage extends AbstractPage {
    private static String pageCheck = "//div[@class='schema-filter-button__state schema-filter-button__state_initial schema-filter-button__state_disabled']";
    private static String checkBox = "//li/label/span[2][text()='";
    private static String resultItem = "//div[@class='schema-product__part schema-product__part_2']/div[2]/div[1]";

    public static OnlinerFilterPage getOnlinerFilterPage() {
        OnlinerFilterPage onFP = new OnlinerFilterPage();
        waitForElementVisible(getElementBy(pageCheck));
        System.out.println("Catalog page is opened");
        return onFP;
    }

    public OnlinerFilterPage tickCheckbox (String param){
        String str = checkBox+param+"']";
        WebElement element = getElement(str);
        jsExe(element);
        getElement(str).click();
        return getOnlinerFilterPage();
    }

    public void openItem(){
        Random obj = new Random();
        List<WebElement> items = getElements(resultItem);
        WebElement forOpen = items.get(obj.nextInt(items.size()));
        forOpen.click();
    }
}
