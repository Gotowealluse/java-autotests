package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import steps.LoginSteps;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    @Test
    void loginTest() {

        new LoginSteps().openLoginPage().login("standard_user", "secret_sauce");

        assertTrue(
                url().contains("inventory")
        );
    }
}