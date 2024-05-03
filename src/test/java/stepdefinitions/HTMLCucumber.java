package stepdefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.presentation.PresentationMode;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que define la configuración para generar informes HTML y JSON utilizando Cucumber.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java", // Ruta de los archivos de características
        glue = "stepdefinitions", // Paquete que contiene las definiciones de pasos
        plugin = {
                "html:target/cucumber-HTML", // Generar informes HTML
                "json:target/cucumber-JSON" // Generar informes JSON
        }
)
public class HTMLCucumber {

    /**
     * Método que se ejecuta después de ejecutar todas las pruebas.
     * Genera los informes HTML a partir de los archivos JSON generados por las pruebas.
     */
    @AfterClass
    public static void generateReport() {
        try {
            // Directorio donde se guardarán los informes HTML
            File reportOutputDirectory = new File("C:\\Users\\Nelson\\eclipse-workspace\\crud\\src\\test\\java\\reporteHTML");

            // Configuración del reporte
            Configuration configuration = new Configuration(reportOutputDirectory, "Coordinadora-ReporteHTML");
            configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);

            // Lista de archivos JSON generados
            List<String> jsonFiles = new ArrayList<>();
            jsonFiles.add("target/cucumber-JSON");

            // Generar el reporte HTML utilizando los archivos JSON
            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
            Reportable reportable = reportBuilder.generateReports();

            // Verificar si la generación del reporte fue exitosa
            if (reportable == null) {
                System.out.println("Se generaron los informes correctamente.");
            } else {
                System.out.println("Error al generar los informes.");
            }
        } catch (Exception e) {
            System.err.println("Error durante la generación del informe: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

