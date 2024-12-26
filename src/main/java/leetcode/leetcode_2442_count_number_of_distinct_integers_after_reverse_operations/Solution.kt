package leetcode.leetcode_2442_count_number_of_distinct_integers_after_reverse_operations

/**
 * leetcode - https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Set
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 71 ms, faster than 100.00%
 * Memory Usage: 57.2 MB, less than 66.67%
 *
 * Time -
 * Space -
 */
private fun countDistinctIntegers(nums: IntArray): Int {
    val set = mutableSetOf<Int>()
    fun reverse(x: Int): Int {
        var result = 0
        var temp = x
        while (temp != 0) {
            result = (result * 10) + temp % 10
            temp /= 10
        }
        return result
    }

    for (num in nums) {
        set.add(num)
        set.add(reverse(num))
    }
    return set.size
}

private fun main() {

}
