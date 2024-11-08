package leetcode.leetcode_1342_number_of_steps_to_reduce_a_number_to_zero

/**
 * leetcode - https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 33.8 MB, less than 5.17%
 *
 * Time -
 * Space -
 */
private fun numberOfSteps(num: Int): Int {
    var result = 0
    var temp = num
    while (temp != 0) {
        if (temp % 2 == 0) {
            temp /= 2
        } else {
            temp--
        }
        result++
    }
    return result
}

private fun main() {

}
