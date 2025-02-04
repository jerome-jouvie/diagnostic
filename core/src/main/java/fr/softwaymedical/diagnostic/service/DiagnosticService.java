package fr.softwaymedical.diagnostic.service;

import fr.softwaymedical.diagnostic.domain.Diagnostic;
import fr.softwaymedical.diagnostic.domain.IndexDeSante;

public interface DiagnosticService {

    /**
     * Diagnostic pour la redirection du patient vers l'unité médicale adaptée au sein de l'hôpital :
     */
    Diagnostic diagnosis(IndexDeSante indexDeSante);
}
