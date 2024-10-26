package leetcode.leet_1500_to_1599.leet_1592_rearrange_spaces_between_words

/**
 * leetcode - https://leetcode.com/problems/rearrange-spaces-between-words/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
private fun reorderSpaces(text: String): String {
    var totalSpaces = 0
    var words = 0
    var prevChar: Char = '0'
    var i = 0
    while (text[i] == ' ') {
        totalSpaces++
        i++
        prevChar = ' '
    }
    while (i < text.length) {
        if (text[i] == ' ') {
            totalSpaces++
        } else if (i == 0 || (prevChar == ' ' && text[i].isLowerCase())) {
            words++
        }
        prevChar = text[i]
        i++
    }

    val spaceBetweenWords = if (words == 1) {
        0
    } else {
        totalSpaces / (words - 1)
    }
    val result = StringBuilder()
    var spacesUsed = 0
    var spaceCounter = 0

    var pos = 0
    while (text[pos] == ' ') {
        pos++
    }

    while (pos < text.length) {
        if (text[pos].isLowerCase()) {
            result.append(text[pos])
            pos++
        } else {
            while (spacesUsed < totalSpaces && spaceCounter < spaceBetweenWords) {
                result.append(' ')
                spacesUsed++
                spaceCounter++
            }
            spaceCounter = 0
            while (pos < text.length && text[pos] == ' ') {
                pos++
            }
        }
    }
    while (spacesUsed < totalSpaces) {
        result.append(' ')
        spacesUsed++
    }
    return result.toString()
}

private fun main() {

}
