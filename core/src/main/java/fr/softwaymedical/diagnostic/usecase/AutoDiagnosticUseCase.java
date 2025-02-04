package fr.softwaymedical.diagnostic.usecase;

import fr.softwaymedical.diagnostic.annotation.BusinessService;
import fr.softwaymedical.diagnostic.domain.Diagnostic;
import fr.softwaymedical.diagnostic.domain.IndexDeSante;
import fr.softwaymedical.diagnostic.domain.MessageEcran;
import fr.softwaymedical.diagnostic.port.CapteurPort;
import fr.softwaymedical.diagnostic.port.EcranPort;
import fr.softwaymedical.diagnostic.service.DiagnosticService;
import fr.softwaymedical.diagnostic.service.MessageEcranService;

@BusinessService
public class AutoDiagnosticUseCase {
    private final CapteurPort capteurPort;
    private final DiagnosticService diagnosticService;
    private final MessageEcranService messageEcranService;
    private final EcranPort ecranPort;

    public AutoDiagnosticUseCase(CapteurPort capteurPort, DiagnosticService diagnosticService, MessageEcranService messageEcranService, EcranPort ecranPort) {
        this.capteurPort = capteurPort;
        this.diagnosticService = diagnosticService;
        this.messageEcranService = messageEcranService;
        this.ecranPort = ecranPort;
    }

    public void evaluate() {
        IndexDeSante indexDeSante = capteurPort.measure();
        Diagnostic diagnostic = diagnosticService.diagnosis(indexDeSante);
        MessageEcran message = messageEcranService.format(diagnostic);
        ecranPort.display(message);
    }

}
