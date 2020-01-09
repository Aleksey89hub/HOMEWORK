package by.stormnet.web.helpers;

import by.stormnet.web.pages.LoginPage;

public class LoginHelper extends AbsractHelper {
    LoginPage loginPage = new LoginPage();
    public LoginHelper openLoginPage(){
        System.out.println("Navigate to login page ...");
        loginPage.navigateToLoginPage();
        return this;
    }
    public LoginHelper login(String username, String password){
        System.out.println("Login to email using " + username + " and password " + password);
        loginPage.fillUsernameField(username)
                .clickEnterPasswordBtn()
                .fillPasswordField(password)
                .clickEnterPasswordBtn();
        return this;
    }
    public boolean checkPageWithEmailsOpened(){
        return loginPage.isWriteLetterBtnDisplayed();
    }
}
