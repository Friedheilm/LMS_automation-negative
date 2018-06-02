package by.bntu.lms.pages.student;

import by.bntu.lms.pages.AbstractPage;
import by.bntu.lms.pages.admin.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends AbstractPage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "UserName")
    private WebElement loginField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(id = "UserName")
    private WebElement userNameField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "Name")
    private WebElement nameField;

    @FindBy(id = "Surname")
    private WebElement surnameField;

    @FindBy(id = "Patronymic")
    private WebElement patronymicField;

    @FindBy(id = "Group")
    private WebElement listGroups;

    public MainPage registerStudent(String login, String password, String name,
                                    String surname, String patronymic,String groupNumber) {
        wait.waitForPageToLoad();
        sendKeysIntoWebElement(loginField, login);
        sendKeysIntoWebElement(passwordField, password);
        sendKeysIntoWebElement(confirmPasswordField, password);
        sendKeysIntoWebElement(confirmPasswordField, password);
        sendKeysIntoWebElement(surnameField, surname);
        sendKeysIntoWebElement(nameField, name);
        sendKeysIntoWebElement(patronymicField, patronymic);
        sendKeysIntoWebElement(patronymicField, patronymic);
        Select groups = new Select(listGroups);
        groups.selectByVisibleText(groupNumber);
        waitForElementIsClickableAndClick(submitButton);

        return new MainPage(driver);
    }
}
