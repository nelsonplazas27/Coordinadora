package stepdefinitions;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Clase Step que contiene los pasos de los escenarios definidos en las features.
 */
public class Step {

    private String apiUrl;
    private String idPedido;
    private String responseFromServer;
    private String postData;
    private int responseCode; // Código de respuesta de la solicitud

    /**
     * Establece el contexto para el servicio de pedidos.
     */
    @Given("que estoy en el servicio de pedidos")
    public void servicioPedidos() {
        apiUrl = "http://localhost:8000/user";
    }

    /**
     * Realiza una solicitud GET con el ID especificado.
     */
    @When("realizo una solicitud GET con el ID")
    public void getPedidos() {
        idPedido = "/5"; //Ingrese ID
        responseFromServer = sendGetRequest(apiUrl + idPedido);
    }

    /**
     * Verifica si se recibió una respuesta exitosa con código 200.
     */
    @Then("debería recibir una respuesta exitosa con código 200")
    public void Respuesta() {
        // Verificar el código de respuesta
        if (responseFromServer != null || responseFromServer.contains("200 OK")) {
            System.out.println("La respuesta fue exitosa (código 200)");
        } else {
            System.out.println("La respuesta no fue exitosa");
        }
        System.out.println("Response from server: " + responseFromServer);
    }

    /**
     * Realiza una solicitud DELETE con el ID especificado.
     */
    @When("realizo una solicitud DELETE con el ID")
    public void deleteId() {
        idPedido = "/4";//Ingrese ID
        responseFromServer = sendDeleteRequest(apiUrl + idPedido);
    }

    /**
     * Prepara los detalles de un nuevo pedido.
     */
    @Given("tengo los detalles de un nuevo pedido")
    public void nuevoPedido() {
        // Preparar los detalles del nuevo pedido en formato JSON
        postData =
                "{\"direccion\":\"Calle 80\","
                        + "\"fechaRecogida\":\"2024-05-10\","
                        + "\"nombreEntrega\":\"Nelson\","
                        + "\"apellidoEntrega\":\"Plazas\","
                        + "\"celularEntrega\":\"3112931748\","
                        + "\"emailUsuario\":\"nelsonplazas@gmail.com\","
                        + "\"descripcionTipoVia\":\"terrestres\","
                        + "\"aplicativo\":\"on\"}";
    }

    /**
     * Realiza una solicitud POST para crear el pedido.
     */
    @When("realizo una solicitud POST para crear el pedido")
    public void pedidoPost() {
        try {
            // Construir la solicitud POST
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            // Escribir los datos del pedido en la solicitud
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(postData.getBytes());
            outputStream.flush();

            // Obtener el código de respuesta del servidor
            responseCode = connection.getResponseCode();

            // Leer la respuesta del servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            responseFromServer = response.toString();

            // Cerrar la conexión
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método privado para enviar una solicitud GET y obtener la respuesta del servidor.
     *
     * @param apiUrl La URL a la que se realiza la solicitud.
     * @return La respuesta del servidor.
     */
    private String sendGetRequest(String apiUrl) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    /**
     * Método privado para enviar una solicitud DELETE y obtener la respuesta del servidor.
     *
     * @param apiUrl La URL a la que se realiza la solicitud.
     * @return La respuesta del servidor.
     */
    private @NotNull String sendDeleteRequest(String apiUrl) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}






