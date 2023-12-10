package leetcode.leet_400_to_499.leet_443_string_compression

/**
 * leetcode - https://leetcode.com/problems/string-compression/
 *
 * Using iteration
 *
 * Stats
 * Runtime: 195 ms, faster than 21.03%
 * Memory Usage: 37.4 MB, less than 37.95%
 */
private fun compress(chars: CharArray): Int {
    val stringBuilder = StringBuilder()
    var currentChar: Char
    var currentCount: Int
    var i = 0
    while (i <= chars.lastIndex) {
        currentChar = chars[i]
        currentCount = 0
        stringBuilder.append(currentChar)
        while (i <= chars.lastIndex && chars[i] == currentChar) {
            currentCount++
            i++
        }
        if (currentCount > 1) {
            stringBuilder.append(currentCount)
        }
    }
    val newString = stringBuilder.toString()
    newString.toCharArray().forEachIndexed { index, char ->
        chars[index] = char
    }
    return newString.length
}

private fun main() {

}
