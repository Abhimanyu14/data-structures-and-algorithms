package leetcode.leetcode_3345_smallest_divisible_digit_product_i

/**
 * leetcode - https://leetcode.com/problems/smallest-divisible-digit-product-i/
 *
 * Data Structure -
 * Algorithm - Digit Extraction
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 98.28%
 * Memory Usage: 35.2 MB, less than 8.62%
 *
 * Time -
 * Space -
 */
private fun smallestNumber(n: Int, t: Int): Int {
    fun getProductOfDigits(x: Int): Int {
        var product = 1
        var temp = x
        while (temp != 0) {
            product *= (temp % 10)
            temp /= 10
        }
        return product
    }

    var result = n
    while (getProductOfDigits(result) % t != 0) {
        result++
    }
    return result
}

private fun main() {

}
