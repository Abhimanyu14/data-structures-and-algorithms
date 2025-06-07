package leetcode.leetcode_271_encode_and_decode_strings

/**
 * leetcode - https://leetcode.com/problems/encode-and-decode-strings/description/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 * Premium question
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 * k: Chars for length and delimiters
 * Time - O(N)
 * Space - O(k)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
class Codec {
    // Encodes a list of strings to a single string.
    fun encode(strs: List<String>): String {
        val result = StringBuilder()
        for (str in strs) {
            result.append("#${str.length}:${str}")
        }
        return result.toString()
    }

    // Decodes a single string to a list of strings.
    fun decode(s: String): List<String> {
        val result = mutableListOf<String>()
        val current = StringBuilder()
        var index = 0
        while (index <= s.lastIndex) {
            index++
            var length = 0
            while (s[index] != ':') {
                length = (length * 10) + s[index].digitToInt()
                index++
            }
            index++
            for (i in 0..<length) {
                current.append(s[index])
                index++
            }
            result.add(current.toString())
            current.clear()
        }
        return result
    }
}

private class SolutionUsingDelimiter {
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
