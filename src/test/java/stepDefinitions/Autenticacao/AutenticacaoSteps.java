package stepDefinitions.Autenticacao;

import stepDefinitions.Util.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.autenticacao.AutenticacaoPage;

public class AutenticacaoSteps extends BaseSteps {
    AutenticacaoPage autenticacaoPage = new AutenticacaoPage(driver);


    @Given("que o usuário está acessado na página de login")
    public void paginaLogin() throws Exception {
        autenticacaoPage.acessarHome();
        if (!driver.getCurrentUrl().contains("https://www.saucedemo.com/")) {
            throw new Exception("O sistema não acessou a página esperada");
        }
    }
    @When("preenche o campo {string} com o seu usuário")
    public void preenherUsername(String Username) throws Exception{
        autenticacaoPage.preencherUsername(Username);
    }
    @When("preenche os campos {string} e {string} de acordo com o seu usuário")
    public void preencherUsername(String Username, String Password) throws Exception {
        autenticacaoPage.preencherUsername(Username)
                .preencherPassword(Password);
    }

    @And("seleciona o botão {string}")
    public void botaoLogin(String btnLogin) {
        autenticacaoPage.clicarLogin();
    }

    @Then("o sistema exibe uma mensagem de alerta com {string}")
    public void mensagemAlerta(String alertaErro) {
        autenticacaoPage.validacaoErro(alertaErro);
    }

    @When("não preenche o campo {string}")
    @When("não preenche o campo {string} com uma senha que corresponda ao seu usuário")
    public void preencherPassword(String Password) throws Exception {
        autenticacaoPage.preencherPassword(Password);

    }

    @Then("o sistema é redirecionado para o dashboard")
    public void validarURLDash() throws Exception {
        if (!driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html")) {
            throw new Exception("O sistema não redirionou para a página esperada");
        }
        autenticacaoPage.validacaoCabecalho("PRODUCTS");
    }
}
