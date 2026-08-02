package steps;

import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage();

    public LoginSteps openLoginPage(){
        loginPage.openPage();
        return this;
    }

    public LoginSteps enterUsername(String username){
        loginPage.setUserName(username);
        return this;
    }

    public LoginSteps enterPassword(String password){
        loginPage.setPassword(password);
        return this;
    }

    public LoginSteps submitLogin(){
        loginPage.clickLoginButton();
        return this;
    }

    public LoginSteps login(String username, String password){
        return enterUsername(username).enterPassword(password).submitLogin();
    }
}
