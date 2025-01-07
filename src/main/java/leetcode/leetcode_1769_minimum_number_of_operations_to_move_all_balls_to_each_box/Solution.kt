package leetcode.leetcode_1769_minimum_number_of_operations_to_move_all_balls_to_each_box

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 *
 * Data Structure - Pointers
 * Algorithm - Iteration and prefix sum
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 */
private fun minOperations(boxes: String): IntArray {
    val result = IntArray(boxes.length)
    var leftMoves = 0
    var rightMoves = 0
    var leftBalls = boxes[0] - '0'
    var rightBalls = boxes[boxes.lastIndex] - '0'
    for (i in 1..boxes.lastIndex) {
        leftMoves += leftBalls
        rightMoves += rightBalls
        result[i] += leftMoves
        result[boxes.lastIndex - i] += rightMoves
        if (boxes[i] == '1') {
            leftBalls++
        }
        if (boxes[boxes.lastIndex -i] == '1') {
            rightBalls++
        }
    }
    return result
}

private fun main() {
    val input1 = "110"
    val input2 = "001011"
    println(minOperations(input1).joinToString(" "))
    println(minOperations(input2).joinToString(" "))
}
