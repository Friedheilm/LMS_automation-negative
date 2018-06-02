package by.bntu.lms.tests.smoke.professor;

import by.bntu.lms.data.TestData;
import by.bntu.lms.pages.common.LoginPage;
import org.testng.annotations.Test;

public class ProfessorFeature {
    LoginPage loginPage;
    String ADMIN_LOGIN;
    String ADMIN_PASSWORD;

    public ProfessorFeature(LoginPage loginPage, String ADMIN_LOGIN, String ADMIN_PASSWORD) {
        this.loginPage = loginPage;
        this.ADMIN_LOGIN = ADMIN_LOGIN;
        this.ADMIN_PASSWORD = ADMIN_PASSWORD;
    }

    @Test(priority = 1)
    public void addProfessorTest(TestData testData) throws Exception {
        loginPage.loginAsAdmin(ADMIN_LOGIN, ADMIN_PASSWORD).chooseProfessorsTab().addProfessor(
                testData.getUserName(), testData.getPassword(), testData.getSurname(), testData.getName(),
                testData.getPatronymic());
    }

    @Test(priority = 1)
    public void addProfessorFailTest(TestData testData, String errorMessage) throws Exception {
        loginPage.loginAsAdmin(ADMIN_LOGIN, ADMIN_PASSWORD).chooseProfessorsTab().addProfessorFail(
                testData.getUserName(), testData.getPassword(), testData.getSurname(), testData.getName(),
                testData.getPatronymic(), errorMessage);
    }

//    @Test(priority = 1)
//    public void negativeAddProfessorTest(TestData testData) throws Exception {
//        loginPage.loginAsAdmin(ADMIN_LOGIN, ADMIN_PASSWORD).chooseProfessorsTab().negativeAddProfessor(
//                testData.getUserName(), testData.getPassword(), testData.getSurname(), testData.getName(),
//                testData.getPatronymic()).checkErrorAfterAdding();
//    }

    @Test()
    public void changeProfessorNameFailTest(TestData testData, String errorMessage) throws Exception {
        loginPage.loginAsAdmin(ADMIN_LOGIN, ADMIN_PASSWORD).chooseProfessorsTab().
                changeProfessorInformationFail(testData.getLogin(), testData.getChangedName(), testData.getChangedSurname(),
                        testData.getChangedPatronymic(), errorMessage);
    }

    @Test()
    public void changeProfessorTest(TestData testData) throws Exception {
        loginPage.loginAsAdmin(ADMIN_LOGIN, ADMIN_PASSWORD).chooseProfessorsTab().
                changeProfessorInformation(testData.getLogin(), testData.getChangedName(), testData.getChangedSurname(),
                        testData.getChangedPatronymic());
    }

    @Test()
    public void searchProfessorTest(TestData testData) throws Exception {
        loginPage.loginAsAdmin(ADMIN_LOGIN, ADMIN_PASSWORD).chooseProfessorsTab().
                searchProfessor(testData.getSurname()).checkProfessorInSearchResults(testData.getSurname());
    }

    @Test()
    public void removeProfessorTest(TestData testData) throws Exception {
        loginPage.loginAsAdmin(ADMIN_LOGIN, ADMIN_PASSWORD).chooseProfessorsTab().
                removeProfessor(testData.getUserName());
    }
}
