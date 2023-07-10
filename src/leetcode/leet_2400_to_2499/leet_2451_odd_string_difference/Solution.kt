package leetcode.leet_2400_to_2499.leet_2451_odd_string_difference

/**
 * Using iteration
 *
 * leetcode - https://leetcode.com/problems/odd-string-difference/
 *
 * Stats
 * Runtime: 228 ms, faster than 53.85%
 * Memory Usage: 36.4 MB, less than 38.46%
 */
private fun oddString(words: Array<String>): String {
    var i = 0
    var j = 0
    var diff: Int
    while (i < words[0].length - 1) {
        diff = words[0][i + 1] - words[0][i]
        j = 1
        while (j <= words.lastIndex) {
            if (words[j][i + 1] - words[j][i] != diff) {
                break
            }
            j++
        }
        if (j <= words.lastIndex) {
            break
        }
        i++
    }
    return if (j > 1) {
        words[j]
    } else {
        if (words[2][i + 1] - words[2][i] == words[1][i + 1] - words[1][i]) {
            words[0]
        } else {
            words[1]
        }
    }
}

private fun main() {

}
