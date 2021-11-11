@Autenticacao
Feature: Autenticacao

  A fim de realizar uma autenticacao
  Como usuario do sistema
  Que o mesmo possa ganhar um resultado benéfico que promova a meta

  @Acesso
    Scenario: Acessar ao sistema
    Given que o usuário está acessado na página de login

  @CamposObrigatorios
  Scenario Outline: Validação de campos obrigatórios
    When preenche o campo "<Usarname>" com o seu usuário
    But não preenche o campo "<Password>"
    And seleciona o botão "LOGIN"
    Then o sistema exibe uma mensagem de alerta com "<alertaErro>"
    Examples:
      | Usarname      | Password | alertaErro                         |
      | standard_user |          | Epic sadface: Password is required |

  @LoginFalha
  Scenario Outline: Login sem sucesso
    When preenche o campo "<Usarname>" com o seu usuário
    But não preenche o campo "<Password>" com uma senha que corresponda ao seu usuário
    And seleciona o botão "LOGIN"
    Then o sistema exibe uma mensagem de alerta com "<alertaErro>"
    Examples:
      | Usarname      | Password | alertaErro                                                                |
      | standard_user | teste    | Epic sadface: Username and password do not match any user in this service |

  @LoginSucesso
  Scenario Outline: Login com sucesso
    When preenche os campos "<Usarname>" e "<Password>" de acordo com o seu usuário
    And seleciona o botão "LOGIN"
    Then o sistema é redirecionado para o dashboard

    Examples:
      | Usarname      | Password     |
      | standard_user | secret_sauce |












