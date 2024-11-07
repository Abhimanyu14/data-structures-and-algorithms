package leetcode.leetcode_1356_sort_integers_by_the_number_of_1_bits

/**
 * leetcode - https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 *
 * TODO(Abhi) - To revisit
 *
 * Using [Integer.bitCount]
 *
 * Stats
 * Runtime: 238 ms, faster than 60.00%
 * Memory Usage: 41.2 MB, less than 15.00%
 */
private fun sortByBits(arr: IntArray): IntArray {
    return arr.sortedWith { a, b ->
        if (a.countOneBits() == b.countOneBits()) {
            a - b
        } else {
            a.countOneBits() - b.countOneBits()
        }
    }.toIntArray()
}

private fun main() {

}
