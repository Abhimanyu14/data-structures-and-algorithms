package leetcode.leetcode_1769_minimum_number_of_operations_to_move_all_balls_to_each_box

import kotlin.math.abs

/**
 * leetcode - https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
fun minOperations(boxes: String): IntArray {
    val result = IntArray(boxes.length)
    var count: Int
    boxes.forEachIndexed { i, _ ->
        count = 0
        boxes.forEachIndexed { j, v ->
            count += v.toString().toInt() * abs(i - j)
        }
        result[i] = count
    }
    return result
}

private fun main() {
    val input1 = "110"
    val input2 = "001011"
    println(minOperations(input1).joinToString(" "))
    println(minOperations(input2).joinToString(" "))
}
