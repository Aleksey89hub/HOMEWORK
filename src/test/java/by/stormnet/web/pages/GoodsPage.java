package by.stormnet.web.pages;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class GoodsPage extends AbstractPage {
    private static String checkElementOnOpeningC = "heading_m ii-product__title";
    private static String description = "ii-product__description-text";
    private static String price = "ii-product__price-several-trigger";
    private static String score = "rev-and-count__wrapper";
    private static String commentX = "//div[contains(@class,'rev__trigger rev__trigger_reviews')]";
    private static String addBtnX = "//button[@class='product__cart-add-button button button_l button_blue']";
    private static String sizeMenu = "//div[contains(@class,'product-sizes-select ii-select__value')]";
    private static String sizeItemsX = "//div[@class='ii-select__column ii-select__column_native']/div[contains(@class, 'ii-select__option') and not(contains(@class, 'disabled'))]";
    public static List<String> tabsList;


    public static GoodsPage getGoodsPage() {
        GoodsPage onGP = new GoodsPage();
        waitForElementVisible(getElementByClass(checkElementOnOpeningC));
        System.out.println("Goods page is opened");
        return onGP;
    }

    public boolean checkDesc() {
        return getElementC(description).isDisplayed();
    }

    public boolean checkPrice() {
        return getElementC(price).isDisplayed();
    }

    public boolean checkScore() {
        return getElementC(score).isDisplayed();
    }

    public boolean checkCom() {
        return getElement(commentX).isDisplayed();
    }

    public boolean checkBtn() {
        return getElement(addBtnX).isDisplayed();
    }

    public void setTabsList() {
        tabsList = getTabs();
    }

    public List<String> getTabsList() {
        return tabsList;
    }

    public GoodsPage navigateToGoodsPage(int num) {
        navigateToTab(num, tabsList);
        return getGoodsPage();
    }

    public void addAllItems(int index) throws InterruptedException {
        Random obj = new Random();
        for (int i = 0; i < tabsList.size(); i++) {
            if (i == index) {
            } else {
                navigateToTab(i, tabsList);
                getElement(sizeMenu).click();
                Thread.sleep(1500);
                List<WebElement> sizeList = getElements(sizeItemsX);
                sizeList.get(obj.nextInt(sizeList.size())).click();
                getElement(addBtnX).click();
            }
        }
    }
}
