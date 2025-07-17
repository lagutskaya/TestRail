package tests.ui.positive_tests;

import org.testng.annotations.Test;
import tests.tests_settings.BaseTest;

import static org.testng.Assert.assertTrue;
import static utils.RandomStringGenerator.generateRandomString;

public class PositiveProjectTest extends BaseTest {

    String projectName = "QA " + generateRandomString(),
            projectAnnouncement = "Project Description " + generateRandomString(),
            sectionName = "Test section " + generateRandomString(),
            sectionDescription = "Test description " + generateRandomString(),
            updatedProjectDescription = "New Description " + generateRandomString(),
            updatedProjectName = "Test " + generateRandomString(),
            test_case_title = "Title " + generateRandomString();

    @Test(testName = "Create project", priority = 1, alwaysRun = true)
    public void createNewProject() {
        loginPage.openPage()
                .isPageOpened()
                .login();
        addProjectPage.isPageOpened()
                .clickOnAddNewProjectButton()
                .createNewProject(projectName, projectAnnouncement);
        projectsPage.isPageOpened();

        assertTrue(projectsPage.projectIsCreated(),
                "Project isn't created");
    }

    @Test(testName = "Creating a test suite", priority = 2, alwaysRun = true)
    public void createTestSection() {
        dashboardPage
                .openDashboardPage()
                .isPageOpened()
                .clickOnCreatedProject(projectName);
        projectPage.isPageOpened()
                .openTestCases();
        testCasesPage.isPageOpened()
                .clickOnCreateTesSectionButton();
        testSectionPage.isPageOpened()
                .setTestSection(sectionName)
                .clickOnCreateSectionButton();
        assertTrue(testSectionPage.testSectionIsCreated(), "Test section isn't created");
    }

    @Test(testName = "Add test case in test suite", priority = 3, alwaysRun = true)
    public void addTestCaseTest() {
        dashboardPage.openDashboardPage()
                .isPageOpened()
                .clickOnCreatedProject(projectName);
        testCasesPage.openProjectsTestCases()
                .isPageOpened()
                .clickOnAddTestCaseButton()
                .setTestCase(test_case_title)
                .clickSaveTestCaseButton();
        assertTrue(testCasesPage.isTestCaseCreated(), "Test case isn't created");
    }

    @Test(testName = "Update project description", priority = 4, alwaysRun = true)
    public void updateProjectDescriptionTest() {
        dashboardPage.openDashboardPage()
                .isPageOpened()
                .openAdminPage();
        adminPage.isPageOpened()
                .openProjectsPage()
                .updateProjectDescription(projectName, updatedProjectDescription);
        assertTrue(adminPage.isProjectDescriptionUpdated(), "Project's description isn't updated");
    }

    @Test(testName = "Update project name", priority = 5, alwaysRun = true)
    public void updateProjectName() {
        dashboardPage.openDashboardPage()
                .isPageOpened()
                .openAdminPage();
        adminPage.isPageOpened()
                .openProjectsPage()
                .updateProjectName(projectName, updatedProjectName);
        assertTrue(adminPage.isProjectNameUpdated(), "Project's name isn't updated");
    }

    @Test(testName = "Delete project", priority = 6, alwaysRun = true)
    public void deleteProject() {
        dashboardPage.openDashboardPage()
                .isPageOpened()
                .openAdminPage();
        adminPage.isPageOpened()
                .openProjectsPage()
                .deleteProject(projectName);
        assertTrue(adminPage.isProjectDeleted(), "Project isn't deleted");
    }

    @Test(testName = "Logout", priority = 7, alwaysRun = true)
    public void logout() {
        headerPage.logout();
        assertTrue(headerPage.userIslogout(), "User isn't logout");
    }
}
