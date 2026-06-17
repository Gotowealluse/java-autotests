package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    @Test
    void loginTest() {

        LoginPage loginPage = new LoginPage();

        loginPage
                .openPage()
                .login(
                        "standard_user",
                        "secret_sauce"
                );

        assertTrue(
                url().contains("inventory")
        );
    }
}