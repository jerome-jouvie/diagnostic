package fr.softwaymedical.diagnostic;

import fr.softwaymedical.diagnostic.annotation.BusinessService;
import fr.softwaymedical.diagnostic.usecase.AutoDiagnosticUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.stream.IntStream;

@SpringBootApplication
// Chargement des services métiers
@ComponentScan(includeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        value = BusinessService.class))
public class AutoDiagnosticApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AutoDiagnosticApplication.class);
    }

    private final AutoDiagnosticUseCase autoDiagnosticUseCase;

    @Autowired
    public AutoDiagnosticApplication(AutoDiagnosticUseCase autoDiagnosticUseCase) {
        this.autoDiagnosticUseCase = autoDiagnosticUseCase;
    }

    @Override
    public void run(String... args) {
        // La cabine effectue 50 diagnostics
        // Note: dans un cas réel, le diagnotic sera déclanché de manière automatisé
        // (évenement ou autre mécanisme prévu par la cabine)
        int nombreDiagnostiques = 50;
        IntStream.range(0, nombreDiagnostiques)
                .forEach(i -> autoDiagnosticUseCase.evaluate());
    }
}