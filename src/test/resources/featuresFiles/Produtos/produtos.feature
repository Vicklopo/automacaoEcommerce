@Carrinho
Feature: Adicionar os produtos ao carrinho

  A fim de adicionar produtos no carrinho
  Como usuario do sistema
  Que o mesmo possa ganhar um resultado benéfico que promova a meta


  @SelecionarProdutos
  Scenario Outline: Selecionar produtos do dashboard
    Given que o usuário se interessou por "<produto>"
    When o usuário seleciona botão "ADD TO CART" no card do produto
    Then o "<produto>" foi adicionado ao carrinho
    Examples:
      | produto                 |
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |

  @ValidarCarrinho
  Scenario: Validar produtos na página do carrinho
    Given que o usuário adicionou o produto
    When seleciona o botão "carrinho" no canto superior direito
    Then o usuário foi redirecionado para a página do carrinho


  @RemoverProdutos
  Scenario Outline: Remover produtos do carrinho
    Given que o usuário quer remover o "<produto>"
    When o mesmo seleciona o botão "REMOVE" no card do "<produto>"
    Then o item é retirado do carrinho
    Examples:
      | produto                 |
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |

















