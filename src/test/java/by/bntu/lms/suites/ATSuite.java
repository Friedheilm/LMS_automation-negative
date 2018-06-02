package by.bntu.lms.suites;

import by.bntu.lms.data.TestData;
import by.bntu.lms.tests.smoke.group.GroupFeature;
import by.bntu.lms.tests.smoke.professor.ProfessorFeature;
import by.bntu.lms.tests.smoke.student.StudentFeature;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static by.bntu.lms.data.DataReader.dataReaderGeneric;

@Test(groups = {"smoke"})
public class ATSuite extends SuiteBase {

    private final String STUDENT_DATA_PATH = "./src/test/resources/data/AT_StudentFeature.xls";
    private final String PROFESSOR_DATA_PATH = "./src/test/resources/data/AT_ProfessorFeature.xls";
    private final String GROUP_DATA_PATH = "./src/test/resources/data/AT_GroupFeature.xls";

    public ATSuite() throws IOException {
    }

    //Student data providers.
    @DataProvider()
    public Object[][] addStudentData() throws Exception {
        return dataReaderGeneric(STUDENT_DATA_PATH, "AddStudent");
    }

    @DataProvider()
    public Object[][] changeStudentData() throws Exception {
        return dataReaderGeneric(STUDENT_DATA_PATH, "ChangeStudent");
    }

    @DataProvider()
    public Object[][] changeStudentSurnameFailData() throws Exception {
        return dataReaderGeneric(STUDENT_DATA_PATH, "ChangeStudentSurnameFail");
    }

    @DataProvider()
    public Object[][] removeStudentData() throws Exception {
        return dataReaderGeneric(STUDENT_DATA_PATH, "RemoveStudent");
    }

    // Professor data providers.
    @DataProvider()
    public Object[][] addProfessorData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "AddProfessor");
    }

    @DataProvider()
    public Object[][] addProfessorEmptyLoginFailData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "AddProfessorEmptyLoginFail");
    }

    @DataProvider()
    public Object[][] addProfessorEmptyNameFailData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "AddProfessorEmptyNameFail");
    }

    @DataProvider()
    public Object[][] addProfessorShortPassFailData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "AddProfessorShortPassFail");
    }

    @DataProvider()
    public Object[][] addProfessorEmptySurnameFailData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "AddProfessorEmptySurnameFail");
    }

    @DataProvider()
    public Object[][] addProfessorNameFailData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "AddProfessorNameFail");
    }

    @DataProvider()
    public Object[][] addProfessorSurnameFailData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "AddProfessorSurnameFail");
    }

    @DataProvider()
    public Object[][] addProfessorPatronymicFailData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "AddProfessorPatronymicFail");
    }

    @DataProvider()
    public Object[][] changeProfessorData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "ChangeProfessor");
    }

    @DataProvider()
    public Object[][] changeProfessorNameFailData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "ChangeProfessorNameFail");
    }

    @DataProvider()
    public Object[][] changeProfessorEmptyNameFailData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "ChangeProfessorEmptyNameFail");
    }

    @DataProvider()
    public Object[][] changeProfessorEmptySurnameFailData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "ChangeProfessorEmptySurnameFail");
    }

    @DataProvider()
    public Object[][] changeProfessorSurnameFailData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "ChangeProfessorSurnameFail");
    }

    @DataProvider()
    public Object[][] changeProfessorPatronymicFailData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "ChangeProfessorPatronymicFail");
    }

    @DataProvider()
    public Object[][] searchProfessorData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "SearchProfessor");
    }

    @DataProvider()
    public Object[][] removeProfessorData() throws Exception {
        return dataReaderGeneric(PROFESSOR_DATA_PATH, "DeleteProfessor");
    }

    // Group data providers.
    @DataProvider()
    public Object[][] addGroupData() throws Exception {
        return dataReaderGeneric(GROUP_DATA_PATH, "AddGroup");
    }

    @DataProvider()
    public Object[][] addGroupEmptyFailData() throws Exception {
        return dataReaderGeneric(GROUP_DATA_PATH, "AddGroupEmptyFail");
    }

    @DataProvider()
    public Object[][] addGroupNumberFailData() throws Exception {
        return dataReaderGeneric(GROUP_DATA_PATH, "AddGroupNumberFail");
    }

    @DataProvider()
    public Object[][] addGroupYearFailData() throws Exception {
        return dataReaderGeneric(GROUP_DATA_PATH, "AddGroupYearFail");
    }

    @DataProvider()
    public Object[][] addGroupExistFailData() throws Exception {
        return dataReaderGeneric(GROUP_DATA_PATH, "AddGroupExistFail");
    }

    @DataProvider()
    public Object[][] changeGroupData() throws Exception {
        return dataReaderGeneric(GROUP_DATA_PATH, "ChangeGroup");
    }

    @DataProvider()
    public Object[][] changeGroupEmptyFailData() throws Exception {
        return dataReaderGeneric(GROUP_DATA_PATH, "ChangeGroupEmptyFail");
    }

    @DataProvider()
    public Object[][] changeGroupYearFailData() throws Exception {
        return dataReaderGeneric(GROUP_DATA_PATH, "changeGroupYearFail");
    }

    @DataProvider()
    public Object[][] changeGroupExistFailData() throws Exception {
        return dataReaderGeneric(GROUP_DATA_PATH, "changeGroupExistFail");
    }

    @DataProvider()
    public Object[][] removeEmptyGroupData() throws Exception {
        return dataReaderGeneric(GROUP_DATA_PATH, "RemoveEmptyGroup");
    }

    @DataProvider()
    public Object[][] removeGroupWithStudentsData() throws Exception {
        return dataReaderGeneric(GROUP_DATA_PATH, "RemoveGroupWithStudents");
    }

    // Student tests.

    @Test(priority = 5, dataProvider = "addStudentData")
    public void addStudentTest(TestData testData) throws Exception {
        new StudentFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).addStudentTest(testData);
    }

