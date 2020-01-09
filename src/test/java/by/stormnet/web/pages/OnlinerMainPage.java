package by.stormnet.web.pages;

import org.openqa.selenium.WebElement;

public class OnlinerMainPage extends AbstractPage {
    private static String section = "//h2/a[@href='https://tech.onliner.by']";
    private static String link = "//span[contains(text(), 'Ноутбуки')]";
    private String news = "//a[@href='https://tech.onliner.by/2019/12/18/phone-12']";

    public static OnlinerMainPage getOnlinerMainPage() {
        OnlinerMainPage onMP = new OnlinerMainPage();
        waitForElementVisible(getElementBy(section));
        System.out.println("Onliner page is opened");
        return onMP;
    }

    public OnlinerMainPage navigateToMainPage(){
        openUrl(baseUrl2);
        return getOnlinerMainPage();
    }

    public void clickNewsLink() {
        getElement(news).click();
    }

    public OnlinerMainPage search(){
        getElement(link).click();
        return getOnlinerMainPage();
    }

}
