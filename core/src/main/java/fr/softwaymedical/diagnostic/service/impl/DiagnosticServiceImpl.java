package fr.softwaymedical.diagnostic.service.impl;

import fr.softwaymedical.diagnostic.annotation.BusinessService;
import fr.softwaymedical.diagnostic.domain.Diagnostic;
import fr.softwaymedical.diagnostic.domain.IndexDeSante;
import fr.softwaymedical.diagnostic.domain.Pathologie;
import fr.softwaymedical.diagnostic.service.DiagnosticService;

import java.util.HashSet;
import java.util.Set;

@BusinessService
class DiagnosticServiceImpl implements DiagnosticService {

    private static final int MULTIPLE_PROBLEME_CARDIQUE = 3;
    private static final int MULTIPLE_FRACTURE = 5;

    @Override
    public Diagnostic diagnosis(IndexDeSante indexDeSante) {
        Set<Pathologie> pathologies = new HashSet<>();
        if (isMultipleOf(indexDeSante.value(), MULTIPLE_PROBLEME_CARDIQUE)) {
            pathologies.add(Pathologie.PROBLEME_CARDIAQUE);
        }
        if (isMultipleOf(indexDeSante.value(), MULTIPLE_FRACTURE)) {
            pathologies.add(Pathologie.FRACTURE);
        }
        return new Diagnostic(Set.copyOf(pathologies));
    }

    private boolean isMultipleOf(int value, int multiple) {
        return value > 0 && value % multiple == 0;
    }

}
