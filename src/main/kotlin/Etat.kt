/**
 * @author : Guewen
 * La classe Etat permet de créer un objet qui représente un état d'un automate
 * Un Etat connait ses transitions possibles, c'est-à-dire les arcs de l'automate et s'il est final ou non
 * @param estFinal : Boolean
 */
class Etat(estFinal : Boolean) {
    /**
     * Suite est un dictionnaire qui associe un caractère à un état
     * Cela signifie que si on est dans l'état courant et qu'on reçoit le caractère associé à un état,
     * on passe à l'état associé
     */
    private var suite : MutableMap<String, Etat> = mutableMapOf()
    private var estFinal : Boolean

    init {
        this.estFinal = estFinal
    }

    /**
     * La fonction etatFinal permet de savoir si l'état est final ou non
     * @return Boolean
     */
    fun etatFinal() : Boolean {
        return this.estFinal
    }

    /**
     * La fonction ajouterSuite permet d'ajouter une transition à l'état courant
     * @param lettre : String
     * @param etat : Etat
     */
    fun ajouterSuite(lettre : String, etat : Etat) {
        val check = this.suite[lettre]
        if (check != null) {
            throw Exception("La lettre $lettre mène déjà à un autre état")
        }
        this.suite[lettre] = etat
    }

    /**
     * La fonction ajouterSuites permet d'ajouter plusieurs transitions à l'état courant, toutes menant au même état
     * @param lettres : List<String>
     * @param etat : Etat
     */
    fun ajouterSuites(lettres : List<String>, etat : Etat) {
        for (lettre in lettres) {
            this.ajouterSuite(lettre, etat)
        }
    }

    /**
     * La fonction transition permet de savoir si l'état courant peut passer à un autre état en fonction d'une lettre
     * @param lettre : String
     * @return Etat?
     */
    fun transition(lettre : String) : Etat? {
        return this.suite[lettre] // On retourne l'état associé à la lettre, qui peut être null
    }

}