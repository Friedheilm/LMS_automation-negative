package by.bntu.lms.tests.at;

import by.bntu.lms.pages.common.LoginPage;
import by.bntu.lms.tests.TestBase;

public class GroupNegative extends TestBase {

    LoginPage loginPage;
    String ADMIN_LOGIN;
    String ADMIN_PASSWORD;

    public GroupNegative(LoginPage loginPage, String ADMIN_LOGIN, String ADMIN_PASSWORD) {
        this.loginPage = loginPage;
        this.ADMIN_LOGIN = ADMIN_LOGIN;
        this.ADMIN_PASSWORD = ADMIN_PASSWORD;
    }
}
