package leetcode.leet_1000_to_1099.leet_1047_remove_all_adjacent_duplicates_in_string

/**
 * leetcode - https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * Using stack implemented using string builder
 * String builder - append(), deleteCharAt()
 *
 * Stats
 * Runtime: 250 ms, faster than 97.69%
 * Memory Usage: 36.9 MB, less than 89.97%
 */
private fun removeDuplicates(s: String): String {
    val sb = StringBuilder()
    s.forEach {
        if (sb.isNotEmpty() && sb.last() == it) {
            sb.deleteCharAt(sb.lastIndex)
        } else {
            sb.append(it)
        }
    }
    return sb.toString()
}

/**
 * leetcode - https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * Using recursion
 *
 * Stats
 * Time Limit Exceeded
 */
private fun removeDuplicatesUsingRecursion(s: String): String {
    for (i in 0 until s.lastIndex) {
        if (s[i] == s[i + 1]) {
            return removeDuplicates("${s.substring(0, i)}${s.substring(i + 2, s.length)}")
        }
    }
    return s
}

private fun main() {

}
