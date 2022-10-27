package by.itAcademy.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static by.itAcademy.framework.DriverConfigurator.*;
import static java.time.Duration.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class BasePage {
    public static final int WAIT_TIMEOUT = 5;
    public static final int FIRST_ELEMENT_INDEX = 0;

    protected WebElement waitForElementClickable(By by) {
        Wait<WebDriver> wait = new WebDriverWait(getWebDriver(), ofSeconds(WAIT_TIMEOUT));
        return wait.until(elementToBeClickable(by));
    }

    protected List<WebElement> waitForElementsExist(By by) {
        Wait<WebDriver> wait = new WebDriverWait(getWebDriver(), ofSeconds(WAIT_TIMEOUT));
        return wait.until(presenceOfAllElementsLocatedBy(by));
    }

    public boolean isElementDisplayed(By by) {
        List<WebElement> elements = getWebDriver().findElements(by);
        return !elements.isEmpty() && elements.get(FIRST_ELEMENT_INDEX).isDisplayed();
    }

    public WebElement waitForNestedElementExist(WebElement rootElement, By nestedBy) {
        Wait<WebDriver> wait = new WebDriverWait(getWebDriver(), ofSeconds(WAIT_TIMEOUT));
        return wait.until(presenceOfNestedElementLocatedBy(rootElement, nestedBy));
    }
}
