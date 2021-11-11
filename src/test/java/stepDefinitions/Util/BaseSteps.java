package stepDefinitions.Util;

import org.openqa.selenium.WebDriver;
import pages.autenticacao.AutenticacaoPage;
import pages.util.BasePage;
import runnerFiles.TestRunner;

public class BaseSteps {

    protected static WebDriver driver = TestRunner.driver;
    BasePage basePage = new BasePage(driver);
    AutenticacaoPage loginPage = new AutenticacaoPage(driver);


}
