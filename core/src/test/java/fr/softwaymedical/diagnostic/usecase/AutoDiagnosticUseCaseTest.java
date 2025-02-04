package fr.softwaymedical.diagnostic.usecase;

import fr.softwaymedical.diagnostic.domain.Diagnostic;
import fr.softwaymedical.diagnostic.domain.IndexDeSante;
import fr.softwaymedical.diagnostic.domain.MessageEcran;
import fr.softwaymedical.diagnostic.port.CapteurPort;
import fr.softwaymedical.diagnostic.port.EcranPort;
import fr.softwaymedical.diagnostic.service.DiagnosticService;
import fr.softwaymedical.diagnostic.service.MessageEcranService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AutoDiagnosticUseCaseTest {

    @Mock
    private CapteurPort capteurPort;

    @Mock
    private DiagnosticService diagnosticService;

    @Mock
    private MessageEcranService messageEcranService;

    @Mock
    private EcranPort ecranPort;

    @InjectMocks
    AutoDiagnosticUseCase autoDiagnosticUseCase;

    @Test
    void evaluateTest() {
        IndexDeSante indexDeSante = mock(IndexDeSante.class);
        Diagnostic diagnostic = mock(Diagnostic.class);
        MessageEcran message = mock(MessageEcran.class);

        when(capteurPort.measure()).thenReturn(indexDeSante);
        when(diagnosticService.diagnosis(indexDeSante)).thenReturn(diagnostic);
        when(messageEcranService.format(diagnostic)).thenReturn(message);

        autoDiagnosticUseCase.evaluate();

        verify(capteurPort).measure();
        verify(diagnosticService).diagnosis(indexDeSante);
        verify(messageEcranService).format(diagnostic);
        verify(ecranPort).display(message);
        verifyNoMoreInteractions(capteurPort, diagnostic, message, ecranPort);
    }
}
