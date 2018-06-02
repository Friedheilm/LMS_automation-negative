package by.bntu.lms.pages.admin;

import by.bntu.lms.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.UnsupportedEncodingException;

public class GroupsPage extends AbstractPage {

    public GroupsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-bb-handler='confirm']")
    private WebElement confirmButton;

    @FindBy(xpath = "//*[contains(@href,'AddGroup')]")
    private WebElement addGroupButton;

    @FindBy(id = "Name")
    private WebElement groupNameField;

    @FindBy(id = "StartYear")
    private WebElement listYearsOfGroupEntering;

    @FindBy(id = "GraduationYear")
    private WebElement listYearsOfGroupGraduation;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[contains(@href,'ListOfStudents')]")
    private WebElement listOFStudentsLink;

    @FindBy(xpath = "//a[@class='bootbox-close-button close']")
    private WebElement closeButton;

    @FindBy(xpath = "//*[@id=\"form0\"]/div[1]/div/ul/li")
    private WebElement ErrorMessage;

    private WebElement removeGroupWithStudentsButton;

    private WebElement removeEmptyGroupButton;

    private WebElement editGroupButton;

    WebElement notification;

    private WebElement initNotification(String notificationMessage) {
        return driver.findElement(new By.ByXPath("//section[@id='alertify-logs']/" +
                "article[contains(text(),'" + notificationMessage + "')]"));
    }

    private WebElement initWebElement(String xpath) {
        return driver.findElement(new By.ByXPath(xpath));
    }

    public GroupsPage addGroup(String groupNumber, String enteringYear, String graduatingYear)
            throws InterruptedException, UnsupportedEncodingException {
        wait.waitForPageToLoad();
        waitForElementIsClickableAndClick(addGroupButton);
        sendKeysIntoWebElement(groupNameField, groupNumber);
        Select enteringYearBox = new Select(listYearsOfGroupEntering);
        Select graduatingYearBox = new Select(listYearsOfGroupGraduation);
        enteringYearBox.selectByVisibleText(enteringYear);
        graduatingYearBox.selectByVisibleText(graduatingYear);
        waitForElementIsClickableAndClick(submitButton);

        notification = initNotification("Группа сохранена");
        wait.waitForElementIsVisible(notification);

        return GroupsPage.this;
    }

    // Negative case.
    public GroupsPage addGroupFail(String groupNumber, String enteringYear, String graduatingYear, String errorMessage)
            throws InterruptedException, UnsupportedEncodingException {
        wait.waitForPageToLoad();
        waitForElementIsClickableAndClick(addGroupButton);
        sendKeysIntoWebElement(groupNameField, groupNumber);
        Select enteringYearBox = new Select(listYearsOfGroupEntering);
        Select graduatingYearBox = new Select(listYearsOfGroupGraduation);
        enteringYearBox.selectByVisibleText(enteringYear);
        graduatingYearBox.selectByVisibleText(graduatingYear);
        waitForElementIsClickableAndClick(submitButton);
        wait.waitForElementIsVisible(ErrorMessage);

        return GroupsPage.this;
    }

    // Negative case.
    public GroupsPage changeGroupInformationFail(String groupNumb, String changedGroupNumber, String changedEnteringYear,
                                             String changedGraduationYear, String errorMessage) {
        wait.waitForPageToLoad();
        editGroupButton = initWebElement("//tr/td[text()='" +
                groupNumb + "']" + "/../td[@class='']/div/a[contains(@href,'EditGroup')]");
        waitForElementIsClickableAndClick(editGroupButton);
        sendKeysIntoWebElement(groupNameField, changedGroupNumber);
        Select enteringYearBox = new Select(listYearsOfGroupEntering);
        Select graduatingYearBox = new Select(listYearsOfGroupGraduation);
        enteringYearBox.selectByVisibleText(changedEnteringYear);
        graduatingYearBox.selectByVisibleText(changedGraduationYear);
        waitForElementIsClickableAndClick(submitButton);
        wait.waitForElementIsVisible(ErrorMessage);
        return GroupsPage.this;
    }

    public GroupsPage changeGroupInformation(String groupNumb, String changedGroupNumber, String changedEnteringYear,
                                             String changedGraduationYear) {
        wait.waitForPageToLoad();
        editGroupButton = initWebElement("//tr/td[text()='" +
                groupNumb + "']" + "/../td[@class='']/div/a[contains(@href,'EditGroup')]");
        waitForElementIsClickableAndClick(editGroupButton);
        sendKeysIntoWebElement(groupNameField, changedGroupNumber);
        Select enteringYearBox = new Select(listYearsOfGroupEntering);
        Select graduatingYearBox = new Select(listYearsOfGroupGraduation);
        enteringYearBox.selectByVisibleText(changedEnteringYear);
        graduatingYearBox.selectByVisibleText(changedGraduationYear);
        waitForElementIsClickableAndClick(submitButton);
        return GroupsPage.this;
    }

    public GroupsPage removeEmptyGroup(String emptyGroupNumb) {
        wait.waitForPageToLoad();
        removeEmptyGroupButton = initWebElement("//tr/td[text()='" + emptyGroupNumb
                + "']/../td[@class='']/div/a[contains(@href,'DeleteGroup')]");
        waitForElementIsClickableAndClick(removeEmptyGroupButton);
        waitForElementIsClickableAndClick(confirmButton);
        notification = initNotification("Группа удалена");
        wait.waitForElementIsVisible(notification);
        return GroupsPage.this;
    }

    public GroupsPage removeGroupWithStudents(String groupWithStudentsNumber) {
        wait.waitForPageToLoad();
        removeGroupWithStudentsButton = initWebElement("//tr/td[5][not(contains(text(),'0'))]/../" +
                "td[@class='']/div/a[contains(@href,'DeleteGroup')]");
        waitForElementIsClickableAndClick(removeGroupWithStudentsButton);
        waitForElementIsClickableAndClick(confirmButton);
        notification = initNotification("Группа содержит студентов и не может быть удалена");
        wait.waitForElementIsVisible(notification);
        return GroupsPage.this;
    }

}
