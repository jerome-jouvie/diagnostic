package fr.softwaymedical.diagnostic.remote;

import fr.softwaymedical.diagnostic.domain.IndexDeSante;
import fr.softwaymedical.diagnostic.port.CapteurPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Implementation simulant le capteur de mesure de l'index de santé
 * en attente de connexion avec la squad interoperabilité
 */
@Service
class CapteurRandomAdapterService implements CapteurPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(CapteurRandomAdapterService.class);

    private final Random random = new Random();

    @Override
    public IndexDeSante measure() {
        int value = random.nextInt(100);
        LOGGER.info("[CAPTEUR] {}", value);
        return new IndexDeSante(value);
    }
}
