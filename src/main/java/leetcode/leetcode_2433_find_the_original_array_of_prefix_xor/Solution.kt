package leetcode.leetcode_2433_find_the_original_array_of_prefix_xor

/**
 * leetcode - https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
 *
 * Using XOR - bitwise manipulation
 *
 * Stats
 * Runtime: 581 ms, faster than 62.50%
 * Memory Usage: 56 MB, less than 100.00%
 */
private fun findArray(pref: IntArray): IntArray {
    if (pref.size == 1) {
        return pref
    }
    var prev = pref[0]
    for (i in 1..pref.lastIndex) {
        pref[i] = (prev xor pref[i]).also {
            prev = pref[i]
        }
    }
    return pref
}

private fun main() {

}
