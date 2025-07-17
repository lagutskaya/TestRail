package tests.ui.negative_tests;

import org.testng.annotations.Test;
import tests.tests_settings.BaseTest;

import static org.testng.Assert.assertTrue;

public class NegativeProjectTest extends BaseTest {

    String emptyProjectName = "",
            emptyProjectAnnouncement = "",
            projectName = "QA yej",
            emptyTestCaseTitle = "";

    @Test(testName = "Create project without values", priority = 1, alwaysRun = true)
    public void checkCreateNewProjectWithoutValues() {
        loginPage.openPage()
                .isPageOpened()
                .login();
        addProjectPage.isPageOpened()
                .clickOnAddNewProjectButton()
                .createNewProject(emptyProjectName, emptyProjectAnnouncement);
        projectsPage.isPageOpened();

        assertTrue(projectsPage.projectIsNotCreated(),
                "Project is created");
    }

    @Test(testName = "Create test case without values", priority = 2, alwaysRun = true)
    public void checkCreateTestCaseWithoutValues() {
        dashboardPage.openDashboardPage()
                .isPageOpened()
                .clickOnCreatedProject(projectName);
        testCasesPage.openProjectsTestCases()
                .isPageOpened()
                .clickOnAddTestCaseButton()
                .setTestCase(emptyTestCaseTitle)
                .clickSaveTestCaseButton();

        assertTrue(testCasesPage.isTestCaseIsNotCreated(), "Test case is created");
    }
}
