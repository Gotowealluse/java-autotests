package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class LoginPage {

    private SelenideElement
            username = $("#user-name"),
            password = $("#password"),
            loginButton = $("#login-button");

    public LoginPage openPage() {

        open("https://www.saucedemo.com/");

        return this;
    }

    public LoginPage login(String user, String pass) {

        username.setValue(user);
        password.setValue(pass);
        loginButton.click();

        return this;
    }
}