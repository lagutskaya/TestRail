package tests.UI;

import org.testng.annotations.Test;
import tests.TestSettings.BaseTest;

import static org.testng.Assert.assertTrue;

public class CreateProjectTest extends BaseTest {

    String projectName = "Qa";
    String projectAnnouncement = "Project Description";

    @Test(testName = "Create project", alwaysRun = true)
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
}
