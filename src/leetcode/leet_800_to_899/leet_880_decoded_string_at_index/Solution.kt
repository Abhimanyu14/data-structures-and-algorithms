package leetcode.leet_800_to_899.leet_880_decoded_string_at_index

/**
 * leetcode - https://leetcode.com/problems/decoded-string-at-index/
 *
 * Using string traversal
 *
 * Stats
 * Runtime: 134 ms, faster than 100.00%
 * Memory Usage: 34 MB, less than 100.00%
 */
private fun decodeAtIndex(s: String, k: Int): String {
    var size = 0L

    var i = 0
    while (i < s.length) {
        if (s[i].isDigit()) {
            size *= (s[i] - '0')
        } else {
            size++
        }
        i++
        if (size >= k) {
            break
        }
    }
    i--

    var updatedK = k.toLong()
    while (i >= 0) {
        updatedK %= size
        if (updatedK == 0L && s[i].isLetter()) {
            return s[i].toString()
        }
        if (s[i].isDigit()) {
            size /= (s[i] - '0')
        } else {
            size--
        }
        i--
    }
    return ""
}

/**
 * leetcode - https://leetcode.com/problems/decoded-string-at-index/
 *
 * Using string builder
 *
 * Stats
 * Memory Limit Exceeded
 */
private fun decodeAtIndexStringBuilder(s: String, k: Int): String {
    val stringBuilder = StringBuilder()
    var size = 0
    for (c in s) {
        if (c.isLetter()) {
            size++
            stringBuilder.append(c)
        } else {
            size *= c - '0'
            repeat(c - '0' - 1) {
                stringBuilder.append(stringBuilder.toString())
            }
        }
        if (size >= k) {
            return stringBuilder.toString()[k - 1].toString()
        }
    }
    return ""
}

private fun main() {

}
