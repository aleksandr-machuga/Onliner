package by.itAcademy.page_object;

import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.*;

public class CatalogPage extends BasePage {
    private static final String CATALOG_ITEM_XPATH_PATTERN = "//span[contains(text(), '%s')]";
    private static final String ASIDE_MENU_ITEM_XPATH_PATTERN =
            "//div[@style='display: block;']//div[contains(text(), '%s')]";
    private static final String ASIDE_MENU_CSS = "div.catalog-navigation-list__category[style='display: block;']";
    private static final String SECTION_OPTION_CSS =
            "div[class*='aside-item_active'] a.catalog-navigation-list__dropdown-item";
    private static final String SECTION_OPTION_TITLE_CSS = "span.catalog-navigation-list__dropdown-title";
    private static final String SECTION_OPTION_DESCRIPTION_XPATH =
            ".//span[@class='catalog-navigation-list__dropdown-description']";

    public boolean isCatalogSectionVisible(String option) {
        return isElementDisplayed(xpath(format(CATALOG_ITEM_XPATH_PATTERN, option)));
    }

    public CatalogPage clickCatalogSection(String sectionName) {
        waitForElementClickable(xpath(format(CATALOG_ITEM_XPATH_PATTERN, sectionName))).click();
        return this;
    }

    public boolean isSectionMenuVisible() {
        return isElementDisplayed(cssSelector(ASIDE_MENU_CSS));
    }

    public boolean isSectionMenuOptionVisible(String option) {
        return isElementDisplayed(xpath(format(ASIDE_MENU_ITEM_XPATH_PATTERN, option)));
    }

    public CatalogPage clickMenuOption(String optionName) {
        waitForElementClickable(xpath(format(ASIDE_MENU_ITEM_XPATH_PATTERN, optionName))).click();
        return this;
    }

    public List<WebElement> getMenuOptionElements() {
        return waitForElementsExist(cssSelector(SECTION_OPTION_CSS));
    }

    public boolean isElementTitleDisplayed(WebElement element) {
        return waitForNestedElementExist(element, cssSelector(SECTION_OPTION_TITLE_CSS)).isDisplayed();
    }

    public String getElementDescription(WebElement element) {
        return waitForNestedElementExist(element, xpath(SECTION_OPTION_DESCRIPTION_XPATH)).getText();
    }
}
