package leetcode.leetcode_2100_to_2199.leetcode_2129_capitalize_the_title

/**
 * leetcode - https://leetcode.com/problems/capitalize-the-title/
 *
 * Using string methods - joinToString(), split(), lowercase(), toLowerCase(),
 * capitalize(), replaceFirstChar(), uppercaseChar()
 *
 *
 * Stats
 * Runtime: 219 ms, faster than 60.00%
 * Memory Usage: 35.9 MB, less than 70.00%
 */
private fun capitalizeTitle(title: String): String {
    return title.split(" ").joinToString(" ") { word ->
        if (word.length > 2) {
            // lowercase() -> toLowerCase() in leetcode
            // replaceFirstChar() -> capitalize() in leetcode
            word.toLowerCase().capitalize()
        } else {
            word.toLowerCase()
        }
    }
}

private fun capitalizeTitleUsingNewKotlin(title: String): String {
    return title.split(" ").joinToString(" ") { word ->
        if (word.length > 2) {
            word.lowercase().replaceFirstChar {
                it.uppercaseChar()
            }
        } else {
            word.lowercase()
        }
    }
}

private fun main() {

}
