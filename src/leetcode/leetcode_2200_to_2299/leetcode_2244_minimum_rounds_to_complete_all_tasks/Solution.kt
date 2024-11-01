package leetcode.leetcode_2200_to_2299.leetcode_2244_minimum_rounds_to_complete_all_tasks

/**
 * leetcode - https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
 *
 * Using frequency counter map
 *
 * Stats
 * Runtime: 869 ms, faster than 50.00%
 * Memory Usage: 110.1 MB, less than 33.33%
 */
private fun minimumRounds(tasks: IntArray): Int {
    val counter = mutableMapOf<Int, Int>()
    tasks.forEach {
        counter[it] = counter.getOrDefault(it, 0) + 1
    }
    var result = 0
    counter.forEach { (_, value) ->
        if (value == 1) {
            return -1
        } else {
            result += if (value % 3 == 0) {
                value / 3
            } else {
                (value / 3) + 1
            }
        }
    }
    return result
}

private fun main() {

}
