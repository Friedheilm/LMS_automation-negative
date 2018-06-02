package by.bntu.lms.tests.smoke.group;

import by.bntu.lms.data.DataReader;
import by.bntu.lms.data.TestData;
import by.bntu.lms.pages.common.LoginPage;
import by.bntu.lms.tests.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GroupFeature extends TestBase {

    LoginPage loginPage;
    String ADMIN_LOGIN;
    String ADMIN_PASSWORD;

    public GroupFeature(LoginPage loginPage, String ADMIN_LOGIN, String ADMIN_PASSWORD) {
        this.loginPage = loginPage;
        this.ADMIN_LOGIN = ADMIN_LOGIN;
        this.ADMIN_PASSWORD = ADMIN_PASSWORD;
    }

    @DataProvider()
    public Object[][] xlsData() throws Exception {
        return DataReader.dataReaderGeneric("./src/test/resources/data/Smoke_GroupFeature.xls", "UsersData");
    }

    @Test()
    public void addGroupTest(TestData testData) throws Exception {
        loginPage.loginAsAdmin(ADMIN_LOGIN, ADMIN_PASSWORD).chooseGroupsTab().
                addGroup(testData.getGroupNumber(), testData.getEnteringYear(), testData.getGraduatingYear());
    }

    @Test()
    public void addGroupFailTest(TestData testData, String errorMessage) throws Exception {
        loginPage.loginAsAdmin(ADMIN_LOGIN, ADMIN_PASSWORD).chooseGroupsTab().
                addGroupFail(testData.getGroupNumber(), testData.getEnteringYear(), testData.getGraduatingYear(), errorMessage);
    }

    @Test()
    public void changeGroupTest(TestData testData) throws Exception {
        loginPage.loginAsAdmin(ADMIN_LOGIN, ADMIN_PASSWORD).chooseGroupsTab().
                changeGroupInformation(testData.getGroupNumber(), testData.getChangedGroupNumber(),
                        testData.getChangedEnteringYear(), testData.getChangedGraduationYear());

    }

    @Test()
    public void changeGroupFailTest(TestData testData, String errorMessage) throws Exception {
        loginPage.loginAsAdmin(ADMIN_LOGIN, ADMIN_PASSWORD).chooseGroupsTab().
                changeGroupInformationFail(testData.getGroupNumber(), testData.getChangedGroupNumber(),
                        testData.getChangedEnteringYear(), testData.getChangedGraduationYear(), errorMessage);

    }

    @Test()
    public void removeEmptyGroupTest(TestData testData) throws Exception {
        loginPage.loginAsAdmin(ADMIN_LOGIN, ADMIN_PASSWORD).chooseGroupsTab().
                removeEmptyGroup(testData.getGroupNumber());
    }

    @Test()
    public void removeGroupWithStudents(TestData testData) throws Exception {
        loginPage.loginAsAdmin(ADMIN_LOGIN, ADMIN_PASSWORD).chooseGroupsTab()
                .removeGroupWithStudents(testData.getGroupNumber());
    }
}
