package leetcode.leet_2400_to_2499.leet_2413_smallest_even_multiple

/**
 * leetcode - https://leetcode.com/problems/smallest-even-multiple/
 *
 * Using conditionals
 *
 * Stats
 * Runtime: 123 ms, faster than 79.10%
 * Memory Usage: 33.2 MB, less than 14.93%
 */
private fun smallestEvenMultiple(n: Int): Int {
    return if (n % 2 == 0) {
        n
    } else {
        n * 2
    }
}

private fun main() {

}
