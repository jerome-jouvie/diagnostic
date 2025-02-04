package fr.softwaymedical.diagnostic.remote;

import fr.softwaymedical.diagnostic.domain.MessageEcran;
import fr.softwaymedical.diagnostic.port.EcranPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Implementation simulant l'écran de la cabine
 * en attente de connexion avec la squad interoperabilité
 */
@Service
class EcranLoggerAdapteurService implements EcranPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(EcranLoggerAdapteurService.class);

    @Override
    public void display(MessageEcran message) {
        LOGGER.info("[ECRAN] {}", message.content());
    }
}
