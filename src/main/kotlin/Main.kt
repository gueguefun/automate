fun main() {/**
    val smileys = listOf(":)", ":-)", ":(", ";-)", ":=)", "]-)", ":=(")
    for (smiley in smileys) {
        Automate.automate3(smiley)
    }*/
    fun clearConsoleAndReturnInput(): String? {
        val input = readLine()
        print("\u001b[H\u001b[2J") // Commande pour effacer le terminal, mais ne fonctionne pas dans tous les terminaux
        return input
    }
    val red = "\u001B[31m"
    val yellow = "\u001B[33m"
    val green = "\u001B[32m"
    val pink = "\u001B[35m"
    val blue = "\u001B[34m"
    val reset = "\u001B[0m"
    println("$green--------------------------------------------------------------------------------")
    println("$red Choississez un automate en tapant son numéro :")
    println("$blue 1.$pink Automate de l'exercice 1")
    println("$blue 2.$pink Automate de l'exercice 2")
    println("$blue 3.$pink Automate de l'exercice 3 $yellow(smileys)")
    println("$blue 4.$pink Automate de l'exercice 4.1$yellow (nombre entier pair non nul en binaire)")
    println("$blue 5.$pink Automate de l'exercice 4.2$yellow (nombre entier impair en binaire)")
    println("$blue 6.$pink Automate de l'exercice 5$yellow (format heure minute hh:mm)")
    println("$blue 7.$pink Automate de l'exercice 6.1$yellow (multiples de 3)")
    println("$blue 8.$pink Automate de l'exercice 6.2$yellow (multiples de 100)")
    println("$green--------------------------------------------------------------------------------$reset")
    val num = clearConsoleAndReturnInput()
    when (num) {
        "1" -> {
            println("$green--------------------------------------------------------------------------------")
            println("$red Entrez une chaîne de caractères :")
            println("$green--------------------------------------------------------------------------------$reset")
            val input = clearConsoleAndReturnInput()
            if (input != null) {
                Automate.automate1(input)
            }
        }
        "2" -> {
            println("$green--------------------------------------------------------------------------------")
            println("$red Entrez une chaîne de caractères :")
            println("$green--------------------------------------------------------------------------------$reset")
            val input = clearConsoleAndReturnInput()
            if (input != null) {
                Automate.automate2(input)
            }
        }
        "3" -> {
            println("$green--------------------------------------------------------------------------------")
            println("$red Entrez une chaîne de caractères :")
            println("$green--------------------------------------------------------------------------------$reset")
            val input = clearConsoleAndReturnInput()
            if (input != null) {
                Automate.automate3(input)
            }
        }
        "4" -> {
            println("$green--------------------------------------------------------------------------------")
            println("$red Entrez une chaîne de caractères :")
            println("$green--------------------------------------------------------------------------------$reset")
            val input = clearConsoleAndReturnInput()
            if (input != null) {
                Automate.automate4_1(input)
            }
        }
        "5" -> {
            println("$green--------------------------------------------------------------------------------")
            println("$red Entrez une chaîne de caractères :")
            println("$green--------------------------------------------------------------------------------$reset")
            val input = clearConsoleAndReturnInput()
            if (input != null) {
                Automate.automate4_2(input)
            }
        }
        "6" -> {
            println("$green--------------------------------------------------------------------------------")
            println("$red Entrez une chaîne de caractères :")
            println("$green--------------------------------------------------------------------------------$reset")
            val input = clearConsoleAndReturnInput()
            if (input != null) {
                Automate.automate5(input)
            }
        }
        "7" -> {
            println("$green--------------------------------------------------------------------------------")
            println("$red Entrez une chaîne de caractères :")
            println("$green--------------------------------------------------------------------------------$reset")
            val input = clearConsoleAndReturnInput()
            if (input != null) {
                Automate.automate6_1(input)
            }
        }
        "8" -> {
            println("$green--------------------------------------------------------------------------------")
            println("$red Entrez une chaîne de caractères :")
            println("$green--------------------------------------------------------------------------------$reset")
            val input = clearConsoleAndReturnInput()
            if (input != null) {
                Automate.automate6_2(input)
            }
        } else -> {
            println("$green--------------------------------------------------------------------------------")
            println("$red Veuillez entrer un numéro valide")
            println("$green--------------------------------------------------------------------------------$reset")
        }
    }
}