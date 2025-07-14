package pages.PageSettings;


import utils.PropertyReader;

public class BasePage {

    protected String user = System.getProperty("user", PropertyReader.getProperty("user"));
    protected String password = System.getProperty("password", PropertyReader.getProperty("password"));
    protected String base_url = System.getProperty("base_url", PropertyReader.getProperty("base_url"));
}
