package org.example.monde

/**
 * Représente une zone dans le monde du jeu, avec des caractéristiques associées,
 * des monstres spécifiques et une connexion à une éventuelle zone suivante.
 *
 * @property id Identifiant unique de la zone.
 * @property nom Nom de la zone.
 * @property expZone Expérience associée à la zone.
 * @property especeMonstre Liste des espèces de monstres pouvant apparaître dans la zone.
 * @property zoneSuivante Référence à la zone suivante liée à cette zone, ou null si aucune.
 */
class Zone (
    var id : Int,
    var nom : String,
    var expZone: Int,
    var especeMonstre: MutableList<EspeceMonstre> = mutableListOf(),
    var zoneSuivante: Zone? = null,
    var zonePrecedante: Zone? = null
) {
    //TODO faire la méthode genereMonstre()
    //TODO faire la méthode rencontreMonstre()
}