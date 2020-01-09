package by.stormnet.web.pages;

public class OnlinerGoodsPage extends AbstractPage {
    private static String pageCheck = "//h1[@class='catalog-masthead__title']";
    private static String producerCheck = "//tbody[2]/tr[3]/td[2]/span[contains(text(),'ASUS')]";
    private static String yearCheck = "//tbody[2]/tr[2]/td[2]/span[contains(text(),'2018')]";
    private static String purposeCheck = "//tbody[2]/tr[5]/td[2]/span[contains(text(),'для работы')]";
    private static String resolutionCheck = "//tbody[6]/tr[2]/td[2]/span[contains(text(), '15')]";
    private static String memoryCheck = "//tbody[7]/tr[4]/td[2]/span";

    public static OnlinerGoodsPage getOnlinerGoodsPage() {
        OnlinerGoodsPage onGP = new OnlinerGoodsPage();
        waitForElementVisible(getElementBy(pageCheck));
        System.out.println("Goods page is opened");
        return onGP;
    }

    public boolean checkForProducerFilter() {
        return getElement(producerCheck).isDisplayed();
    }

    public boolean checkForYearFilter() {
        if (getElement(yearCheck).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkForPurposeFilter() {
        return getElement(purposeCheck).isDisplayed();
    }

    public boolean checkForResolutionFilter() {
        if (getElement(resolutionCheck).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkForMemoryFilter() {
        int a = getResultsNumber(memoryCheck);
        if (a >= 16 && a <= 24) {
            return true;
        } else {
            return false;
        }
    }

}
