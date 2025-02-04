package fr.softwaymedical.diagnostic.port;

import fr.softwaymedical.diagnostic.domain.IndexDeSante;

public interface CapteurPort {
    /**
     * @return la mesure du capteur de cabine "index de santé"
     */
    IndexDeSante measure();
}
