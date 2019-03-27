package com.rozetka.tests;

import models.Account;
import models.OperationStatus;
import org.testng.annotations.Test;
import pages.LoginPage;

import static core.PageFactory.at;
import static core.PageFactory.open;
import static models.OperationStatus.LOGIN_SUCCESSFUL;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void shouldLogIn() {
        final Account account = new Account("test", "test");

        open(LoginPage.class)
                .login(account);

        assertThat(at(LoginPage.class).getLoginStatus())
                .isEqualTo(LOGIN_SUCCESSFUL.getName());
    }
}
