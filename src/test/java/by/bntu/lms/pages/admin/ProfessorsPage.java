package by.bntu.lms.pages.admin;


import by.bntu.lms.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfessorsPage extends AbstractPage {

    protected ProfessorsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='statButton']")
    private WebElement statButton;

    @FindBy(xpath = "//a[@class='listButton']")
    private WebElement listButton;

    private WebElement editProfessorsButton;

    @FindBy(xpath = "//a[@class='deleteButton']")
    private WebElement deleteButton;

    private WebElement deleteProfessorButton;

    @FindBy(xpath = "//a[@class='addButton btn btn-primary btn-sm']")
    private WebElement addProfessorButton;

    @FindBy(id = "UserName")
    private WebElement userNameField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "Name")
    private WebElement nameField;

    @FindBy(id = "Surname")
    private WebElement surnameField;

    @FindBy(id = "Patronymic")
    private WebElement patronymicField;

    @FindBy(name = "IsSecretary")
    private WebElement secretaryBox;

    @FindBy(id = "IsLecturerHasGraduateStudents")
    private WebElement lecturerHasGraduateStudentsBox;

    @FindBy(xpath = "//td[@class = 'TestUser']/../td[3]")
    private WebElement lastEnter;

    @FindBy(xpath = "//td[@class = 'TestUser']/../td[4]")
    private WebElement countOfSubjects;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@class='modal-header panel-heading']")
    private WebElement modalDialog;

    @FindBy(xpath = "//a[@class='bootbox-close-button close']")
    private WebElement closeButton;

    @FindBy(id = "professorsList_filter_input")
    private WebElement searchField;

    @FindBy(xpath = "//*[@data-bb-handler='confirm']")
    private WebElement confirmButton;

    @FindBy(xpath = "//tr[@class='odd']/td[2]")
    private WebElement firstProfessorName;

    @FindBy(xpath = "//*[@id=\"form0\"]/div[1]/div/ul/li")
    private WebElement ErrorMessage;

    @FindBy(xpath = "//article[contains(@class,'success')]")
    WebElement successfulNotification;

    private WebElement professorForSearch;

    WebElement notification;

    private WebElement initNotification(String notificationMessage) {
        return driver.findElement(new By.ByXPath("//section[@id='alertify-logs']/" +
                "article[contains(text(),'" + notificationMessage + "')]"));
    }

    private WebElement initWebElement(String xpath) {
        return driver.findElement(new By.ByXPath(xpath));
    }

    public ProfessorsPage addProfessor(String userName, String password,
                                       String surname, String name,
                                       String patronymic) {
        wait.waitForPageToLoad();
        waitForElementIsClickableAndClick(addProfessorButton);
        sendKeysIntoWebElement(userNameField, userName);
        sendKeysIntoWebElement(passwordField, password);
        sendKeysIntoWebElement(confirmPasswordField, password);
        sendKeysIntoWebElement(surnameField, surname);
        sendKeysIntoWebElement(nameField, name);
        sendKeysIntoWebElement(patronymicField, patronymic);
        waitForElementIsClickableAndClick(secretaryBox);
        waitForElementIsClickableAndClick(lecturerHasGraduateStudentsBox);
        waitForElementIsClickableAndClick(submitButton);

        notification = initNotification("Преподаватель сохранен");
        wait.waitForElementIsVisible(notification);

        return ProfessorsPage.this;
    }

    public ProfessorsPage addProfessorFail(String userName, String password,
                                       String surname, String name,
                                       String patronymic, String errorMessage) {
        wait.waitForPageToLoad();
        waitForElementIsClickableAndClick(addProfessorButton);
        sendKeysIntoWebElement(userNameField, userName);
        sendKeysIntoWebElement(passwordField, password);
        sendKeysIntoWebElement(confirmPasswordField, password);
        sendKeysIntoWebElement(surnameField, surname);
        sendKeysIntoWebElement(nameField, name);
        sendKeysIntoWebElement(patronymicField, patronymic);
        waitForElementIsClickableAndClick(secretaryBox);
        waitForElementIsClickableAndClick(lecturerHasGraduateStudentsBox);
        waitForElementIsClickableAndClick(submitButton);

        wait.waitForElementIsVisible(ErrorMessage);

        return ProfessorsPage.this;
    }


//    public void checkErrorAfterAdding() {
//        wait.waitForPageToLoad();
//        WebElement error = initWebElement("//div[@class='validation-summary-errors" +
//                " alert alert-error']");
//        wait.waitForElementIsInvisible(error);
//    }

    public ProfessorsPage removeProfessor(String login) {
        wait.waitForPageToLoad();
        deleteProfessorButton = initWebElement("//tr/td[text()='" +
                login + "']" + "/../td[@class='']/div/a[contains(@href,'DeleteLecturer')]");
        waitForElementIsClickableAndClick(deleteProfessorButton);
        waitForElementIsClickableAndClick(confirmButton);
        wait.waitForPageToLoad();
        wait.waitForElementIsVisible(successfulNotification);
        return ProfessorsPage.this;
    }

    public ProfessorsPage changeProfessorInformationFail(String login, String changedName, String changedSurname,
                                                     String changedPatronymic, String errorMessage) {
        wait.waitForPageToLoad();
        editProfessorsButton = initWebElement("//tr/td[text()='" +
                login + "']" + "/../td[@class='']/div/a[contains(@href,'EditProfessor')]");
        waitForElementIsClickableAndClick(editProfessorsButton);
        sendKeysIntoWebElement(nameField, changedName);
        sendKeysIntoWebElement(surnameField, changedSurname);
        sendKeysIntoWebElement(patronymicField, changedPatronymic);
        waitForElementIsClickableAndClick(submitButton);

        wait.waitForElementIsVisible(ErrorMessage);

        return ProfessorsPage.this;
    }

    public ProfessorsPage changeProfessorInformation(String login, String changedName, String changedSurname,
                                                     String changedPatronymic) {
        wait.waitForPageToLoad();
        editProfessorsButton = initWebElement("//tr/td[text()='" +
                login + "']" + "/../td[@class='']/div/a[contains(@href,'EditProfessor')]");
        waitForElementIsClickableAndClick(editProfessorsButton);
        sendKeysIntoWebElement(nameField, changedName);
        sendKeysIntoWebElement(surnameField, changedSurname);
        sendKeysIntoWebElement(patronymicField, changedPatronymic);
        waitForElementIsClickableAndClick(submitButton);
        notification = initNotification("Преподаватель сохранен");
        wait.waitForElementIsVisible(notification);
        return ProfessorsPage.this;
    }

    //TODO:Check this method
    public ProfessorsPage searchProfessor(String surname) {
        wait.waitForPageToLoad();
        sendKeysIntoWebElement(searchField, surname);
        //wait.waitForElementIsVisible(driver.findElement(By.xpath("//td[contains(text(),'" + surname + "')]")));
        return ProfessorsPage.this;
    }

    public void checkProfessorInSearchResults(String surname) {
        wait.waitForPageToLoad();
        professorForSearch = initWebElement("//td[contains(text(),'" + surname + "')]");
        wait.waitForElementIsVisible(professorForSearch);
    }

}
