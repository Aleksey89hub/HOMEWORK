package by.stormnet.web.pages;

public class LoginPage extends AbstractPage {
    private static String usernameField = "//input[@id = 'mailbox:login']";
    private String enterPasswordBtn = "//label[@id = 'mailbox:submit']/input";
    private String passwordField = "//input[@id = 'mailbox:password']";
    private String createEmailBtn = "//span[@class = 'compose-button__txt']";

    public static LoginPage getLoginPage() {
        LoginPage loginPage = new LoginPage();
        waitForElementVisible(getElementBy(usernameField));
        System.out.println("Login page is opened");
        return loginPage;
    }
    public LoginPage navigateToLoginPage(){
        openUrl(baseUrl);
        return getLoginPage();
    }

    public LoginPage fillUsernameField (String username){
        getElement(usernameField).sendKeys(username);
        return getLoginPage();
    }
    public LoginPage clickEnterPasswordBtn(){
        getElement(enterPasswordBtn).click();
        return getLoginPage();
    }
    public LoginPage fillPasswordField(String password){
        waitForElementClickable(getElementBy(passwordField));
        getElement(passwordField).sendKeys(password);
        return getLoginPage();
    }
    public boolean isWriteLetterBtnDisplayed(){
        waitForElementClickable(getElementBy(createEmailBtn));
        return getElement(createEmailBtn).isDisplayed();
    }
}
