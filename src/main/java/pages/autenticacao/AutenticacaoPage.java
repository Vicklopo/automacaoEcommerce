package pages.autenticacao;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.util.BasePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutenticacaoPage extends BasePage {

    public AutenticacaoPage(WebDriver driver) {
        super(driver);
    }

    private final By username = By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/form/div[1]/input");
    private final By password = By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[2]/input");
    private final By btnLogin = By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/input");
    private final By textoCabecalho = By.xpath("/html/body/div/div/div/div[1]/div[2]/span");


    public AutenticacaoPage preencherUsername(String usuario) {
        driver.findElement(username).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
        driver.findElement(username).sendKeys(usuario);

        return this;
    }

    public void preencherPassword(String senha) {
        driver.findElement(password).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
        driver.findElement(password).sendKeys(senha);

    }


    public void clicarLogin() {
        driver.findElement(btnLogin).click();
    }

    private String textoCabecalho() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textoCabecalho));
        return driver.findElement(textoCabecalho).getText();
    }


    public void validacaoCabecalho(String validarCabecalho) {
        assertEquals(validarCabecalho.trim(), this.textoCabecalho());
    }

    public void acessarHome() {
        driver.get("https://www.saucedemo.com/");
    }
}

