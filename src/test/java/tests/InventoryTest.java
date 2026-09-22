package tests;

import config.ConfigReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.InventoryPage;
import steps.LoginSteps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class InventoryTest {
    private InventoryPage inventoryPage;

    @BeforeEach
    void login() {
        inventoryPage = new LoginSteps()
                .openLoginPage()
                .loginAndGoToInventory(
                        ConfigReader.getStandardUser(),
                        ConfigReader.getStandardPassword()
                );
        inventoryPage.verifyPageLoaded();
    }

    @Test
    void testItemsCount() {
        inventoryPage.verifyItemsCount(6);
    }

    @Test
    void testItemExists() {
        inventoryPage.verifyItemExists("Sauce Labs Backpack");
    }

    @Test
    void testItemPrice() {
        inventoryPage.verifyItemPrice("Sauce Labs Backpack", "$29.99");
    }

    @Test
    void testSortByNameAtoZ() {
        // Запоминаем список ДО сортировки
        List<String> originalNames = new ArrayList<>(inventoryPage.getCurrentItemNames());

        // Сортируем на странице
        inventoryPage.sortByNameAtoZ();

        // Сортируем в коде
        Collections.sort(originalNames);

        // Сравниваем
        assertThat(inventoryPage.getCurrentItemNames()).isEqualTo(originalNames);
    }

    @Test
    void testSortByNameZtoA() {
        List<String> originalNames = new ArrayList<>(inventoryPage.getCurrentItemNames());
        Collections.sort(originalNames, Collections.reverseOrder());

        inventoryPage.sortByNameZtoA();

        assertThat(inventoryPage.getCurrentItemNames()).isEqualTo(originalNames);
    }

    @Test
    void testSortByPriceLowToHigh() {
        List<String> originalPrices = new ArrayList<>(inventoryPage.getCurrentItemPrices());

        // Преобразуем строки в числа
        List<Double> expectedPrices = new ArrayList<>();
        for (String price : originalPrices) {
            expectedPrices.add(Double.parseDouble(price.replace("$", "")));
        }
        Collections.sort(expectedPrices);

        inventoryPage.sortByPriceLowToHigh();

        List<String> actualPrices = inventoryPage.getCurrentItemPrices();
        List<Double> actualPricesAsNumbers = new ArrayList<>();
        for (String price : actualPrices) {
            actualPricesAsNumbers.add(Double.parseDouble(price.replace("$", "")));
        }

        assertThat(actualPricesAsNumbers).isEqualTo(expectedPrices);
    }
}
