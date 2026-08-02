package pages;

import com.codeborne.selenide.SelenideElement;
import config.ConfigReader;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class LoginPage {

    private SelenideElement
            username = $("#user-name"),
            password = $("#password"),
            loginButton = $("#login-button");

    public LoginPage openPage() {
        open(ConfigReader.getBaseUrl());
        return this;
    }

    public LoginPage setUserName (String user){
        username.setValue(user);
        return this;
    }

    public LoginPage setPassword (String pass){
        password.setValue(pass);
        return this;
    }

    public LoginPage clickLoginButton(){
        loginButton.click();
        return this;
    }

    public LoginPage login(String user, String pass) {

        username.setValue(user);
        password.setValue(pass);
        loginButton.click();

        return this;
    }
}