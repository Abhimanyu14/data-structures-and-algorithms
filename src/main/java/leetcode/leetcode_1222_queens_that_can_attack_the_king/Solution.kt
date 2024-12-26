package leetcode.leetcode_1222_queens_that_can_attack_the_king

/**
 * leetcode - https://leetcode.com/problems/queens-that-can-attack-the-king/
 *
 * Data Structure - NA
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 15 ms, faster than 100.00%
 * Memory Usage: 39.3 MB, less than 75.00%
 *
 * Time -
 * Space -
 */
private fun queensAttacktheKing(queens: Array<IntArray>, king: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val queensGrid = Array(8) { BooleanArray(8) }
    for (queen in queens) {
        queensGrid[queen[0]][queen[1]] = true
    }
    var currentX = king[0]
    var currentY = king[1]

    fun isQueenAtCurrentPosition(): Boolean {
        if (queensGrid[currentX][currentY]) {
            result.add(listOf(currentX, currentY))
            return true
        }
        return false
    }

    fun resetCurrentPosition() {
        currentX = king[0]
        currentY = king[1]
    }

    while (currentX > 0) {
        currentX--
        if (isQueenAtCurrentPosition()) break
    }
    resetCurrentPosition()
    while (currentX < 7) {
        currentX++
        if (isQueenAtCurrentPosition()) break
    }
    resetCurrentPosition()
    while (currentY > 0) {
        currentY--
        if (isQueenAtCurrentPosition()) break
    }
    resetCurrentPosition()
    while (currentY < 7) {
        currentY++
        if (isQueenAtCurrentPosition()) break
    }
    resetCurrentPosition()
    while (currentX < 7 && currentY < 7) {
        currentX++
        currentY++
        if (isQueenAtCurrentPosition()) break
    }
    resetCurrentPosition()
    while (currentX > 0 && currentY > 0) {
        currentX--
        currentY--
        if (isQueenAtCurrentPosition()) break
    }
    resetCurrentPosition()
    while (currentX < 7 && currentY > 0) {
        currentX++
        currentY--
        if (isQueenAtCurrentPosition()) break
    }
    resetCurrentPosition()
    while (currentX > 0 && currentY < 7) {
        currentX--
        currentY++
        if (isQueenAtCurrentPosition()) break
    }
    return result
}


private fun main() {

}
