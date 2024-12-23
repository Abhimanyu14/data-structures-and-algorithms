package leetcode.leetcode_2296_design_a_text_editor

import kotlin.math.max
import kotlin.math.min

/**
 * leetcode - https://leetcode.com/problems/design-a-text-editor/?envType=problem-list-v2&envId=doubly-linked-list
 *
 * Data Structure - StringBuilder
 * Algorithm - StringBuilder
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 508 ms, faster than 40.00%
 * Memory Usage: 79.9 MB, less than 80.00%
 *
 * Time -
 * Space -
 */
private class TextEditor() {
    private var position = 0
    private val stringBuilder = StringBuilder()

    fun addText(text: String) {
        stringBuilder.insert(position, text)
        position += text.length
    }

    fun deleteText(k: Int): Int {
        val deleted = min(position, k)
        stringBuilder.deleteRange(position - deleted, position)
        position -= deleted
        return deleted
    }

    fun cursorLeft(k: Int): String {
        position = max(0, position - k)
        return stringBuilder.substring(max(0, position - 10), position)
    }

    fun cursorRight(k: Int): String {
        position = min(stringBuilder.length, position + k)
        return stringBuilder.substring(max(0, position - 10), position)
    }
}

private fun main() {

}
