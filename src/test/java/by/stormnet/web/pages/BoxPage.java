package by.stormnet.web.pages;

public class BoxPage extends AbstractPage {
    private static String checkElementOnOpeningC = "checkout-header__title";
    private static String boxContains = "//div[@class='checkout-price-header__title']";
    private static String phone = "//input[@id='id_phone']";
    private static String location = "//input[@id='id_city_name']";
    private static String email = "//input[@id='id_email']";
    private static String comment = "//textarea[@id='id_customer_notes']";
    private static String promocode = "//input[@id='id_coupon_code']";
    private static String totalPrice = "//div[@class='detalization-item detalization-item_subtotal']";
    private static String payWay = "//div[@class='package-block package-block_payment-methods']";
    private static String payBtn = "//button[@class='checkout__button checkout__button_lead']";

    public static BoxPage getBoxPage() {
        BoxPage onGP = new BoxPage();
        waitForElementVisible(getElementByClass(checkElementOnOpeningC));
        System.out.println("Box page is opened");
        return onGP;
    }

    public int resultsNumber() {
        waitForElementVisible(getElementBy(boxContains));
        return getResultsNumber(boxContains);
    }

    public boolean checkPhone() {
        return getElement(phone).isDisplayed();
    }

    public boolean checkLocation() {
        return getElement(location).isDisplayed();
    }

    public boolean checkEmail() {
        return getElement(email).isDisplayed();
    }

    public boolean checkComment() {
        return getElement(comment).isDisplayed();
    }

    public boolean checkArea() {
        return (getElement(promocode).isDisplayed()
                && getElement(totalPrice).isDisplayed()
                && getElement(payWay).isDisplayed()
                && getElement(payBtn).isDisplayed());
    }
}
