package advent_of_code.day_03

import java.io.File

data class PartNumber(
    val value: Int,
    val gearPositions: List<Pair<Int, Int>>,
)

private fun Char.isSpecialChar() = !setOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.').contains(this)

private fun solution1(partNumbers: List<PartNumber>): Int {
    return partNumbers.sumOf {
        it.value
    }
}

private fun solution2(partNumbers: List<PartNumber>): Long {
    val gearMap = mutableMapOf<Pair<Int, Int>, MutableList<Int>>()
    partNumbers.forEach { partNumber ->
        partNumber.gearPositions.forEach { gearPositions ->
            gearMap.computeIfAbsent(gearPositions) {
                mutableListOf()
            }.add(partNumber.value)
        }
    }
    var result = 0L
    gearMap.forEach { (_, value) ->
        if (value.size == 2) {
            result += (value[0] * value[1])
        }
    }
    return result
}

private fun getPartNumbers(lines: List<String>): List<PartNumber> {
    val partNumbers = mutableListOf<PartNumber>()

    fun checkIfPartNumber(row: Int, col: Int, length: Int): Pair<Boolean, List<Pair<Int, Int>>> {
        var flag = false
        val gearsPos = mutableListOf<Pair<Int, Int>>()
        if (row > 0) {
            if (col > 0 && lines[row - 1][col - 1].isSpecialChar()) {
                flag = true
                if (lines[row - 1][col - 1] == '*') {
                    gearsPos.add(Pair(row - 1, col - 1))
                }
            }
            repeat(length) {
                if (lines[row - 1][col + it].isSpecialChar()) {
                    flag = true
                    if (lines[row - 1][col + it] == '*') {
                        gearsPos.add(Pair(row - 1, col + it))
                    }
                }
            }
            if (col + (length - 1) < lines[row - 1].lastIndex && lines[row - 1][col + (length - 1) + 1].isSpecialChar()) {
                flag = true
                if (lines[row - 1][col + (length - 1) + 1] == '*') {
                    gearsPos.add(Pair(row - 1, col + (length - 1) + 1))
                }
            }
        }
        if (col > 0 && lines[row][col - 1].isSpecialChar()) {
            flag = true
            if (lines[row][col - 1] == '*') {
                gearsPos.add(Pair(row, col - 1))
            }
        }
        if (col < lines[row].lastIndex && lines[row][col + (length - 1) + 1].isSpecialChar()) {
            flag = true
            if (lines[row][col + (length - 1) + 1] == '*') {
                gearsPos.add(Pair(row, col + (length - 1) + 1))
            }
        }
        if (row < lines.lastIndex) {
            if (col > 0 && lines[row + 1][col - 1].isSpecialChar()) {
                flag = true
                if (lines[row + 1][col - 1] == '*') {
                    gearsPos.add(Pair(row + 1, col - 1))
                }
            }
            repeat(length) {
                if (lines[row + 1][col + it].isSpecialChar()) {
                    flag = true
                    if (lines[row + 1][col + it] == '*') {
                        gearsPos.add(Pair(row + 1, col + it))
                    }
                }
            }
            if (col + (length - 1) < lines[row + 1].lastIndex && lines[row + 1][col + (length - 1) + 1].isSpecialChar()) {
                flag = true
                if (lines[row + 1][col + (length - 1) + 1] == '*') {
                    gearsPos.add(Pair(row + 1, col + (length - 1) + 1))
                }
            }
        }
        return Pair(flag, gearsPos)
    }

    lines.forEachIndexed { row, line ->
        var current = 0
        var startCol = -1

        line.forEachIndexed { col, char ->
            if (char.isDigit()) {
                if (startCol == -1) {
                    startCol = col
                }
                current = (current * 10) + char.digitToInt()
            } else {
                if (startCol != -1) {
                    val check = checkIfPartNumber(row, startCol, col - startCol)
                    if (check.first) {
                        partNumbers.add(PartNumber(current, check.second))
                    }
                }
                current = 0
                startCol = -1
            }
        }
        if (startCol != -1) {
            val check = checkIfPartNumber(row, startCol, line.lastIndex - startCol)
            if (check.first) {
                partNumbers.add(PartNumber(current, check.second))
            }
        }
    }
    return partNumbers
}

private fun main() {
    val lines1 = File("src/advent_of_code/day_03/input1.txt").readLines()
    val lines2 = File("src/advent_of_code/day_03/input.txt").readLines()
    println(solution1(getPartNumbers(lines1)))
    println(solution1(getPartNumbers(lines2)))
    println(solution2(getPartNumbers(lines1)))
    println(solution2(getPartNumbers(lines2)))
}
