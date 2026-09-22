package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    private SelenideElement title = $(".title");
    private SelenideElement checkoutButton = $("[data-test='checkout']");
    private SelenideElement continueShoppingButton = $("[data-test='continue-shopping']");

    private ElementsCollection quantities = $$("[data-test='item-quantity']");
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
    //Проверка количества
    public CartPage verifyItemsCount(int expectedCount){
        cartItems.shouldHave(size(expectedCount));
        return this;
    }
    //Проверка пустой корзины
    public CartPage verifyCartIsEmpty(){
        cartItems.shouldHave(empty);
        return this;
    }
    //Проверка наличия товара в корзине по имени
    public CartPage verifyItemInCart(String itemName){
        itemNames.findBy(text(itemName)).shouldBe(visible);
        return this;
    }
    //Проверка цены товара в корзине
    public CartPage verifyItemPrice(String itemName, String expectedPrice){
        cartItems.findBy(text(itemName))
                .$("[data-test='inventory-item-price']")
                .shouldHave(text(expectedPrice));
        return this;
    }
    //Проверка количества товара
    public CartPage verifyAllItemsQuantity(int expectedQuantity){
        quantities.shouldHave(texts(String.valueOf(expectedQuantity)));
        return this;
    }
}