//    @Test(priority = 6, dataProvider = "changeStudentSurnameFailData")
//    public void changeStudentFailTest(TestData testData) throws Exception {
//        new StudentFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).changeStudentFailTest(testData, "Фамилия не может иметь размер больше 50 символов");
//    }

    @Test(priority = 7, dataProvider = "changeStudentData")
    public void changeStudentTest(TestData testData) throws Exception {
        new StudentFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).changeStudentTest(testData);
    }

    // Professor tests.

    @Test(priority = 9, dataProvider = "addProfessorEmptyLoginFailData")
    public void addProfessorEmptyLoginFailTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).addProfessorFailTest(testData, "Поле Логин обязательно для заполнения");
    }

    @Test(priority = 9, dataProvider = "addProfessorSurnameFailData")
    public void addProfessorSurnameFailTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).addProfessorFailTest(testData, "Фамилия не может иметь размер больше 50 символов");
    }

    @Test(priority = 9, dataProvider = "addProfessorEmptySurnameFailData")
    public void addProfessorEmptySurnameFailTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).addProfessorFailTest(testData, "Поле Фамилия обязательно для заполнения");
    }

    @Test(priority = 9, dataProvider = "addProfessorNameFailData")
    public void addProfessorNameFailTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).addProfessorFailTest(testData, "Имя не может иметь размер больше 50 символов");
    }

    @Test(priority = 9, dataProvider = "addProfessorPatronymicFailData")
    public void addProfessorPatronymicFailTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).addProfessorFailTest(testData, "Отчество не может иметь размер больше 50 символов");
    }

    @Test(priority = 9, dataProvider = "addProfessorEmptyNameFailData")
    public void addProfessorEmptyNameFailTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).addProfessorFailTest(testData, "Поле Имя обязательно для заполнения");
    }

    @Test(priority = 9, dataProvider = "addProfessorShortPassFailData")
    public void addProfessorShortPassFailTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).addProfessorFailTest(testData, "Пароль должно быть не менее 6 символов.");
    }

    @Test(priority = 10, dataProvider = "addProfessorData")
    public void addProfessorTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).addProfessorTest(testData);
    }

    // Surname exist ?

    @Test(priority = 12, dataProvider = "changeProfessorSurnameFailData")
    public void changeProfessorSurnameFailTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).changeProfessorFailTest(testData, "Фамилия не может иметь размер больше 50 символов");
    }

    @Test(priority = 12, dataProvider = "changeProfessorEmptySurnameFailData")
    public void changeProfessorEmptySurnameFailTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).changeProfessorFailTest(testData, "Поле Фамилия обязательно для заполнения");
    }

    @Test(priority = 12, dataProvider = "changeProfessorNameFailData")
    public void changeProfessorNameFailTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).changeProfessorFailTest(testData, "Имя не может иметь размер больше 50 символов");
    }

    @Test(priority = 12, dataProvider = "changeProfessorEmptyNameFailData")
    public void changeProfessorEmptyNameFailTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).changeProfessorFailTest(testData, "Поле Имя обязательно для заполнения");
    }

    @Test(priority = 12, dataProvider = "changeProfessorPatronymicFailData")
    public void changeProfessorPatronymicFailTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).changeProfessorFailTest(testData, "Отчество не может иметь размер больше 50 символов");
    }



    // Empty name, surname; Long, name, surname, patronymic.

    @Test(priority = 13, dataProvider = "changeProfessorData")
    public void changeProfessorTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).changeProfessorTest(testData);
    }

    @Test(priority = 14, dataProvider = "searchProfessorData")
    public void searchProfessorTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).searchProfessorTest(testData);
    }

    @Test(priority = 15, dataProvider = "removeProfessorData")
    public void removeProfessorTest(TestData testData) throws Exception {
        new ProfessorFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).removeProfessorTest(testData);
    }

    // Group tests.
    @Test(priority = 1, dataProvider = "addGroupData")
    public void addGroupTest(TestData testData) throws Exception {
        new GroupFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).addGroupTest(testData);
    }

    @Test(priority = 2, dataProvider = "addGroupEmptyFailData")
    public void addGroupEmptyFailTest(TestData testData) throws Exception {
        new GroupFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).addGroupFailTest(testData, "Поле Номер обязательно для заполнения");
    }

    @Test(priority = 2, dataProvider = "addGroupNumberFailData")
    public void addGroupNumberFailTest(TestData testData) throws Exception {
        new GroupFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).addGroupFailTest(testData, "Длина поля Номер группы не должна превышать 10 символов");
    }

    @Test(priority = 2, dataProvider = "addGroupYearFailData")
    public void addGroupYearFailTest(TestData testData) throws Exception {
        new GroupFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).addGroupFailTest(testData, "Значение поля Год выпуска должен быть больше Года поступления");
    }

    @Test(priority = 2, dataProvider = "addGroupExistFailData")
    public void addGroupExistFailTest(TestData testData) throws Exception {
        new GroupFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).addGroupFailTest(testData, "Группа с таким номером уже существует");
    }

    @Test(priority = 3, dataProvider = "changeGroupData")
    public void changeGroupTest(TestData testData) throws Exception {
        new GroupFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).changeGroupTest(testData);
    }

    // Exist, year, number.
    @Test(priority = 4, dataProvider = "changeGroupEmptyFailData")
    public void changeGroupEmptyFailTest(TestData testData) throws Exception {
        new GroupFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).changeGroupFailTest(testData, "Поле Номер обязательно для заполнения");
    }

    @Test(priority = 4, dataProvider = "changeGroupYearFailData")
    public void changeGroupYearFailTest(TestData testData) throws Exception {
        new GroupFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).changeGroupFailTest(testData, "Значение поля Год выпуска должен быть больше Года поступления");
    }

    @Test(priority = 4, dataProvider = "changeGroupExistFailData")
    public void changeGroupExistFailTest(TestData testData) throws Exception {
        new GroupFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).changeGroupFailTest(testData, "Группа с таким номером уже существует");
    }

    // Students creation here.
    @Test(priority = 9, dataProvider = "removeEmptyGroupData")
    public void removeEmptyGroupTest(TestData testData) throws Exception {
        new GroupFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).removeEmptyGroupTest(testData);
    }

    @Test(priority = 8, dataProvider = "removeGroupWithStudentsData")
    public void removeGroupWithStudentsTest(TestData testData) throws Exception {
        new GroupFeature(loginPage, ADMIN_LOGIN, ADMIN_PASSWORD).removeGroupWithStudents(testData);
    }
}
