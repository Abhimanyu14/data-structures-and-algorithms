package leetcode.leetcode_3042_count_prefix_and_suffix_pairs_i

/**
 * leetcode - https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/?envType=daily-question&envId=2025-01-08
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm - Brute Force
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun countPrefixSuffixPairs(words: Array<String>): Int {
    var result = 0
    for (i in 0..words.lastIndex) {
        for (j in (i + 1)..words.lastIndex) {
            if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                result++
            }
        }
    }
    return result
}

private fun main() {

}
