package fr.softwaymedical.diagnostic.service;

import fr.softwaymedical.diagnostic.domain.Diagnostic;
import fr.softwaymedical.diagnostic.domain.MessageEcran;

public interface MessageEcranService {

    MessageEcran format(Diagnostic diagnostic);
}
