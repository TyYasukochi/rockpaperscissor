package com.zybooks.rockpaperscissors

//implemented bonus 3

enum class Hands{ROCK, PAPER, SCISSORS}
enum class RoundResult {TIE, WIN, LOSS}

fun winres(){val randnum = (1..3).random()
    when(randnum) {
        1 -> print("You Won! Good Choice!\n")
        2 -> print("Wow You Are Lucky!\n")
        3 -> print("Great Read!\n")
        4 -> print("It's a Win!\n")
        5 -> print("You Win! Good Round!\n")
    }
}
fun lossres(){val randnum = (1..3).random()
    when(randnum) {
        1 -> print("You Lost Nice Try!\n")
        2 -> print("Unlucky!\n")
        3 -> print("Better Luck Next Time!\n")
        4 -> print("I'll Go Rock Next Time\n")
        5 -> print("Haha I win!\n")
    }
}
fun tieres() {
    val randnum = (1..3).random()
    when (randnum) {
        1 -> print("Almost!\n")
        2 -> print("Great Minds Think Alike!\n")
        3 -> print("It's a Tie!\n")
        4 -> print("Stop Copying Me!\n")
        5 -> print("Ditto!\n")
    }
}

    fun main() {
        println("Welcome to the Rock, Paper, Scissors simulator!")
        println("Player, what is your name?")
        val name = readln()
        Gameplayer(name)
    }

    class Gameplayer(var name: String) {
        var wins = 0
        var losses = 0
        var ties = 0

        init {
            var winLossRatio = 0.0
            println("Welcome, $name")
            println("How many rounds should we play?")
            var rounds = readln().toInt()

            repeat(rounds) {
                val playerhand = chooseHand()
                val computerhand = Game().rockPaperScissors()
                Game().getGameResult(playerhand, computerhand, this)
            }
            println("Thats it! GG! $rounds rounds played!\n Game stats for $name\n\n_____________________________")
            if (losses == 0) {
                winLossRatio = wins.toDouble()
            } else {
                winLossRatio = wins.toDouble() / losses.toDouble()
            }
            println("Wins: $wins \nLosses: $losses\nTies:$ties\nWin-Loss Ratio: $winLossRatio")
        }

        fun chooseHand(): Hands? {
            println("$name!, choose a hand! Rock, Paper, or Scissors? ('r', 'p', or 's')")
            val input = readln()
            return when (input) {
                "r" -> Hands.ROCK
                "p" -> Hands.PAPER
                "s" -> Hands.SCISSORS
                else -> {
                    println("Invalid input, Please choose 'r', 'p', or 's'")
                    null
                }
            }
        }

        class Game() {
            fun rockPaperScissors(): Hands {
                val randnum = (1..3).random()
                return when (randnum) {
                    1 -> Hands.ROCK
                    2 -> Hands.PAPER
                    3 -> Hands.SCISSORS
                    else ->
                        Hands.ROCK
                }
            }

            fun getGameResult(
                playerhand: Hands?,
                computerhand: Hands,
                user: Gameplayer
            ): RoundResult {
                println("$user.name throws a $playerhand!, the computer throws a $computerhand!")
                if (playerhand == computerhand) {
                    tieres()
                    user.ties++
                    return RoundResult.TIE

                } else {
                    when {
                        (playerhand == Hands.ROCK && computerhand == Hands.SCISSORS) ||
                                (playerhand == Hands.PAPER && computerhand == Hands.ROCK) ||
                                (playerhand == Hands.SCISSORS && computerhand == Hands.PAPER) -> {
                            winres()
                            user.wins++
                            return RoundResult.WIN
                        }

                        else -> {
                            lossres()
                            user.losses++
                            return RoundResult.LOSS
                        }
                    }
                }
            }
        }
    }




