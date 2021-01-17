package com.company.business;

import java.util.Date;

public interface ReportGenerator {

    /**
     * Retourne le prix d'ouverture de la plage de date séléctionnée
     * @return
     */
    float getOpenPrice();

    /**
     * Défini le prix d'ouverture de la plage de date séléctionnée
     * @param openPrice
     */
    void setOpenPrice(float openPrice);

    /**
     * Retourne le prix de fermeture de la plage de date séléctionnée
     * @return
     */
    float getClosePrice();

    /**
     * Défini le prix de fermeture de la plage de date séléctionnée
     * @param closePrice
     */
    void setClosePrice(float closePrice);

    /**
     * Retourne le prix le plus haut de la plage de date séléctionnée
     * @return
     */
    float getHighestPrice();

    /**
     * Défini le prix le plus haut de la plage de date séléctionnée
     * @param highestPrice
     */
    void setHighestPrice(float highestPrice);

    /**
     * Retourne le prix le plus bas de la plage de date séléctionnée
     * @return
     */
    float getLowestPrice();

    /**
     * Défini le prix le plus bas de la plage de date séléctionnée
     * @param lowestPrice
     */
    void setLowestPrice(float lowestPrice);

    /**
     * Actionne les méthodes qui calculent le prix d'ouverture, de fermeture, le plus haut ainsi que le plus bas
     */
    void getReport();

    /**
     * Ajoute toutes les données reçues par l'API dans une structure de données choisi par l'utilisateur
     * @param date
     * @param volume
     * @param highestPrice
     * @param lowestPrice
     * @param openPrice
     * @param closePrice
     */
    void addGoodPrice(Date date, float volume, float highestPrice, float lowestPrice, float openPrice, float closePrice);
}
