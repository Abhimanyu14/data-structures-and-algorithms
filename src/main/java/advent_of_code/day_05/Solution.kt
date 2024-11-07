package advent_of_code.day_05

import java.io.File
import kotlin.math.pow

private data class Card(
    val number: Int,
    val winningNumbers: Set<Int>,
    val availableNumbers: List<Int>,
)

private fun solution1(cards: List<Card>): Int {
    return cards.sumOf { card ->
        (2.0).pow(
            card.availableNumbers.count { num ->
                card.winningNumbers.contains(num)
            } - 1
        ).toInt()
    }
}

private fun solution2(cards: List<Card>): Int {
    val result = IntArray(cards.size) { 1 }
    cards.forEachIndexed { index, card ->
        val times = card.availableNumbers.count { num ->
            card.winningNumbers.contains(num)
        }
        for (i in (index + 1)..(index + times)) {
            result[i] += result[index]
        }
    }
    return result.sum()
}

private fun getCards(lines: List<String>): List<Card> {
    return lines.map { line ->
        val cardSplit = line.split(":")
        val subSplits = line.split(":")[1].split("|")
        Card(
            number = cardSplit[0].filter { it.isDigit() }.toInt(),
            winningNumbers = subSplits[0].split(" ").mapNotNull {
                it.toIntOrNull()
            }.toSet(),
            availableNumbers = subSplits[1].split(" ").mapNotNull {
                it.toIntOrNull()
            }.toList(),
        )
    }
}

private fun main() {
    val lines1 = File("src/advent_of_code/day_04/input1.txt").readLines()
    val lines2 = File("src/advent_of_code/day_04/input.txt").readLines()
    println(solution1(getCards(lines1)))
    println(solution1(getCards(lines2)))
    println(solution2(getCards(lines1)))
    println(solution2(getCards(lines2)))
}
