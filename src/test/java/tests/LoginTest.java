package tests;

import config.ConfigReader;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import steps.LoginSteps;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    @Test
    void loginTest() {

        new LoginSteps()
                .openLoginPage()
                .login(ConfigReader.getStandardUser(), ConfigReader.getStandardPassword());

        assertTrue(
                url().contains("inventory")
        );
    }
}