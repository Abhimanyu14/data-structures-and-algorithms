package leetcode.leet_2400_to_2499.leet_2485_find_the_pivot_integer

/**
 * leetcode - https://leetcode.com/problems/find-the-pivot-integer/
 *
 * TODO(Abhi) - To revisit
 *
 * Using two pointers
 *
 * Stats
 * Runtime: 140 ms, faster than 88.00%
 * Memory Usage: 33.3 MB, less than 74.00%
 */
private fun pivotInteger(n: Int): Int {
    var low = 1
    var high = n
    var lowSum = 1
    var highSum = n
    while (low <= high) {
        if (low == high) {
            return if (lowSum == highSum) {
                low
            } else {
                -1
            }
        }
        if (lowSum < highSum) {
            low++
            lowSum += low
        } else {
            high--
            highSum += high
        }
    }
    return -1
}

private fun main() {

}
