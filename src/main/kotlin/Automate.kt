/**
 * @author : Guewen
 * La classe Automate permet de créer un automate, qui est un ensemble d'états et de transitions entre ces états.
 * La classe permet aussi de tester si un mot peut être lu par l'automate ou non
 * @param etatInitial est l'état initial de l'automate
 */
class Automate(etatInitial : Etat) {

    private var etatInitial : Etat
    private var chemin : MutableList<Etat> = mutableListOf(etatInitial)

    init {
        this.etatInitial = etatInitial
    }

    /**
     * La fonction testAutomate permet de tester si l'automate peut lire le mot donné
     * Cela signifie que l'automate vérifie si le mot suit l'ensemble des règles imposées pas l'automate
     * @param mot est le mot à tester
     * @return true si l'automate peut lire le mot, false sinon
     */
    fun testAutomate(mot : String){
        if (mot.isEmpty()){ // Si le mot est vide, on ne fait pas tourner l'automate
            println("Votre mot est vide !")
            return
        }
        var new_mot = mot // On crée une copie du mot afin de ne pas modifier le mot original tout en pouvant le parcourir
        var etatActuel = etatInitial // On initialise l'état actuel à l'état initial
        while (new_mot.isNotEmpty()) {
            val lettre = new_mot[0].toString() // On récupère la première lettre du mot
            new_mot = new_mot.substring(1) // On enlève la première lettre du mot à chaque itération afin de le parcourir dans son intégralité
            if (etatActuel.transition(lettre) == null) { // Si la lettre n'est pas dans la suite de l'état actuel, donc dans l'alphabet, on arrête l'automate
                println("Le mot $mot n'est pas accepté par l'automate, car la lettre $lettre n'est pas acceptée par l'automate")
                println("Le chemin parcouru est : ${lireChemins()}") // On affiche le chemin parcouru par l'automate
                println("L'état d'arrêt est : ${etatArret()}") // On affiche l'état d'arrêt de l'automate
                return
            }
            chemin.add(etatActuel) // On ajoute l'état actuel au chemin parcouru
        }
        if (etatActuel.etatFinal()){
            println("Le mot $mot est accepté par l'automate")
        } else {
            println("Le mot $mot n'est pas accepté par l'automate, car il ne s'arrête pas sur un état final")
        }
        println("Le chemin parcouru est : ${lireChemins()}") // On affiche le chemin parcouru par l'automate
        println("L'état d'arrêt est : ${etatArret()}") // On affiche l'état d'arrêt de l'automate
        return
    }

    /**
     * La fonction lireChemins permet de lire le chemin parcouru par l'automate
     */
    fun lireChemins() : String {
        var cheminString = ""
        for (etat in chemin) {
            cheminString += "$etat -> "
        }
        cheminString = cheminString.substring(0, cheminString.length - 4) // On retire la dernière flèche
        return cheminString
    }

    /**
     * La fonction etatArret permet de récupérer l'état d'arrêt de l'automate
     */
    fun etatArret() : String {
        return chemin.last().toString()
    }

