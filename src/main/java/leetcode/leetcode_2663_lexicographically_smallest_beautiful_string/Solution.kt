package leetcode.leetcode_2663_lexicographically_smallest_beautiful_string

/**
 * leetcode - https://leetcode.com/problems/lexicographically-smallest-beautiful-string/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun smallestBeautifulString(s: String, k: Int): String {
    val characters: CharArray = s.toCharArray()
    fun increment(): Boolean {
        var index = characters.lastIndex
        while (index >= 0) {
            if (characters[index] - 'a' + 1 == k) {
                characters[index] = 'a'
                index++
            } else {
                characters[index]++
                return true
            }
        }
        return false
    }

    fun isBeautiful(): Boolean {
        for (i in 0..<characters.lastIndex) {
            if (characters[i] == characters[i + 1]) {
                return false
            }
        }
        for (i in 0..(characters.lastIndex - 2)) {
            if (characters[i] == characters[i + 2]) {
                return false
            }
        }
        return true
    }

    while (increment()) {
        if (isBeautiful()) {
            return characters.joinToString("")
        }
    }
    return ""
}


private fun main() {

}
