#Author: Felipe
    #Language: EN

  Feature: Consultar productos en la pagina de Amazon.com
    Como consumidor necesito buscar Televisores LG en Amazon
    para poder validar el precio y comprar el producto

    @TEST-123
  Scenario: Buscar TV LG en la pagina de Amazon.com
    Given que me encuentro en la pagina de Amazon
    When busco el producto "TV LG" en el buscador
    Then debo ver la pagina de resultados
    And agrego el resultado al carrito
    Then debo ver el carrito con el producto