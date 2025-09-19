package org.example

import org.example.dresseur.Entraineur
import org.example.monde.EspeceMonstre
import org.example.monde.Zone
import org.example.monstre.IndividuMonstre

/**Exemple d'utilisation de la fonction afficheArt */

val especeX = EspeceMonstre(1,
    "Springleaf",
    "Graine",
    9,
    11,
    10,
    12,
    14,
    60,
    6.5,
    9.0,
    8.0,
    7.0,
    10.0,
    34.0,
    "Petit monstre espiègle rond comme une graine, adore le soleil.",
    "Sa feuille sur la tête indique son humeur.",
    "Curieux, amical, timide")
val flamkip = EspeceMonstre(
    4,
    "Flamkip",
    "Animal",
    50,
    12,
    8,
    13,
    16,
    7,
    22.0,
    10.0,
    5.5,
    9.5,
    9.5,
    6.5,
    "Petit animal entouré de flammes, déteste le froid.",
    "Sa flamme change d’intensité selon son énergie",
    "Impulsif, joueur, loyal"
)
val aquamy = EspeceMonstre(
    7,
    "Aquamy",
    "Meteo",
    55,
    10,
    11,
    9,
    14,
    14,
    27.0,
    9.0,
    10.0,
    7.5,
    12.0,
    12.0,
    "Créature vaporeuse semblable à un nuage, produit des gouttes pures.",
    "Fait baisser la température en s’endormant.",
    "Calme, rêveur, mystérieux"
)
val route1 = Zone(1,
    "Zone1",
    0,
)
val route2 = Zone(2,
    "Zone1",
    5,
)
val route3 = Zone(3,
    "Zone3",
    10,
)
val monstre1 = IndividuMonstre(1, "springleaf", especeX,null,1500.0, )
val monstre2 = IndividuMonstre(2, "flamkip", flamkip,null,1500.0, )
val monstre3 = IndividuMonstre(3, "aquamy", aquamy,null,1500.0, )

//Creation d'un objet monstre
fun main() {
    monstre1.pv = 100

    }