package Automation_Playwright;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Clase que contiene métodos para realizar diferentes operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) en un servicio de pedidos.
 */
public class MiAutomation {

    public static void main(String[] args) {
        // URL del servicio de pedidos
        // Se debe ingresar la manual por defecto es 22 pero se debe cambiar
        String url = "http://localhost:8000/user/22";

        // Ejecutar el método GET
        //GET(url);

        // Ejecutar el método POST
        //POST(url);

        // Ejecutar el método PUT
        //PUT(url);

        // Ejecutar el método DELETE
        //DELETE(url);
    }

    /**
     * Método para realizar una solicitud GET al servicio de pedidos.
     * @param url La URL del servicio.
     */
    public static void GET(String url) {
        try {
            // Construir la solicitud GET
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            // Leer el código de respuesta del servidor
            int responseCode = connection.getResponseCode();

            // Leer la respuesta del servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    (responseCode < 400) ? connection.getInputStream() : connection.getErrorStream()));

            // Procesar la respuesta del servidor
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Imprimir el código de respuesta y la respuesta del servidor
            System.out.println("GET Response code: " + responseCode);
            System.out.println("GET Response from server: " + response.toString());

            // Cerrar la conexión
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para realizar una solicitud POST al servicio de pedidos.
     * @param url La URL del servicio.
     */
    public static void POST(String url) {
        try {
            // Construir la solicitud POST
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json"); // Establecer el tipo de contenido

            // Datos para enviar en la solicitud POST
            String postData =
                    "{\"direccion\":\"Calle Principal 123\","
                            + "\"fechaRecogida\":\"2024-05-10\","
                            + "\"nombreEntrega\":\"Juan\","
                            + "\"apellidoEntrega\":\"Perez\","
                            + "\"celularEntrega\":\"123456789\","
                            + "\"emailUsuario\":\"juan@example.com\","
                            + "\"descripcionTipoVia\":\"Avenida Principal\","
                            + "\"aplicativo\":\"App\"}";

            // Escribir los datos en la solicitud
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(postData.getBytes());
            outputStream.flush();

            // Leer el código de respuesta del servidor
            int responseCode = connection.getResponseCode();

            // Leer la respuesta del servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    (responseCode < 400) ? connection.getInputStream() : connection.getErrorStream()));

            // Procesar la respuesta del servidor
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Imprimir el código de respuesta y la respuesta del servidor
            System.out.println("POST Response code: " + responseCode);
            System.out.println("POST Response from server: " + response.toString());

            // Cerrar la conexión
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para realizar una solicitud PUT al servicio de pedidos.
     * @param url La URL del servicio.
     */
    public static void PUT(String url) {
        try {
            // Construir la solicitud PUT
            HttpURLConnection putConnection = (HttpURLConnection) new URL(url).openConnection();
            putConnection.setRequestMethod("PUT");
            putConnection.setDoOutput(true);
            putConnection.setRequestProperty("Content-Type", "application/json");

            // Datos para enviar en la solicitud PUT (actualización de usuario)
            String putData =
                    "{\"direccion\":\"test\","
                            + "\"fechaRecogida\":\"2024-05-15\","
                            + "\"nombreEntrega\":\"Pedro\","
                            + "\"apellidoEntrega\":\"González\","
                            + "\"celularEntrega\":\"987654321\","
                            + "\"emailUsuario\":\"pedro@example.com\","
                            + "\"descripcionTipoVia\":\"Calle secundaria\","
                            + "\"aplicativo\":\"App modificado\"}";

            // Escribir los datos en la solicitud PUT
            putConnection.getOutputStream().write(putData.getBytes());

            // Leer el código de respuesta de la solicitud PUT
            int responseCode = putConnection.getResponseCode();

            // Imprimir el código de respuesta de la solicitud PUT
            System.out.println("PUT Response code: " + responseCode);

            // Leer la respuesta del servidor de la solicitud PUT
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    (responseCode < 400) ? putConnection.getInputStream() : putConnection.getErrorStream()));

            // Procesar la respuesta del servidor de la solicitud PUT
            StringBuilder response = new StringBuilder();
            String Line;
            while ((Line = reader.readLine()) != null) {
                response.append(Line);
            }
            reader.close();

            // Imprimir la respuesta del servidor de la solicitud PUT
            System.out.println("PUT Response from server: " + response.toString());

            // Cerrar la conexión de la solicitud PUT
            putConnection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para realizar una solicitud DELETE al servicio de pedidos.
     * @param url La URL del servicio.
     */
    public static void DELETE(String url) {
        try {
            // Construir la solicitud DELETE
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("DELETE");

            // Leer el código de respuesta del servidor
            int responseCode = connection.getResponseCode();

            // Imprimir el código de respuesta
            System.out.println("DELETE Response code: " + responseCode);

            // Cerrar la conexión
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




