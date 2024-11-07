package advent_of_code.day_01

import java.io.File

/**
 * My solution
 */
private fun solution1Simple(strings: List<String>): Int {
    var result = 0
    strings.forEach {
        var index = 0
        while (!it[index].isDigit()) {
            index++
        }
        result += it[index].digitToInt() * 10
        index = it.lastIndex
        while (!it[index].isDigit()) {
            index--
        }
        result += it[index].digitToInt()
    }
    return result
}

/**
 * Source: https://www.youtube.com/live/AoQw4t8Cb94?si=PelB-uLGVBzPBic8
 */
private fun solution1(strings: List<String>): Int {
    return strings.sumOf { str ->
        calibrationValue(str)
    }
}

private fun solution2(strings: List<String>): Int {
    val digitMap = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9,
    )
    return strings.sumOf { str ->
        calibrationValue(str.mapIndexedNotNull { index, char ->
            if (char.isDigit()) {
                char
            } else {
                str.possibleWordsAt(index).firstNotNullOfOrNull {
                    digitMap[it]
                }
            }
        }.joinToString())
    }
}

private fun calibrationValue(str: String): Int {
    val firstDigit = str.first { it.isDigit() }
    val lastDigit = str.last { it.isDigit() }
    return "${firstDigit}${lastDigit}".toInt()
}

private fun String.possibleWordsAt(startingAt: Int): List<String> {
    return (3..5).map {
        substring(startingAt, (startingAt + it).coerceAtMost(length))
    }
}

private fun main() {
    println(solution1(File("src/advent_of_code/day_1/input.txt").readLines())) // File removed
    println(solution2(File("src/advent_of_code/day_1/input.txt").readLines())) // File removed
}
