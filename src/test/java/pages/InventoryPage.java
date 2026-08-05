package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class InventoryPage {
    //Элементы страницы
    private SelenideElement title = $(".title");
    private SelenideElement shoppingCart = $("[data-test='shopping-cart-link']");
    private SelenideElement sortDropdown = $("[data-test='product-sort-container']");

    //Коллекции элементов
    private ElementsCollection inventoryItems = $$("[data-test='inventory-list']");
    private ElementsCollection itemNames = $$("[data-test='inventory-item-name']");
    private ElementsCollection itemPrices = $$("[data-test='inventory-item-price']");
    private ElementsCollection addToCartButtons = $$("[data-test^='add-to-cart']");

    //Проверки
    //Загрузка страницы товаров
    public InventoryPage verifyPageLoaded(){
        title.shouldHave(text("Products"));
        return this;
    }
    //Проверка количества товаров
    public InventoryPage verifyItemsCount(int expectedCount){
        inventoryItems.shouldHave(size(expectedCount));
        return this;
    }
    //Проверка существования товара
    public InventoryPage verifyItemExists(String itemName){
        itemNames.findBy(text(itemName)).shouldBe(visible);
        return this;
    }
    //Проверка цены товара
    public InventoryPage verifyItemPrice(String itemName, String expectedPrice){
        inventoryItems.findBy(text(itemName))
                .$("[data-test='inventory-item-price']")
                .shouldHave(text(expectedPrice));
        return this;
    }

    //Действия
    //Добавление в корзину
    public InventoryPage addItemToCart(String itemName){
        inventoryItems.findBy(text(itemName))
                .$("[data-test^='add-to-cart']")
                .click();
        return this;
    }
    //Сортировка дефолтная
    public InventoryPage sortBy(String option){
        sortDropdown.selectOption(option);
        return this;
    }
    //Сортировка по алфавиту
}
