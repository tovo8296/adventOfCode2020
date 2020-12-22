package day22

import java.math.BigInteger
import java.util.*

val input = """
Player 1:
28
3
35
27
19
40
14
15
17
22
45
47
26
13
32
38
43
24
29
5
31
48
49
41
25

Player 2:
34
12
2
50
16
1
44
11
36
6
10
42
20
8
46
9
37
4
7
18
23
39
30
33
21
""".trimIndent()

val testInput = """
Player 1:
9
2
6
3
1

Player 2:
5
8
4
7
10
""".trimIndent()

val testInput2 = """
Player 1:
43
19

Player 2:
2
29
14
""".trimIndent()

var games = Array<Int>(1000, {0})
var rounds = 0L

fun main() {
    val (deck1, deck2) = parseCards(input)

    val player1Wins = playGame(deck1, deck2, 0)
    val winnerDeck = if (player1Wins) deck1 else deck2
    calculateScore(winnerDeck)
}

private fun playGame(deck1: MutableList<Int>, deck2: MutableList<Int>, recursiveDepth: Int): Boolean {
    games[recursiveDepth]++
    val gameString = deck1.toString() + deck2.toString()
//    if (previousGames.contains(gameString)) {
//        println("**  Player 1 wins for InstantExit.   Game: $gameString")
//        return true
//    }
//    println("******* Play recursive game at depth $recursiveDepth: $gameString")
//    previousGames.add(gameString)

    var previousStates = mutableSetOf<String>()
    var round = 0
    while (deck1.isNotEmpty() && deck2.isNotEmpty()) {
        round++
        val stateString = deck1.toString() + deck2.toString()
        if (previousStates.contains(stateString)) {
            return true.also {
                //                println("**  Player 1 wins for InstantExit")
            }
        }
        previousStates.add(stateString)

        val win1 = playRound(deck1, deck2, previousStates, recursiveDepth)
//        println("Round $round: Player ${if (win1) "1" else "2"} has won. Player 1 has ${deck1.size} cards, Player 2 has ${deck2.size} cards")
//        println("    Player 1 deck: $deck1")
//        println("    Player 2 deck: $deck2")
    }

    val player1Wins = deck1.isNotEmpty()
    return player1Wins.also {
        //        println("**   Player ${if (it) "1" else "2"} wins game $gameString.")
    }
}

fun calculateScore(deck: MutableList<Int>) {
    var score = BigInteger.ZERO
    var factor = 1
    deck.asReversed().forEach { card ->
        val product = factor.toBigInteger() * card.toBigInteger()
        score += product
        factor++
    }
    println("Winner score: $score")
}

fun playRound(deck1: MutableList<Int>, deck2: MutableList<Int>, previousStates: MutableSet<String>, recursiveDepth: Int): Boolean {
    rounds++
    var card1 = deck1.first()
    var card2 = deck2.first()
    deck1.removeAt(0)
    deck2.removeAt(0)
    require(card1 != card2)
    val winnerDeck: MutableList<Int>
    val winnerCard: Int
    val loserCard: Int
//    val player1Wins = card1 > card2
    val player1Wins = calculateRecursiveWinner(card1, deck1, card2, deck2, previousStates, recursiveDepth)
    if (player1Wins) {
        winnerDeck = deck1
        winnerCard = card1
        loserCard = card2
    } else {
        winnerDeck = deck2
        winnerCard = card2
        loserCard = card1
    }
    winnerDeck.add(winnerCard)
    winnerDeck.add(loserCard)
    return player1Wins
}

fun calculateRecursiveWinner(card1: Int, deck1: MutableList<Int>, card2: Int, deck2: MutableList<Int>, previousStates: MutableSet<String>, recursiveDepth: Int): Boolean {
    return if (deck1.size >= card1 && deck2.size >= card2) {
        val newDeck1 = LinkedList(deck1.subList(0, card1))
        val newDeck2 = LinkedList(deck2.subList(0, card2))
        playGame(newDeck1, newDeck2, recursiveDepth + 1).also {
            //            println("Player ${if (it) "1" else "2"} wins recursiveGame after state ${previousStates.size}")
        }
    } else {
        (card1 > card2)
    }
}

fun parseCards(input: String): Pair<MutableList<Int>, MutableList<Int>> {
    val deck1 = LinkedList<Int>()
    val deck2 = LinkedList<Int>()
    var player1Section = true
    input.lines().forEach { line ->
        if (line == "Player 1:") {
            player1Section = true
        } else if (line == "Player 2:") {
            player1Section = false
        } else if (line.trim().isEmpty()) {
            // ignore
        } else {
            val num = Integer.parseInt(line)
            val deck = if (player1Section) deck1 else deck2
            deck.add(num)
        }
    }
    return Pair(deck1, deck2).also {
        //        println("Player1: ${it.first.size} cards: ${it.first}")
//        println("Player2: ${it.second.size} cards: ${it.second}")
    }
}
