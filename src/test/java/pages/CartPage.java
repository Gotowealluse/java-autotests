package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    private SelenideElement title = $(".title");
    private SelenideElement checkoutButton = $("[data-test='checkout']");
    private SelenideElement continueShoppingButton = $("[data-test='continue-shopping']");

    private ElementsCollection quantity = $$("[data-test='item-quantity']");
    private ElementsCollection cartItems = $$("[data-test='inventory-item']");
    private ElementsCollection itemNames = $$("[data-test='inventory-item-name']");
    private ElementsCollection itemsPrices = $$("[data-test='inventory-item-price']");
    private ElementsCollection removeButton = $$("[data-test^='remove']");

    //Проверки
    //Проверка загрузки страницы
    public CartPage verifyPageLoaded(){
        title.shouldHave(text("Your Cart"));
        return this;
    }



}
