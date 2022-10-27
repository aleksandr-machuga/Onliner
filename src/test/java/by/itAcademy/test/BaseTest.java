package by.itAcademy.test;

import by.itAcademy.framework.DriverConfigurator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;

    @BeforeAll
    public void setUpDriver() {
        DriverConfigurator.setWebDriver();
        driver = DriverConfigurator.getWebDriver();
    }

    @AfterAll
    public void closeDriver() {
        DriverConfigurator.closeDriver();
    }

}
