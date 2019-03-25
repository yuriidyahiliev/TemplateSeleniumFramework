package core;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static core.utils.ElementTypeUtils.elementOf;
import static io.github.sskorol.listeners.BaseListener.getDriverMetaData;

public abstract class BasePage implements Page {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage() {
        this.driver = getDriverMetaData()._1;
        this.wait = getDriverMetaData()._2;
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

    @SuppressWarnings("unchecked")
    private <T, V, R> R waitFor(final T arg1, final V arg2, final UiCondition condition) {
        return (R) wait.ignoring(StaleElementReferenceException.class)
                .until((Function<WebDriver, ?>) condition.getType().apply(arg1, arg2));
    }
}
