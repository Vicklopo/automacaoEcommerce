package stepDefinitions.ProdutosSteps;

import io.cucumber.java.en.*;
import pages.produtos.ProdutosPage;

import static runnerFiles.TestRunner.driver;

public class ProdutosSteps {
    ProdutosPage produtosPage = new ProdutosPage(driver);


    @Given("que o usuário se interessou por {string}")
    @Given("que o usuário quer remover o {string}")
    public void nomeProduto(String produto) throws Exception {
        produtosPage.setNomeProduto(produto)
                .validarNomeProduto();
    }

    @When("o usuário seleciona botão {string} no card do produto")
    public void botaoAdicionarCarrinho(String botaoAdicionar) {
        produtosPage.adicionarCarrinho();
    }

    @Then("o {string} foi adicionado ao carrinho")
    public void adicaoProduto(String produto) {
        produtosPage.setNomeProduto(produto).validarAdicaoCarrinho();
    }

    @When("seleciona o botão {string} no canto superior direito")
    public void botaoCarrinho(String botaoCarrinho) {
        produtosPage.botaoCarrinho();
    }

    @Then("o usuário foi redirecionado para a página do carrinho")
    public void validarURLCarrinho() throws Exception {
        if (!driver.getCurrentUrl().contains("https://www.saucedemo.com/cart.html")) {
            throw new Exception("O sistema não redirionou para a página esperada");
        }
    }

    @Given("que o usuário adicionou o produto")
    public void informativo() {
    }

    @When("o mesmo seleciona o botão {string} no card do {string}")
    public void botaoRemove(String botaoremover, String produto) {
        produtosPage.setNomeProduto(produto).removerProduto();
    }

    @Then("o item é retirado do carrinho")
    public void validarRemocaoProduto() throws Exception {
        produtosPage.validarItemRemovido();
    }


}
