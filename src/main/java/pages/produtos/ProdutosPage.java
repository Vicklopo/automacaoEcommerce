package pages.produtos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.util.BasePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutosPage extends BasePage {

    private final By botaoCarrinho = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a");

    public ProdutosPage(WebDriver driver) {
        super(driver);
    }

    protected String nomeProduto;

    public void validarNomeProduto() throws Exception {
        if(driver.findElements(this.xpathProduto()).isEmpty()){
            throw new Exception("Produto não encontrado.");
        }
    }

    public void adicionarCarrinho() {
        driver.findElement(this.xpathBotaoProduto()).click();
    }

    public By xpathBotaoProduto() {
        return By
                .xpath("//div[contains(@class, 'inventory_item_name') and" +
                        " text()='" + this.getNomeProduto() + "']" +
                        "/ancestor::div[contains(@class, 'inventory_item_description')]" +
                        "/div[@class='pricebar']/button");
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public ProdutosPage setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
        return this;
    }

    public void botaoCarrinho() {
        driver.findElement(botaoCarrinho).click();
    }

    public void removerProduto() {
        By botaoRemover = By.xpath("//div[contains(@class, 'inventory_item_name') and" +
                " text()='" + this.getNomeProduto() + "']" +
                "/ancestor::div[contains(@class, 'cart_item_label')]" +
                "/div[@class='item_pricebar']/button");

        driver.findElement(botaoRemover).click();
    }

    public By xpathProduto() {
        return By
                .xpath("//div[contains(@class, 'inventory_item_name') and text()='" + this.nomeProduto + "']");
    }


    public void validarAdicaoCarrinho() {
        String textoBotao = driver.findElement(xpathBotaoProduto()).getText();
        assertEquals("REMOVE", textoBotao);
    }

    public void validarItemRemovido() throws Exception {
        if(!driver.findElements(this.xpathProduto()).isEmpty()){
            throw new Exception("O produto não foi removido do carrinho");
        };
    }

}


