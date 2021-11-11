package runnerFiles;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/featuresFiles/Autenticacao/autenticacao.feature",
                "src/test/resources/featuresFiles/Produtos/produtos.feature",
        }
        , glue = "stepDefinitions"
        , plugin = {"pretty", "html:target/cucumber-report.html"}
//        , tags = "@Carrinho"
)

public class TestRunner {

    public static WebDriver driver;

    @BeforeClass
    public static void beforeAll() {

        if (driver==null){
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver95.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
    }

    @AfterClass
    public static void afterAll() {
//        driver.quit();



    }
}
