package leetcode.leetcode_271_encode_and_decode_strings

/**
 * leetcode -
 * Premium question
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
private class Solution {
    fun encode(strs: List<String>): String {
        return strs.joinToString(",") {
            it
                .replace("/", "//")
                .replace(",", "/,")
        }
    }

    fun decode(s: String): List<String> {
        val result = mutableListOf<String>()
        val stringBuilder = StringBuilder()
        var prevIsDelimiter = false
        s.forEach {
            if (it == '/') {
                if (prevIsDelimiter) {
                    stringBuilder.append(it)
                    prevIsDelimiter = false
                } else {
                    prevIsDelimiter = true
                }
            } else {
                if (it == ',') {
                    if (prevIsDelimiter) {
                        stringBuilder.append(it)
                        prevIsDelimiter = false
                    } else {
                        result.add(stringBuilder.toString())
                        stringBuilder.clear()
                    }
                } else {
                    stringBuilder.append(it)
                }
            }
        }
        result.add(stringBuilder.toString())
        return result
    }
}

private fun main() {

}
