package leetcode.leet_2000_to_2099.leet_2000_reverse_prefix_of_word

/**
 * leetcode - https://leetcode.com/problems/reverse-prefix-of-word/?envType=daily-question&envId=2024-05-01
 *
 * Using string builder and iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 151 ms, faster than 53.49%
 * Memory Usage: 34.1 MB, less than 74.42%
 *
 * Time - O(N)
 * Space - O(N)
 */
private fun reversePrefix(word: String, ch: Char): String {
    val result = StringBuilder()
    var forward = 0
    var reverse = -1
    for (i in word.indices) {
        if (word[i] == ch) {
            reverse = i
            forward = i + 1
            break
        }
    }
    while (reverse >= 0) {
        result.append(word[reverse])
        reverse--
    }
    while (forward < word.length) {
        result.append(word[forward])
        forward++
    }
    return result.toString()
}

private fun main() {

}
