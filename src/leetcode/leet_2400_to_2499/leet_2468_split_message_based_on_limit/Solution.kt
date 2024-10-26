package leetcode.leet_2400_to_2499.leet_2468_split_message_based_on_limit

import kotlin.math.floor
import kotlin.math.log10

/**
 * leetcode - https://leetcode.com/problems/split-message-based-on-limit/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
private val Int.numberOfDigits
    get() = floor(log10(this.toDouble())).toInt() + 1

private fun splitMessage(message: String, limit: Int): Array<String> {
    if (limit <= 5) {
        return emptyArray()
    }

    fun getSize(): Int {
        val adjustedLimit = limit - 3
        var bucket = 1

        return 14
    }

    fun getSuffixSize(index: Int, size: Int): Int {
        return (index + 1).numberOfDigits + size.numberOfDigits + 3
    }

    fun generateResult(): Array<String> {
        val size = getSize()
        val result = mutableListOf<String>()
        var pointer = 0
        var row = 0
        while (pointer < message.length) {
            val stringBuilder = StringBuilder()
            repeat(limit - getSuffixSize(row, size)) {
                stringBuilder.append(message[pointer++])
            }
            stringBuilder.append('<')
            stringBuilder.append(row + 1)
            stringBuilder.append('/')
            stringBuilder.append(size)
            stringBuilder.append('>')
            result.add(stringBuilder.toString())
            row++
        }
        return result.toTypedArray()
    }
    return generateResult()
}

private fun main() {

}
