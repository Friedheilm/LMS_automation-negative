package by.bntu.lms.data;

public class TestData {
    private String testName;
    private String adminLogin;
    private String adminPassword;
    private String login;
    private String password;
    private String groupNumber;
    private String enteringYear;
    private String graduatingYear;
    private String changedGroupNumber;
    private String changedEnteringYear;
    private String changedGraduationYear;
    private String userName;
    private String name;
    private String surname;
    private String patronymic;
    private String changedName;
    private String changedSurname;
    private String changedPatronymic;
    private boolean expectFailure;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getEnteringYear() {
        return enteringYear;
    }

    public void setEnteringYear(String enteringYear) {
        this.enteringYear = enteringYear;
    }

    public String getGraduatingYear() {
        return graduatingYear;
    }

    public void setGraduatingYear(String graduatingYear) {
        this.graduatingYear = graduatingYear;
    }

    public String getChangedGroupNumber() {
        return changedGroupNumber;
    }

    public void setChangedGroupNumber(String changedGroupNumber) {
        this.changedGroupNumber = changedGroupNumber;
    }

    public String getChangedEnteringYear() {
        return changedEnteringYear;
    }

    public void setChangedEnteringYear(String changedEnteringYear) {
        this.changedEnteringYear = changedEnteringYear;
    }

    public String getChangedGraduationYear() {
        return changedGraduationYear;
    }

    public void setChangedGraduationYear(String changedGraduationYear) {
        this.changedGraduationYear = changedGraduationYear;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getChangedName() {
        return changedName;
    }

    public void setChangedName(String changedName) {
        this.changedName = changedName;
    }

    public String getChangedSurname() {
        return changedSurname;
    }

    public void setChangedSurname(String changedSurname) {
        this.changedSurname = changedSurname;
    }

    public String getChangedPatronymic() {
        return changedPatronymic;
    }

    public void setChangedPatronymic(String changedPatronymic) {
        this.changedPatronymic = changedPatronymic;
    }

    public boolean isExpectFailure() {
        return expectFailure;
    }

    public void setExpectFailure(boolean expectFailure) {
        this.expectFailure = expectFailure;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "testName='" + testName + '\'' +
                ", adminLogin='" + adminLogin + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", groupNumber='" + groupNumber + '\'' +
                ", enteringYear='" + enteringYear + '\'' +
                ", graduatingYear='" + graduatingYear + '\'' +
                ", changedGroupNumber='" + changedGroupNumber + '\'' +
                ", changedEnteringYear='" + changedEnteringYear + '\'' +
                ", changedGraduationYear='" + changedGraduationYear + '\'' +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", changedName='" + changedName + '\'' +
                ", changedSurname='" + changedSurname + '\'' +
                ", changedPatronymic='" + changedPatronymic + '\'' +
                ", expectFailure=" + expectFailure +
                '}';
    }
}
