package pages;

import core.BasePage;
import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.By;

import static core.BaseConfig.BASE_CONFIG;
import static core.PageFactory.at;

public class LoginPage extends BasePage {

    private static final String LOGIN_STATUS = "Authorized successfully";
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By signInButton = By.id("sign_in");
    private final By loginStatusButton = By.name("login_status");

    @Step("Login with account: \"{account}\"")
    public SearchPage login(final Account account) {
        phantomType(usernameInput, account.getUsername());
        phantomType(passwordInput, account.getPassword());
        phantomClick(signInButton);
        return at(SearchPage.class);
    }

    public String getLoginStatus() {
        return getPhantomText(loginStatusButton, LOGIN_STATUS);
    }



    @Override
    public String url() {
        return BASE_CONFIG.url();
    }
}
