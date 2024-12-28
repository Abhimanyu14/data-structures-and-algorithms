package leetcode.leetcode_2288_apply_discount_to_prices

/**
 * leetcode - https://leetcode.com/problems/apply-discount-to-prices/
 *
 * Data Structure - StringBuilder
 * Algorithm - Iteration and String Concatenation
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 193 ms, faster than 50.00%
 * Memory Usage: 56.5 MB, less than 50.00%
 *
 * Time -
 * Space -
 */
private fun discountPrices(sentence: String, discount: Int): String {
    val result = StringBuilder()
    val buffer = StringBuilder()
    var current = 0
    fun processPrice() {
        if (buffer.isEmpty()) {
            return
        }
        result.append(String.format("%.2f", ((buffer.toString().toLong() * (100 - discount)) / 100.0)))
    }

    while (current < sentence.length) {
        while (current < sentence.length && sentence[current] != '$') {
            result.append(sentence[current])
            current++
        }
        if (current < sentence.length && sentence[current] == '$') {
            result.append('$')
            current++
            if (current != 1 && sentence[current - 2] != ' ') {
                continue
            }
            buffer.clear()
            while (current < sentence.length && sentence[current].isDigit()) {
                buffer.append(sentence[current])
                current++
            }
            if (current == sentence.length) {
                processPrice()
            } else if (sentence[current] == ' ') {
                processPrice()
                buffer.append(' ')
            } else {
                result.append(buffer.toString())
            }
        }
    }
    return result.toString()
}

private fun main() {

}
