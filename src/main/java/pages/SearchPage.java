package pages;

import core.BasePage;
import core.UiCondition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static core.BaseConfig.BASE_CONFIG;
import static core.PageFactory.at;

public class SearchPage extends BasePage {

    private final By inputSearch = By.id("twotabsearchtextbox");

    @Step("Search for \"{text}\".")
    public ProductPage searchFor(final String text) {
        type(inputSearch, text + Keys.ENTER, UiCondition.enabled);
        return at(ProductPage.class);
    }

    @Override
    public String url() {
        return BASE_CONFIG.url();
    }
}
