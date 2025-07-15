package leetcode.leetcode_93_restore_ip_addresses

/**
 * leetcode - https://leetcode.com/problems/restore-ip-addresses/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure -
 * Algorithm - Backtracking (Recursion)
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun restoreIpAddresses(s: String): List<String> {
    val result = mutableListOf<String>()
    val stringBuilder = StringBuilder()
    fun backtrack(index: Int, octetCount: Int, currentValue: Int?) {
        if (octetCount > 4) {
            return
        }
        if (index == s.length) {
            if (octetCount == 4) {
                result.add(stringBuilder.toString())
            }
            return
        }
        if (currentValue == null) {
            stringBuilder.append(s[index])
            backtrack(index + 1, octetCount + 1, s[index].digitToInt())
            stringBuilder.deleteAt(stringBuilder.lastIndex)
            return
        }
        if (currentValue != 0 && ((currentValue * 10 + s[index].digitToInt()) <= 255)) {
            stringBuilder.append(s[index])
            backtrack(index + 1, octetCount, (currentValue * 10 + s[index].digitToInt()))
            stringBuilder.deleteAt(stringBuilder.lastIndex)
        }
        stringBuilder.append('.')
        backtrack(index, octetCount, null)
        stringBuilder.deleteAt(stringBuilder.lastIndex)
    }
    backtrack(0, 0, null)
    return result
}

private fun main() {

}
