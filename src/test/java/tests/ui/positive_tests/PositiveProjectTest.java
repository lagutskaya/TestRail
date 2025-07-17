package tests.ui.positive_tests;

import org.testng.annotations.Test;
import tests.tests_settings.BaseTest;

import static org.testng.Assert.assertTrue;
import static utils.RandomStringGenerator.generateRandomString;

public class PositiveProjectTest extends BaseTest {

    String projectName = "QA " + generateRandomString(),
            projectAnnouncement = "Project Description " + generateRandomString(),
            updatedProjectDescription = "New Description " + generateRandomString();

    @Test(testName = "Create project", priority = 1, alwaysRun = true)
    public void checkCreateNewProject() {
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

    @Test(testName = "Update project description", priority = 2, alwaysRun = true)
    public void updateProjectDescription() {
        dashboardPage.openDashboardPage()
                .isPageOpened()
                .openAdminPage();
        adminPage.isPageOpened()
                .openProjectsPage()
                .updateProjectDescription(projectName, updatedProjectDescription);
        assertTrue(adminPage.isProjectDescriptionUpdated(), "Project's description isn't updated");
    }

    @Test(testName = "Delete project", priority = 3, alwaysRun = true)
    public void deleteProject() {
        dashboardPage.openDashboardPage()
                .isPageOpened()
                .openAdminPage();
        adminPage.isPageOpened()
                .openProjectsPage()
                .deleteProject(projectName);
        assertTrue(adminPage.isProjectDeleted(), "Project isn't deleted");
    }

    @Test(testName = "Logout", priority = 4, alwaysRun = true)
    public void logout() {
        headerPage.logout();
        assertTrue(headerPage.userIslogout(), "User isn't logout");
    }
}
