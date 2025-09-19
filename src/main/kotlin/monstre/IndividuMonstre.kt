package org.example.monstre

import org.example.dresseur.Entraineur
import org.example.monde.EspeceMonstre
import kotlin.random.Random
import kotlin.math.pow

/**
 * Représente un individu monstre spécifique dans le jeu, appartenant à une espèce donnée.
 * Un individu monstre possède ses propres caractéristiques et statistiques,
 * qui peuvent varier légèrement en fonction de son espèce et de son potentiel.
 *
 * @property id Identifiant unique de l'individu monstre.
 * @property nom Nom attribué à l'individu monstre.
 * @property espece Espèce de l'individu monstre, définie par un objet de type EspeceMonstre.
 * @property entraineur Entraîneur actuel de l'individu monstre, ou null si le monstre n'a pas d'entraîneur.
 * @property niveau Niveau actuel de l'individu monstre, qui influence ses performances globales.
 * @property attaque Statistique d'attaque physique, calculée sur la base de l'espèce et d'une variation aléatoire.
 * @property defense Statistique de défense physique, calculée sur la base de l'espèce et d'une variation aléatoire.
 * @property vitesse Statistique de vitesse, calculée sur la base de l'espèce et d'une variation aléatoire.
 * @property attaqueSpe Statistique d'attaque spéciale, calculée sur la base de l'espèce et d'une variation aléatoire.
 * @property defenseSpe Statistique de défense spéciale, calculée sur la base de l'espèce et d'une variation aléatoire.
 * @property pvMax Points de vie maximaux de l'individu, basés sur l'espèce et d'une variation aléatoire.
 * @property potentiel Potentiel unique de l'individu, influençant ses performances et calculé comme un ratio aléatoire.
 * @property exp Expérience actuelle de l'individu, utilisée pour déterminer les augmentations de niveau.
 * La modification directe de cette propriété n'est pas autorisée (setter privé).
 * @property pv Points de vie actuels de l'individu. Cette valeur est toujours comprise entre 0 et pvMax inclus.
 * Lors de l'attribution d'une nouvelle valeur, celle-ci est automatiquement ajustée pour rester dans les limites valides.
 */

class IndividuMonstre (
    val id : Int,
    var nom : String,
    val espece : EspeceMonstre,
    val entraineur : Entraineur? = null,
    expInit : Double
){
    var niveau: Int = 1

    var attaque: Int = this.espece.baseAttaque + (-2..2).random()
    var defense: Int = this.espece.baseDefense + (-2..2).random()
    var vitesse: Int = this.espece.baseVitesse + (-2..2).random()
    var attaqueSpe: Int = this.espece.baseAttaqueSpe + (-2..2).random()
    var defenseSpe: Int = this.espece.baseDefenseSpe + (-2..2).random()

    var pvMax: Int = this.espece.basePv + (-5..5).random()
    var potentiel: Double = Random.nextDouble(0.5, 2.1)

    var exp: Double = 0.0
        get() = field
        set(value){
            field = value

            // Vérifier si on est au niveau 1
            val estNiveau1 = (niveau == 1)

            // Boucle tant que l'expérience dépasse le palier pour monter de niveau
            while (field >= palierExp(niveau)) {
                levelUp()
                // Si on est plus au niveau 1, afficher le message
                if (!estNiveau1) {
                    println("Le monstre $nom est maintenant niveau $niveau !")
                }
            }
        }
    init {
        this.exp = expInit
    }

    var pv: Int = pvMax
        get() = field
        set(nouveauPv) {
            field -= nouveauPv
            if (field < 0) field = 0
            if (field > pvMax) field = pvMax
        }
    /**
     * Calcule l'expérience totale nécessaire pour atteindre un niveau donné.
     *
     * @param niveau Niveau cible.
     * @return Expérience cumulée nécessaire pour atteindre ce niveau.
     */

    fun palierExp(niveau : Int): Double {
        return 100 * (niveau - 1).toDouble().pow(2.0)
    }

    /**
     * Augmente le niveau du monstre en modifiant ses statistiques et ses points de vie.
     *
     * Cette méthode effectue plusieurs actions :
     * 1. Incrémente le niveau du monstre.
     * 2. Calcule l'augmentation de chaque statistique en fonction des modificateurs attribués à l'espèce,
     *    du potentiel individuel du monstre, et d'un facteur de variation aléatoire.
     * 3. Met à jour les points de vie maximum (pvMax) en appliquant une logique similaire.
     * 4. Ajuste les points de vie actuels pour refléter le gain en pvMax, tout en s'assurant qu'ils
     *    ne dépassent pas la nouvelle valeur de pvMax.
     */
    fun levelUp() {
        // 1. Incrémenter le niveau
        niveau++

        // 2. Sauvegarder l'ancien pvMax pour calcul du gain
        val ancienPvMax = pvMax

        // 3. Mise à jour des stats
        attaque += (espece.modAttaque * potentiel).toInt() + (-2..2).random()
        defense += (espece.modDefense * potentiel).toInt() + (-2..2).random()
        vitesse += (espece.modVitesse * potentiel).toInt() + (-2..2).random()
        attaqueSpe += (espece.modAttaqueSpe * potentiel).toInt() + (-2..2).random()
        defenseSpe += (espece.modDefenseSpe * potentiel).toInt() + (-2..2).random()
        pvMax += (espece.modPv * potentiel).toInt() + (-5..5).random()

        // 4. Augmenter les PV actuels du gain de pvMax
        val gainPv = pvMax - ancienPvMax
        pv += gainPv
        if (pv > pvMax) pv = pvMax // sécurité
    }
    /**
     * Attaque un autre [IndividuMonstre] et inflige des dégâts.
     *
     * Les dégâts sont calculés de manière très simple pour le moment :
     * `dégâts = attaque - (défense / 2)` (minimum 1 dégât).
     *
     * @param cible Monstre cible de l'attaque.
     */


}