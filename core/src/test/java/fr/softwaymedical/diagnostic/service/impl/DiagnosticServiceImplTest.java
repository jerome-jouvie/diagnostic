package fr.softwaymedical.diagnostic.service.impl;

import fr.softwaymedical.diagnostic.domain.Diagnostic;
import fr.softwaymedical.diagnostic.domain.IndexDeSante;
import fr.softwaymedical.diagnostic.domain.Pathologie;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DiagnosticServiceImplTest {

    DiagnosticServiceImpl diagnosticServiceImpl = new DiagnosticServiceImpl();

    static Stream<Arguments> dataset() {
        return Stream.of(
                Arguments.of(0, Set.of()),
                Arguments.of(7, Set.of()),
                Arguments.of(33, Set.of(Pathologie.PROBLEME_CARDIAQUE)),
                Arguments.of(55, Set.of(Pathologie.FRACTURE)),
                Arguments.of(15, Set.of(Pathologie.PROBLEME_CARDIAQUE, Pathologie.FRACTURE))
        );
    }

    @MethodSource("dataset")
    @ParameterizedTest
    void diagnosisTest(int indexDeSanteValue, Set<Pathologie> expected) {
        IndexDeSante indexDeSante = new IndexDeSante(indexDeSanteValue);

        Diagnostic actual = diagnosticServiceImpl.diagnosis(indexDeSante);

        assertEquals(new Diagnostic(expected), actual);
    }

}