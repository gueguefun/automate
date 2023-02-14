import Couleurs.*

class Appli() {

    private var num : String = ""

    fun clearConsoleAndReturnInput(): String? {
        val input = readLine()
        print("\u001b[H\u001b[2J") // Commande pour effacer le terminal, mais ne fonctionne pas dans tous les terminaux
        return input
    }

    fun mainMenu(){
        println("${VERT.code}--------------------------------------------------------------------------------")
        println("${ROUGE.code} Choississez un automate en tapant son numéro :")
        println("${BLEU.code} 1.${ROSE.code} Automate de l'exercice 1")
        println("${BLEU.code} 2.${ROSE.code} Automate de l'exercice 2")
        println("${BLEU.code} 3.${ROSE.code} Automate de l'exercice 3 ${JAUNE.code}(smileys)")
        println("${BLEU.code} 4.${ROSE.code} Automate de l'exercice 4.1${JAUNE.code} (nombre entier pair non nul en binaire)")
        println("${BLEU.code} 5.${ROSE.code} Automate de l'exercice 4.2${JAUNE.code} (nombre entier impair en binaire)")
        println("${BLEU.code} 6.${ROSE.code} Automate de l'exercice 5${JAUNE.code} (format heure minute hh:mm)")
        println("${BLEU.code} 7.${ROSE.code} Automate de l'exercice 6.1${JAUNE.code} (multiples de 3)")
        println("${BLEU.code} 8.${ROSE.code} Automate de l'exercice 6.2${JAUNE.code} (multiples de 100)")
        println("${BLEU.code} 0.${ROSE.code} Quitter l'application")
        println("${VERT.code}--------------------------------------------------------------------------------${RESET.code}")
        this.num = clearConsoleAndReturnInput()!!
        when(num) {
            "1" -> {
                return automate1()
            }
            "2" -> {
                return automate2()
            }
            "3" -> {
                return automate3()
            }
            "4" -> {
                return automate4()
            }
            "5" -> {
                return automate5()
            }
            "6" -> {
                return automate6()
            }
            "7" -> {
                return automate7()
            }
            "8" -> {
                return automate8()
            }
            "0" -> {
                println("${ROUGE.code} Au revoir !")
                return
            }
            else -> {
                println("${ROUGE.code} Veuillez entrer un numéro valide !")
                return mainMenu()
            }
        }
    }

    fun automate1(){
        println("${VERT.code}--------------------------------------------------------------------------------")
        println("${ROUGE.code} Entrez une chaîne de caractères :")
        println("${ROUGE.code} Tapez menu pour revenir au menu principal")
        println("${VERT.code}--------------------------------------------------------------------------------$RESET")
        val input = clearConsoleAndReturnInput()!!
        if (input == "menu") {
            return mainMenu()
        }
        Automate.automate1(input)
        return automate1()
    }

    fun automate2(){
        println("${VERT.code}--------------------------------------------------------------------------------")
        println("${ROUGE.code} Entrez une chaîne de caractères :")
        println("${ROUGE.code} Tapez menu pour revenir au menu principal")
        println("${VERT.code}--------------------------------------------------------------------------------$RESET")
        val input = clearConsoleAndReturnInput()!!
        if (input == "menu") {
            return mainMenu()
        }
        Automate.automate2(input)
        return automate2()
    }

    fun automate3(){
        println("${VERT.code}--------------------------------------------------------------------------------")
        println("${ROUGE.code} Entrez une chaîne de caractères :")
        println("${ROUGE.code} Tapez menu pour revenir au menu principal")
        println("${VERT.code}--------------------------------------------------------------------------------$RESET")
        val input = clearConsoleAndReturnInput()!!
        if (input == "menu") {
            return mainMenu()
        }
        Automate.automate3(input)
        return automate3()
    }

    fun automate4(){
        println("${VERT.code}--------------------------------------------------------------------------------")
        println("${ROUGE.code} Entrez une chaîne de caractères :")
        println("${ROUGE.code} Tapez menu pour revenir au menu principal")
        println("${VERT.code}--------------------------------------------------------------------------------$RESET")
        val input = clearConsoleAndReturnInput()!!
        if (input == "menu") {
            return mainMenu()
        }
        Automate.automate4_1(input)
        return automate4()
    }

    fun automate5(){
        println("${VERT.code}--------------------------------------------------------------------------------")
        println("${ROUGE.code} Entrez une chaîne de caractères :")
        println("${ROUGE.code} Tapez menu pour revenir au menu principal")
        println("${VERT.code}--------------------------------------------------------------------------------$RESET")
        val input = clearConsoleAndReturnInput()!!
        if (input == "menu") {
            return mainMenu()
        }
        Automate.automate4_2(input)
        return automate5()
    }

    fun automate6(){
        println("${VERT.code}--------------------------------------------------------------------------------")
        println("${ROUGE.code} Entrez une chaîne de caractères :")
        println("${ROUGE.code} Tapez menu pour revenir au menu principal")
        println("${VERT.code}--------------------------------------------------------------------------------$RESET")
        val input = clearConsoleAndReturnInput()!!
        if (input == "menu") {
            return mainMenu()
        }
        Automate.automate5(input)
        return automate6()
    }

    fun automate7(){
        println("${VERT.code}--------------------------------------------------------------------------------")
        println("${ROUGE.code} Entrez une chaîne de caractères :")
        println("${ROUGE.code} Tapez menu pour revenir au menu principal")
        println("${VERT.code}--------------------------------------------------------------------------------$RESET")
        val input = clearConsoleAndReturnInput()!!
        if (input == "menu") {
            return mainMenu()
        }
        Automate.automate6_1(input)
        return automate7()
    }

    fun automate8() {
        println("${VERT.code}--------------------------------------------------------------------------------")
        println("${ROUGE.code} Entrez une chaîne de caractères :")
        println("${ROUGE.code} Tapez menu pour revenir au menu principal")
        println("${VERT.code}--------------------------------------------------------------------------------$RESET")
        val input = clearConsoleAndReturnInput()!!
        if (input == "menu") {
            return mainMenu()
        }
        Automate.automate6_2(input)
        return automate8()
    }

}