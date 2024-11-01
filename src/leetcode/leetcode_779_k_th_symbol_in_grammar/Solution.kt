package leetcode.leetcode_779_k_th_symbol_in_grammar

import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/k-th-symbol-in-grammar/
 *
 * TODO(Abhi) - To revisit
 *
 * Using iteration
 *
 * Stats
 * Runtime: 121 ms, faster than 75.00%
 * Memory Usage: 32.8 MB, less than 95.00%
 */
private fun kthGrammar(n: Int, k: Int): Int {
    var k = k
    if (n == 1) {
        return 0
    }

    // We assume the symbol at the target position is '1'.
    var symbol = 1
    for (currRow in n downTo 2) {
        val totalElements = 2.0.pow((currRow - 1)).toInt()
        val halfElements = totalElements / 2

        // If 'k' lies in the right half symbol, then we flip over to the respective left half symbol.
        if (k > halfElements) {
            // Flip the symbol.
            symbol = 1 - symbol
            // Change the position after flipping.
            k -= halfElements
        }
    }

    // We reached the 1st row; if the symbol is not '0', we started with the wrong symbol.
    return if (symbol != 0) {
        // Thus, the start symbol was '0', not '1'.
        0
    } else 1

    // The start symbol was indeed what we started with, a '1'.
}

private fun main() {

}
