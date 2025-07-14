package tests.UI;

import org.testng.annotations.Test;
import tests.TestSettings.BaseTest;

import static org.testng.Assert.assertTrue;

public class AddTestCasesTest extends BaseTest {

    String projectName = "Proj";
    String projectAnnouncement = "Project Description";
    String sectionName = "Test section";
    String sectionDescription = "Test description";

    @Test
    public void addTestCase() {
        loginPage.openPage()
                .isPageOpened()
                .login();
        addProjectPage.isPageOpened()
                .clickOnAddNewProjectButton()
                .createNewProject(projectName, projectAnnouncement);
        dashboardPage.openDashboardPage()
                .isPageOpened();
        projectPage.openCreatedProject(projectName)
                .isPageOpened();
        testCasesPage.openProjectsTestCases()
                .isPageOpened();
        testSectionPage.isPageOpened()
                .createTestSection(sectionName, sectionDescription)
                .addCaseInSection("Test case title");
        assertTrue(testSectionPage.testSectionIsCreated(), "Test case isn't created");
    }
}
