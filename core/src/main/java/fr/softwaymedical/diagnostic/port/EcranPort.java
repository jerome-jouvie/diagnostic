package fr.softwaymedical.diagnostic.port;

import fr.softwaymedical.diagnostic.domain.MessageEcran;

public interface EcranPort {

    /**
     * @param message chaîne de caractères pour affichage par l'écran
     */
    void display(MessageEcran message);
}
