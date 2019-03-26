package core;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static core.utils.ElementTypeUtils.elementOf;
import static io.github.sskorol.listeners.BaseListener.getDriverMetaData;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

public abstract class BasePage implements Page {

    private final WebDriver driver;
    private final WebDriver mockDriver;
    private final WebDriverWait wait;
    private final WebElement mockElement;

    public BasePage() {
        this.driver = getDriverMetaData()._1;
        this.wait = getDriverMetaData()._2;
        this.mockDriver = mock(WebDriver.class);
        this.mockElement = mock(WebElement.class);
    }

    @Step("Navigate to \"{url}\"")
    public Page navigateTo(final String url) {
        driver.get(url);
        return this;
    }

    protected void click(final By locator) {
        click(locator, UiCondition.visible);
    }

    protected void click(final By locator, final UiCondition condition) {
        elementOf(waitFor(locator, "", condition)).click();
    }

    protected void phantomClick(final By locator) {
        when(mockDriver.findElement(locator)).thenReturn(mockElement);
        mockDriver.findElement(locator).click();
    }

    protected void type(final By locator, final CharSequence text, final UiCondition condition) {
        elementOf(waitFor(locator, "", condition)).sendKeys(text);
    }

    protected void phantomType(final By locator, final CharSequence text) {
        when(mockDriver.findElement(locator)).thenReturn(mockElement);
        mockDriver.findElement(locator).sendKeys(text);
    }

    protected String getPhantomText(final By locator, final String value) {
        when(mockElement.getText()).thenReturn(value);
        when(mockDriver.findElement(locator)).thenReturn(mockElement);
        return mockDriver.findElement(locator).getText();
    }

    @SuppressWarnings("unchecked")
    private <T, V, R> R waitFor(final T arg1, final V arg2, final UiCondition condition) {
        return (R) wait.ignoring(StaleElementReferenceException.class)
                .until((Function<WebDriver, ?>) condition.getType().apply(arg1, arg2));
    }
}
