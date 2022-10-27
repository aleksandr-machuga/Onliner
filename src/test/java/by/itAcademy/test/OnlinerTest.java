package by.itAcademy.test;

import by.itAcademy.page_object.CatalogPage;
import by.itAcademy.page_object.HomePage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class OnlinerTest extends BaseTest {
    private static final String ONLINER_URL = "https://www.onliner.by/";
    public static final String COMPUTERS = "Компьютеры и";
    private static final List<String> CATALOG_OPTIONS = Arrays.asList("Prime", "Электроника", COMPUTERS,
            "Бытовая техника", "Дом и", "Стройка и", "Авто и", "Красота и", "Детям и", "Работа и");
    public static final String ACCESSORIES = "Комплектующие";
    private static final List<String> MENU_OPTIONS = Arrays.asList
            (" Ноутбуки, компьютеры, мониторы ", ACCESSORIES, "Хранение данных", "Сетевое оборудование");
    private HomePage homePage;

    @BeforeEach
    public void startBrowser() {
        driver.get(ONLINER_URL);
        homePage = new HomePage();
    }

    @Test
    public void testCatalogSectionsPresence() {
        CatalogPage catalogPage = homePage.clickCatalogLink();
        CATALOG_OPTIONS.forEach(option ->
                Assertions.assertThat(catalogPage.isCatalogSectionVisible(option))
                        .as("Catalog section " + option + " not found")
                        .isTrue());
    }

    @Test
    public void testComputersMenu() {
        CatalogPage catalogPage = homePage.clickCatalogLink()
                .clickCatalogSection(COMPUTERS);
        Assertions.assertThat(catalogPage.isSectionMenuVisible())
                .as("Section menu is not displayed")
                .isTrue();
        MENU_OPTIONS.forEach(option ->
                Assertions.assertThat(catalogPage.isSectionMenuOptionVisible(option))
                        .as("Menu option " + option + " not found")
                        .isTrue());
    }

    @Test
    public void testAccessoriesElementsContent() {
        CatalogPage catalogPage = homePage.clickCatalogLink()
                .clickCatalogSection(COMPUTERS)
                .clickMenuOption(ACCESSORIES);
        catalogPage.getMenuOptionElements().forEach(element -> {
            Assertions.assertThat(catalogPage.isElementTitleDisplayed(element))
                    .as("Title is not displayed")
                    .isTrue();
            Assertions.assertThat(catalogPage.getElementDescription(element))
                    .as("Number is not displayed")
                    .matches(description -> description.contains("товар"));
            Assertions.assertThat(catalogPage.getElementDescription(element))
                    .as("Price is not displayed")
                    .matches(description -> description.contains("р."));
        });
    }
}
