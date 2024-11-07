package leetcode.leetcode_343_integer_break

import kotlin.math.max

/**
 * leetcode - https://leetcode.com/problems/integer-break/
 *
 * Using loops
 *
 * Stats
 * Runtime: 125 ms, faster than 66.67%
 * Memory Usage: 33.4 MB, less than 38.89%
 */
private fun integerBreak(n: Int): Int {
    var result = 1
    var sum: Int
    var product: Int
    var counter: Int
    var temp: Int
    for (i in 2..((n + 1) / 2)) {
        counter = i
        sum = n
        product = 1
        while (counter > 0) {
            temp = sum / counter
            sum -= temp
            product *= temp
            counter--
        }
        result = max(result, product)
    }
    return result
}

private fun main() {

}
