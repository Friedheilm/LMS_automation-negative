package by.bntu.lms.pages.admin;

import by.bntu.lms.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@href,'Professors')]")
    private WebElement professorsLink;

    @FindBy(xpath = "//a[contains(@href,'Students')]")
    private WebElement studentsLink;

    @FindBy(xpath = "//a[contains(@href,'Groups')]")
    private WebElement groupsLink;

    @FindBy(xpath = "//a[contains(@href,'Files')]")
    private WebElement filesLink;

    @FindBy(xpath = "//a[contains(@href,'Message')]")
    private WebElement messageLink;

    public ProfessorsPage chooseProfessorsTab() {
        waitForElementIsClickableAndClick(professorsLink);
        return new ProfessorsPage(driver);
    }

    public GroupsPage chooseGroupsTab() {
        waitForElementIsClickableAndClick(groupsLink);
        return new GroupsPage(driver);
    }

    public StudentsPage chooseStudentsTab() {
        waitForElementIsClickableAndClick(studentsLink);
        return new StudentsPage(driver);
    }

}
