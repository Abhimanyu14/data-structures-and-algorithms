package leetcode.leetcode_2506_count_pairs_of_similar_strings

/**
 * leetcode - https://leetcode.com/problems/count-pairs-of-similar-strings/
 *
 * Data Structure - Map
 * Algorithm - Bitwise Operations - OR, SHL, and Masking
 *
 * Difficulty -
 *
 * Stats
 * Runtime: 6 ms, faster than 94.44%
 * Memory Usage: 38 MB, less than 94.44%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun similarPairs(words: Array<String>): Int {
    var result = 0
    val counter = mutableMapOf<Int, Int>()
    for (word in words) {
        var mask = 0
        for (char in word) {
            mask = mask or (1 shl (char - 'a'))
        }
        result += counter.getOrDefault(mask, 0)
        counter[mask] = counter.getOrDefault(mask, 0) + 1
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/count-pairs-of-similar-strings/
 *
 * Data Structure - Sets
 * Algorithm - Iteration and Hashing
 *
 * Difficulty -
 *
 * Stats
 * Runtime: 62 ms, faster than 27.78%
 * Memory Usage: 42.1 MB, less than 5.56%
 *
 * Time -
 * Space -
 */
private fun similarPairsUsingSet(words: Array<String>): Int {
    var result = 0
    val sets = words.map { it.toSet() }
    for (i in 0..words.lastIndex) {
        for (j in (i + 1)..words.lastIndex) {
            if (sets[i] == sets[j]) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}
