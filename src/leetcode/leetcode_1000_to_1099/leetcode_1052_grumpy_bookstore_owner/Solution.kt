package leetcode.leetcode_1000_to_1099.leetcode_1052_grumpy_bookstore_owner

/**
 * leetcode - https://leetcode.com/problems/grumpy-bookstore-owner/
 *
 * Using
 *
 * Stats
 * Runtime: 622 ms, faster than 25.00%
 * Memory Usage: 61.4 MB, less than 50.00%
 */
private fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
    var satisfied = 0
    var max = 0
    var window = 0
    var start = 0
    var end = -1
    customers.forEachIndexed { index, customer ->
        satisfied += if (grumpy[index] == 0) {
            customer
        } else {
            0
        }
        end++
        window += grumpy[end] * customers[end]
        if (end - start == minutes) {
            window -= grumpy[start] * customers[start]
            start++
        }
        if (window > max) {
            max = window
        }
    }
    return satisfied + max
}

private fun main() {
}
