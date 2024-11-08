package leetcode.leetcode_2011_final_value_of_variable_after_performing_operations

/**
 * leetcode - https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
 *
 * Using
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 37 MB, less than 78.72%
 *
 * Time -
 * Space -
 */
private fun finalValueAfterOperations(operations: Array<String>): Int {
    var result = 0
    operations.forEach {
        if (it[0] == '-' || it[2] == '-') {
            result--
        } else {
            result++
        }
    }
    return result
}

private fun main() {

}
