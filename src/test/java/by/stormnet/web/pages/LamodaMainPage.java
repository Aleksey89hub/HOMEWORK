package by.stormnet.web.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class LamodaMainPage extends AbstractPage {
    private static String searchField = "//input[contains(@class, 'text-field text-field_large search__input js-search-field')]";
    private static String checkElementOnOpeningClass = "tizer-gender-select";
    private static String searchResultCheckX = "//span[@class='products-catalog__head-counter']";
    private static String goodsItem = "//a[@class='products-list-item__link link']";
    private static String backButtonX = "//span[@class='button button_outline button_outline-black paginator__prev' and not(@style)]";
    private static String pageButtonX = "//a[contains(@class, 'button button_outline button_outline-black paginator__num')]";
    private static String boxBtn = "//a[contains(@class, 'user-nav__link_cart')]";
    private static String initHendler;

    public static LamodaMainPage getLamodaMainPage() {
        LamodaMainPage onLM = new LamodaMainPage();
        waitForElementVisible(getElementByClass(checkElementOnOpeningClass));
        System.out.println("Lamoda is opened");
        return onLM;
    }

    public LamodaMainPage navigateToMainPage() {
        openUrl(baseUrl3);
        return getLamodaMainPage();
    }

    public LamodaMainPage searchBy(String data) {
        WebElement search = getElement(searchField);
        search.sendKeys(data + "\n");
        waitForElementVisible(getElementBy(searchResultCheckX));
        return getLamodaMainPage();
    }

    public int resultsNumber() {
        return getResultsNumber(searchResultCheckX);
    }

    public boolean openNextPage() throws InterruptedException {
        List<WebElement> buttons = getElements(pageButtonX);
        int num = Math.round(buttons.size()/2);
        WebElement forClick = buttons.get(num);
        forClick.click();
        Thread.sleep(1000);
        return getElement(backButtonX).isDisplayed();
    }

    public void openGoods() throws InterruptedException {
        Random obj = new Random();
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        List<WebElement> goodsList = getElements(goodsItem);
        WebElement[] massForOpen = new WebElement[5];
        for (int i=0; i<5; i++){
            int num = obj.nextInt(goodsList.size()-1);
            massForOpen[i] = goodsList.get(num);
        }
        for (WebElement a : massForOpen) {
            a.sendKeys(selectLinkOpeninNewTab);
            Thread.sleep(1000);
        }
    }

    public void openBox() throws InterruptedException {
        waitForElementVisible(getElementBy(boxBtn));
        Thread.sleep(1000);
        getElement(boxBtn).click();
    }

    public void setInitHendler(){
        initHendler = getTabs().get(0);
    }

    public String getInitHendler(){return initHendler;}
}
