package org.example.monstre

import org.example.dresseur.Entraineur
import org.example.monde.EspeceMonstre
import kotlin.random.Random

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
        private set

    var pv: Int = pvMax
        get() = field
        set(nouveauPv) {
            field = nouveauPv
            if (field < 0) field = 0
            if (field > pvMax) field = pvMax
            if (field - nouveauPv in 0..pvMax) field=nouveauPv
        }

}