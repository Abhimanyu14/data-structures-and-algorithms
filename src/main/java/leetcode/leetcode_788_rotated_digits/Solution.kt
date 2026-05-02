package leetcode.leetcode_788_rotated_digits

/**
 * leetcode - https://leetcode.com/problems/rotated-digits/description/?envType=daily-question&envId=2026-05-02
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Simulation / Enumeration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun rotatedDigits(n: Int): Int {
    fun isValidNumber(x: Int): Boolean {
        var current = x
        var flag = false
        while (current != 0) {
            if (current % 10 == 3 || current % 10 == 4 || current % 10 == 7) {
                return false
            }
            if (current % 10 == 2 || current % 10 == 5 || current % 10 == 6 || current % 10 == 9) {
                flag = true
            }
            current /= 10
        }
        return flag
    }

    var result = 0
    for (i in 1..n) {
        if (isValidNumber(i)) {
            result++
        }
    }
    return result
}

private fun main() {

}
