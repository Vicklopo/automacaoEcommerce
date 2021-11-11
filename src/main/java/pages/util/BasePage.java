package pages.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BasePage {

    private final By alertaErro = By.xpath("//div[contains(@class, 'error')]/h3");

    public String alertaObrigatorio;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 45);
    }

    private String alertaErro() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertaErro));
        return driver.findElement(alertaErro).getText();

    }

    public void validacaoErro(String mensagem) {
        assertEquals(mensagem.trim(), this.alertaErro());
    }
}
