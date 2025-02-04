package fr.softwaymedical.diagnostic.service.impl;

import fr.softwaymedical.diagnostic.annotation.BusinessService;
import fr.softwaymedical.diagnostic.domain.Diagnostic;
import fr.softwaymedical.diagnostic.domain.MessageEcran;
import fr.softwaymedical.diagnostic.domain.Pathologie;
import fr.softwaymedical.diagnostic.domain.UniteMedicale;
import fr.softwaymedical.diagnostic.service.MessageEcranService;

import java.util.Map;
import java.util.stream.Collectors;

@BusinessService
class MessageEcranServiceImpl implements MessageEcranService {

    // il serait pertinent d'externaliser dans une resource
    private static final Map<UniteMedicale, String> UNITE_MEDICALE_LABEL = Map.of(
            UniteMedicale.CARDIOLOGIE, "Cardiologie",
            UniteMedicale.TRAUMATOLOGIE, "Traumatologie");

    @Override
    public MessageEcran format(Diagnostic diagnostic) {
        String message = diagnostic.pathologies().stream()
                .map(Pathologie::getUniteMedicale)
                .map(UNITE_MEDICALE_LABEL::get)
                .sorted()
                .collect(Collectors.joining(", "));
        return new MessageEcran(message);
    }
}
