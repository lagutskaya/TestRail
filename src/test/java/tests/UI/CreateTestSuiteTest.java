package tests.UI;

import org.testng.annotations.Test;
import tests.TestSettings.BaseTest;

import static org.testng.Assert.assertTrue;

public class CreateTestSuiteTest extends BaseTest {

    String sectionName = "Test section";
    String sectionDescription = "Test description";
    String projectName = "QA";

    @Test(testName = "Creating a test suite", alwaysRun = true)
    public void createTestSuite() {
        loginPage.openPage()
                .isPageOpened()
                .login();
        dashboardPage.isPageOpened()
                .clickOnCreatedProject(projectName);
        projectPage.isPageOpened()
                .openTestCases();
        testCasesPage.isPageOpened()
                .clickOnAddSectionButton();
        testSectionPage.isPageOpened()
                .createTestSection(sectionName, sectionDescription);
        assertTrue(testSectionPage.testSectionIsCreated(), "Test section isn't created");
    }
}