    /**
     * Le companion object permet d'appeler l'automate de son choix plus facilement
     * Par exemple, si on souhaite appeler l'automate de l'exercice 1, il suffit d'appeler automate1("mot")
     * C'est un design pattern nommé "Factory"
     * @param mot est le mot à tester
     */
    companion object{

        /**
         * La fonction automate1 permet de créer l'automate de l'exercice 1
         * @param mot est le mot à tester
         */
        fun automate1(mot : String) {
            // On crée les états
            val e0 = Etat("e0", false) // On choisit l'état final de chaque état, avec False pour non final et True pour final
            val e1 = Etat("e1",false)
            val e2 = Etat("e2", true)
            val e3 = Etat("e3", false)
            val e4 = Etat("e4", true)

            //On ajoute les suites des états, c'est-à-dire "l'architecture du mot"
            //On s'occupe de l'état e0
            e0.ajouterSuite("a", e1) // L'état e0 peut lire la lettre a, qui fait passer l'automate à l'état e1

            //On s'occupe de l'état e1
            e1.ajouterSuite("b", e2) // L'état e1 peut lire la lettre b, qui fait passer l'automate à l'état e2
            e1.ajouterSuite("c", e3) // L'état e1 peut lire la lettre c, qui fait passer l'automate à l'état e3

            //On s'occupe de l'état e2
            e2.ajouterSuite("e", e1) // L'état e2 peut lire la lettre e, qui fait passer l'automate à l'état e1
            e2.ajouterSuite("c", e4) // L'état e2 peut lire la lettre c, qui fait passer l'automate à l'état e4

            //On s'occupe de l'état e3
            e3.ajouterSuite("b", e4) // L'état e3 peut lire la lettre b, qui fait passer l'automate à l'état e4

            //On s'occupe de l'état e4
            e4.ajouterSuite("d", e0) // L'état e4 peut lire la lettre d, qui fait passer l'automate à l'état e0
            e4.ajouterSuite("e", e3) // L'état e4 peut lire la lettre e, qui fait passer l'automate à l'état e3

            //On crée l'automate
            val automate = Automate(e0) // On choisit l'état initial de l'automate, qui ici est l'état e0
            val test = automate.testAutomate(mot) // On teste si l'automate peut lire le mot donné
        }

        /**
         * La fonction automate2 permet de créer l'automate de l'exercice 2
         * @param mot est le mot à tester
         */
        fun automate2(mot : String){
            // On crée les états
            val e1 = Etat("e1",false) // On choisit l'état final de chaque état, avec False pour non final et True pour final
            val e2 = Etat("e2",false)
            val e3 = Etat("e3",true)

            //On ajoute les suites des états, c'est-à-dire "l'architecture du mot"
            //On s'occupe de l'état e1
            e1.ajouterSuite("a", e2) // L'état e1 peut lire la lettre a, qui fait passer l'automate à l'état e2
            e1.ajouterSuite("c", e3) // L'état e1 peut lire la lettre c, qui fait passer l'automate à l'état e3

            //On s'occupe de l'état e2
            e2.ajouterSuite("b", e1) // L'état e2 peut lire la lettre b, qui fait passer l'automate à l'état e1

            //On s'occupe de l'état e3
            e3.ajouterSuite("a", e2) // L'état e3 peut lire la lettre a, qui fait passer l'automate à l'état e2
            e3.ajouterSuite("b", e3) // L'état e3 peut lire la lettre b, qui fait passer l'automate à l'état e3
            e3.ajouterSuite("c", e3) // L'état e3 peut lire la lettre c, qui fait passer l'automate à l'état e3

            //On crée l'automate
            val automate = Automate(e1) // On choisit l'état initial de l'automate, qui ici est l'état e1
            val test = automate.testAutomate(mot) // On teste si l'automate peut lire le mot donné
        }

        /**
         * La fonction automate3 permet de créer l'automate de l'exercice 3, c'est-à-dire un automate qui reconnait certains smileys
         * @param mot est le mot à tester
         */
        fun automate3(mot : String) {
            // On crée les états
            val e1 = Etat("e1",false) // On choisit l'état final de chaque état, avec False pour non final et True pour final
            val e2 = Etat("e2",false)
            val e3 = Etat("e3",false)
            val e4 = Etat("e4",true)
            val e5 = Etat("e5",false)

            //On ajoute les suites des états, c'est-à-dire "l'architecture du mot"
            //On s'occupe de l'état e1
            e1.ajouterSuite(":", e2) // L'état e1 peut lire le caractère :, qui fait passer l'automate à l'état e2
            e1.ajouterSuite(";", e5) // L'état e1 peut lire le caractère ;, qui fait passer l'automate à l'état e5
            e1.ajouterSuite("]", e5) // L'état e1 peut lire le caractère ], qui fait passer l'automate à l'état e5

            //On s'occupe de l'état e2
            e2.ajouterSuite("=", e3) // L'état e2 peut lire le caractère =, qui fait passer l'automate à l'état e3
            e2.ajouterSuite("-", e3) // L'état e2 peut lire le caractère -, qui fait passer l'automate à l'état e3
            e2.ajouterSuite(")", e4) // L'état e2 peut lire la lettre ), qui fait passer l'automate à l'état e4
            e2.ajouterSuite("(", e4) // L'état e2 peut lire la lettre (, qui fait passer l'automate à l'état e4

            //On s'occupe de l'état e3
            e3.ajouterSuite(")", e4) // L'état e3 peut lire le caractère ), qui fait passer l'automate à l'état e4

            //On s'occupe de l'état e5
            e5.ajouterSuite("-", e3) // L'état e5 peut lire le caractère -, qui fait passer l'automate à l'état e3

            //On crée l'automate
            val automate = Automate(e1) // On choisit l'état initial de l'automate, qui ici est l'état e1
            val test = automate.testAutomate(mot) // On teste si l'automate peut lire le mot donné
        }

        /**
         * La fonction automate4 permet de créer l'automate de l'exercice 4_1, c'est-à-dire l'automate qui reconnait les entiers pairs non nuls
         * @param mot est le mot à tester
         */
        fun automate4_1(mot : String){
            //On crée les états
            val e0 = Etat("e0",false) // On choisit l'état final de chaque état, avec False pour non final et True pour final
            val e1 = Etat("e1",false)
            val e2 = Etat("e2",true)

            //On ajoute les suites des états, c'est-à-dire "l'architecture du mot"
            //On s'occupe de l'état e0
            e0.ajouterSuite("0", e0) // L'état e0 peut lire le caractère 0, qui fait passer l'automate à l'état e0
            e0.ajouterSuite("1", e1) // L'état e0 peut lire le caractère 1, qui fait passer l'automate à l'état e1

            //On s'occupe de l'état e1
            e1.ajouterSuite("0", e2) // L'état e1 peut lire le caractère 0, qui fait passer l'automate à l'état e2
            e1.ajouterSuite("1", e1) // L'état e1 peut lire le caractère 1, qui fait passer l'automate à l'état e1

            //On s'occupe de l'état e2
            e2.ajouterSuite("0", e2) // L'état e2 peut lire le caractère 0, qui fait passer l'automate à l'état e2
            e2.ajouterSuite("1", e1) // L'état e2 peut lire le caractère 1, qui fait passer l'automate à l'état e1

            //On crée l'automate
            val automate = Automate(e0) // On choisit l'état initial de l'automate, qui ici est l'état e0
            val test = automate.testAutomate(mot) // On teste si l'automate peut lire le mot donné
        }

        /**
         * La fonction automate4_2 permet de créer l'automate de l'exercice 4_2, c'est-à-dire l'automate qui reconnait les entiers impairs
         * @param mot est le mot à tester
         */
        fun automate4_2(mot : String){
            //On crée les états
            val e0 = Etat("e0",false) // On choisit l'état final de chaque état, avec False pour non final et True pour final
            val e1 = Etat("e1",true)

            //On ajoute les suites des états, c'est-à-dire "l'architecture du mot"
            //On s'occupe de l'état e0
            e0.ajouterSuite("0", e0) // L'état e0 peut lire le caractère 0, qui fait passer l'automate à l'état e0
            e0.ajouterSuite("1", e1) // L'état e0 peut lire le caractère 1, qui fait passer l'automate à l'état e1

            //On s'occupe de l'état e1
            e1.ajouterSuite("0", e0) // L'état e1 peut lire le caractère 0, qui fait passer l'automate à l'état e0
            e1.ajouterSuite("1", e1) // L'état e1 peut lire le caractère 1, qui fait passer l'automate à l'état e1

            //On crée l'automate
            val automate = Automate(e0) // On choisit l'état initial de l'automate, qui ici est l'état e0
            val test = automate.testAutomate(mot) // On teste si l'automate peut lire le mot donné
            
        }

        /**
         * La fonction automate5 permet de créer l'automate de l'exercice 5, c'est-à-dire l'automate qui reconnait les heures de la forme hh:mm
         * @param mot est le mot à tester
         */
        fun automate5(mot : String){
            //On crée les états
            val e0 = Etat("e0",false) // On choisit l'état final de chaque état, avec False pour non final et True pour final
            val h1 = Etat("h1",false)
            val h2 = Etat("h2",false)
            val h = Etat("h",false)
            val m1 = Etat("m1",false)
            val m2 = Etat("m2",false)
            val m = Etat("m",true)

            //On ajoute les suites des états, c'est-à-dire "l'architecture du mot"
            //On s'occupe de l'état e0
            e0.ajouterSuites(listOf("0", "1"), h1) // L'état e0 peut lire les caractères 0 et 1, qui fait passer l'automate à l'état h1
            e0.ajouterSuite("2", h2) // L'état e0 peut lire le caractère 2, qui fait passer l'automate à l'état h2

            //On s'occupe de l'état h1
            h1.ajouterSuites(listOf("0", "1", "2", "3", "4","5", "6", "7", "8", "9"), h) // L'état h1 peut lire les chiffres allant de 0 à 9, qui fait passer l'automate à l'état h

            //On s'occupe de l'état h2
            h2.ajouterSuites(listOf("0", "1", "2", "3"), h) // L'état h2 peut lire les chiffres allant de 0 à 3, qui fait passer l'automate à l'état h

            //On s'occupe de l'état h
            h.ajouterSuite(":", m1) // L'état h peut lire le caractère :, qui fait passer l'automate à l'état m1

            //On s'occupe de l'état m1
            m1.ajouterSuites(listOf("0", "1", "2", "3", "4","5"), m2) // L'état m1 peut lire les chiffres allant de 0 à 5, qui fait passer l'automate à l'état m2

            //On s'occupe de l'état m2
            m2.ajouterSuites(listOf("0", "1", "2", "3", "4","5", "6", "7", "8", "9"), m) // L'état m2 peut lire les chiffres allant de 0 à 9, qui fait passer l'automate à l'état m

            //On crée l'automate
            val automate = Automate(e0) // On choisit l'état initial de l'automate, qui ici est l'état e0
            val test = automate.testAutomate(mot) // On teste si l'automate peut lire le mot donné
        }

        /**
         * La fonction automate6_1 permet de créer l'automate de l'exercice 6, c'est-à-dire l'automate qui reconnait les nombres multiples de 3
         * @param mot est le mot à tester
         */
        fun automate6_1(mot : String){
            //On crée les états
            val e0 = Etat("e0",false)
            val e1 = Etat("e1",false)
            val e2 = Etat("e2",false)
            val e3 = Etat("e3",true)

            //On ajoute les suites des états, c'est-à-dire "l'architecture du mot"
            //On s'occupe de l'état e0
            e0.ajouterSuites(listOf("0", "3", "6", "9"), e3) // L'état e0 peut lire les chiffres 0, 3, 6 et 9, qui font passer l'automate à l'état e3
            e0.ajouterSuites(listOf("1", "4", "7"), e1) // L'état e0 peut lire les chiffres 1, 4 et 7, qui font passer l'automate à l'état e1
            e0.ajouterSuites(listOf("2", "5", "8"), e2) // L'état e0 peut lire les chiffres 2, 5 et 8, qui font passer l'automate à l'état e2

            //On s'occupe de l'état e1
            e1.ajouterSuites(listOf("0", "3", "6", "9"), e1) // L'état e1 peut lire les chiffres 0, 3, 6 et 9, qui font passer l'automate à l'état e1
            e1.ajouterSuites(listOf("1", "4", "7"), e2) // L'état e1 peut lire les chiffres 1, 4 et 7, qui font passer l'automate à l'état e2
            e1.ajouterSuites(listOf("2", "5", "8"), e3) // L'état e1 peut lire les chiffres 2, 5 et 8, qui font passer l'automate à l'état e3

            //On s'occupe de l'état e2
            e2.ajouterSuites(listOf("0", "3", "6", "9"), e2) // L'état e2 peut lire les chiffres 0, 3, 6 et 9, qui font passer l'automate à l'état e2
            e2.ajouterSuites(listOf("1", "4", "7"), e3) // L'état e2 peut lire les chiffres 1, 4 et 7, qui font passer l'automate à l'état e3
            e2.ajouterSuites(listOf("2", "5", "8"), e1) // L'état e2 peut lire les chiffres 2, 5 et 8, qui font passer l'automate à l'état e1

            //On s'occupe de l'état e3
            e3.ajouterSuites(listOf("0", "3", "6", "9"), e3) // L'état e3 peut lire les chiffres 0, 3, 6 et 9, qui font passer l'automate à l'état e3
            e3.ajouterSuites(listOf("1", "4", "7"), e1) // L'état e3 peut lire les chiffres 1, 4 et 7, qui font passer l'automate à l'état e1
            e3.ajouterSuites(listOf("2", "5", "8"), e2) // L'état e3 peut lire les chiffres 2, 5 et 8, qui font passer l'automate à l'état e2

            //On crée l'automate
            val automate = Automate(e0) // On choisit l'état initial de l'automate, qui ici est l'état e0
            val test = automate.testAutomate(mot) // On teste si l'automate peut lire le mot donné

        }

        /**
         * La fonction automate6_2 permet de créer l'automate de l'exercice 6, c'est-à-dire l'automate qui reconnait les nombres multiples de 100
         * @param mot est le mot à tester
         */
        fun automate6_2(mot : String){
            //On crée les états
            val e0  = Etat("e0",false)
            val e1  = Etat("e1",false)
            val e2  = Etat("e2",true)

            //On ajoute les suites des états, c'est-à-dire "l'architecture du mot"
            //On s'occupe de l'état e0
            e0.ajouterSuites(listOf("1", "2", "3", "4","5", "6", "7", "8", "9"), e0) // L'état e0 peut lire les chiffres allant de 1 à 9, qui font passer l'automate à l'état e0
            e0.ajouterSuites(listOf("0"), e1) // L'état e0 peut lire le chiffre 0, qui fait passer l'automate à l'état e1

            //On s'occupe de l'état e1
            e1.ajouterSuites(listOf("1", "2", "3", "4","5", "6", "7", "8", "9"), e0) // L'état e1 peut lire les chiffres allant de 1 à 9, qui font passer l'automate à l'état e0
            e1.ajouterSuites(listOf("0"), e2) // L'état e1 peut lire le chiffre 0, qui fait passer l'automate à l'état e2

            //On s'occupe de l'état e2
            e2.ajouterSuites(listOf("1", "2", "3", "4","5", "6", "7", "8", "9"), e0) // L'état e2 peut lire les chiffres allant de 1 à 9, qui font passer l'automate à l'état e0
            e2.ajouterSuites(listOf("0"), e2) // L'état e2 peut lire le chiffre 0, qui fait passer l'automate à l'état e2

            //On crée l'automate
            val automate = Automate(e0) // On choisit l'état initial de l'automate, qui ici est l'état e0
            val test = automate.testAutomate(mot) // On teste si l'automate peut lire le mot donné
        }

    }

}