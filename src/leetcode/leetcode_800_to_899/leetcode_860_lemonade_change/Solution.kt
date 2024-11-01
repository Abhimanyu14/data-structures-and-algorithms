package leetcode.leetcode_800_to_899.leetcode_860_lemonade_change

/**
 * leetcode - https://leetcode.com/problems/lemonade-change/
 *
 * Using
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 367 ms, faster than 62.16%
 * Memory Usage: 50 MB, less than 94.59%
 *
 * Time -
 * Space -
 */
private fun lemonadeChange(bills: IntArray): Boolean {
    var fiveCount = 0
    var tenCount = 0
    bills.forEach {
        when (it) {
            5 -> {
                fiveCount++
            }

            10 -> {
                if (fiveCount == 0) {
                    return false
                }
                tenCount++
                fiveCount--
            }

            else -> {
                if (tenCount > 0) {
                    if (fiveCount == 0) {
                        return false
                    }
                    tenCount--
                    fiveCount--
                } else {
                    if (fiveCount < 3) {
                        return false
                    }
                    fiveCount -= 3
                }
            }
        }
    }
    return true
}

private fun main() {

}
