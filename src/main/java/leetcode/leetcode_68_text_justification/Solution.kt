package leetcode.leetcode_68_text_justification

import kotlin.math.ceil

/**
 * leetcode - https://leetcode.com/problems/text-justification/
 *
 * Using
 *
 * Stats
 * Runtime: 172 ms, faster than 56.32%
 * Memory Usage: 38.2 MB, less than 9.20%
 */
private fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    val result = mutableListOf<String>()
    val stringBuilder = StringBuilder()
    var bufferCount = 0
    var spaceRequired = 0
    var extraSpaceAvailable: Int
    var currentIndex = 0

    words.forEachIndexed { index, word ->
        if (bufferCount + word.length > maxWidth) {
            spaceRequired--
            bufferCount--
            extraSpaceAvailable = maxWidth - bufferCount

            while (currentIndex < index) {
                stringBuilder.append(words[currentIndex])
                if (spaceRequired != 0) {
                    stringBuilder.append(" ")
                    val extraSpaces = ceil(extraSpaceAvailable.toFloat() / spaceRequired).toInt()
                    repeat(extraSpaces) {
                        stringBuilder.append(" ")
                    }
                    extraSpaceAvailable -= extraSpaces
                    spaceRequired--
                }
                currentIndex++
            }
            repeat(maxWidth - stringBuilder.length) {
                stringBuilder.append(" ")
            }

            result.add(stringBuilder.toString())
            stringBuilder.clear()

            bufferCount = word.length + 1
            spaceRequired = 1
            return@forEachIndexed
        }
        bufferCount += word.length + 1
        spaceRequired++
    }
    while (currentIndex < words.lastIndex) {
        stringBuilder.append(words[currentIndex])
        stringBuilder.append(" ")
        currentIndex++
    }
    stringBuilder.append(words.last())
    repeat(maxWidth - stringBuilder.length) {
        stringBuilder.append(" ")
    }
    result.add(stringBuilder.toString())

    return result
}

private fun main() {
    println(
        fullJustify(
            words = arrayOf("This", "is", "an", "example", "of", "text", "justification."),
            maxWidth = 16,
        ).joinToString("\n")
    )
    println()
    println(
        fullJustify(
            words = arrayOf("What", "must", "be", "acknowledgment", "shall", "be"),
            maxWidth = 16,
        ).joinToString("\n")
    )
    println()
    println(
        fullJustify(
            words = arrayOf("Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"),
            maxWidth = 20,
        ).joinToString("\n")
    )
}
