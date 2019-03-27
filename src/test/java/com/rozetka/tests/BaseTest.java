package com.rozetka.tests;

import core.BasePage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
    }

    @AfterSuite
    public void tearDown() {
        if (BasePage.getDriver() != null) {
            BasePage.getDriver().quit();
        }
    }
}
