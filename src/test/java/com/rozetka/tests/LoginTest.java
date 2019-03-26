package com.rozetka.tests;

import models.Account;
import org.testng.annotations.Test;
import pages.LoginPage;

import static core.PageFactory.open;

public class LoginTest {

    @Test
    public void shouldLogIn() {

        final Account account = new Account("test", "test");

        open(LoginPage.class)
                .login(account);
//
//        customAssertThat(at(LoginPage.class))
//                .hasLoginStatus(LOGIN_SUCCESSFUL);
    }
}
