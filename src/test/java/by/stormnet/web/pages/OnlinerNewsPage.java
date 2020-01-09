package by.stormnet.web.pages;

public class OnlinerNewsPage extends AbstractPage {
    public static String newsPage = "//div[@class='news-header__author news-helpers_hide_mobile']";

    public static OnlinerNewsPage getOnlinerNewsPage() {
        OnlinerNewsPage onNP = new OnlinerNewsPage();
        waitForElementVisible(getElementBy(newsPage));
        System.out.println("News page is opened");
        return onNP;
    }

    public boolean newsPageIsDisplayed() {
        return getOnlinerNewsPage().getElement(newsPage).isDisplayed();
    }
}
