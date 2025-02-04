package fr.softwaymedical.diagnostic.service.impl;

import fr.softwaymedical.diagnostic.domain.Diagnostic;
import fr.softwaymedical.diagnostic.domain.MessageEcran;
import fr.softwaymedical.diagnostic.domain.Pathologie;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageEcranServiceImplTest {

    MessageEcranServiceImpl messageServiceImpl = new MessageEcranServiceImpl();

    static Stream<Arguments> dataset() {
        return Stream.of(
                Arguments.of(Set.of(), ""),
                Arguments.of(Set.of(Pathologie.PROBLEME_CARDIAQUE), "Cardiologie"),
                Arguments.of(Set.of(Pathologie.FRACTURE), "Traumatologie"),
                Arguments.of(Set.of(Pathologie.PROBLEME_CARDIAQUE, Pathologie.FRACTURE), "Cardiologie, Traumatologie")
        );
    }

    @MethodSource("dataset")
    @ParameterizedTest
    void diagnosisTest(Set<Pathologie> pathologies, String expected) {
        Diagnostic diagnostic = new Diagnostic(pathologies);

        MessageEcran actual = messageServiceImpl.format(diagnostic);

        assertEquals(new MessageEcran(expected), actual);
    }

}