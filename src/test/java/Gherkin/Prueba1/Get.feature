Feature: Gestión de pedidos en el sistema

  Scenario: Consultar detalles de un pedido por ID
    Given que estoy en el servicio de pedidos
    When realizo una solicitud GET con el ID
    Then debería recibir una respuesta exitosa con código 200

  Scenario: Eliminar un pedido por ID
    Given que estoy en el servicio de pedidos
    When realizo una solicitud DELETE con el ID
    Then debería recibir una respuesta exitosa con código 200

  Scenario: Crear un nuevo pedido
    Given que estoy en el servicio de pedidos
    And tengo los detalles de un nuevo pedido
    When realizo una solicitud POST para crear el pedido
    Then debería recibir una respuesta exitosa con código 200
