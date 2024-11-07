package leetcode.leetcode_367_valid_perfect_square

// TODO-Abhi: Check how to solve using Newton's method

/**
 * leetcode - https://leetcode.com/problems/valid-perfect-square/
 *
 * Using binary search
 *
 * Stats
 * Runtime: 142 ms, faster than 75.00%
 * Memory Usage: 32.8 MB, less than 91.07%
 */
private fun isPerfectSquare(num: Int): Boolean {
    if (num == 1) {
        return true
    }
    var low = 1
    var high = num / 2
    var mid: Int
    var temp: Long
    while (low <= high) {
        mid = low + (high - low) / 2
        temp = (mid.toLong() * mid.toLong())
        if (num.toLong() == temp) {
            return true
        } else if (num.toLong() > temp) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return false
}

private fun main() {

}
