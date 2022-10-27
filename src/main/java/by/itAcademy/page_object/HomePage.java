package by.itAcademy.page_object;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {
    private static final String NAVIGATION_LINK_XPATH_PATTERN =
            "//a[@class='b-main-navigation__link']//span[contains(text(),'%s')]";

    private void clickNavigationLink() {
        waitForElementClickable(xpath(String.format(NAVIGATION_LINK_XPATH_PATTERN, "Каталог"))).click();
    }

    public CatalogPage clickCatalogLink() {
        clickNavigationLink();
        return new CatalogPage();
    }
}
