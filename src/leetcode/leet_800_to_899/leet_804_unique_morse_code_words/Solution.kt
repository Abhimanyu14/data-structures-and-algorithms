package leetcode.leet_800_to_899.leet_804_unique_morse_code_words

/**
 * leetcode - https://leetcode.com/problems/unique-morse-code-words/
 *
 * Using map and set
 *
 * Stats
 * Runtime: 188 ms, faster than 88.89%
 * Memory Usage: 35.4 MB, less than 92.59%
 */
private fun uniqueMorseRepresentations(words: Array<String>): Int {
    val morseMap = hashMapOf(
        'a' to ".-",
        'b' to "-...",
        'c' to "-.-.",
        'd' to "-..",
        'e' to ".",
        'f' to "..-.",
        'g' to "--.",
        'h' to "....",
        'i' to "..",
        'j' to ".---",
        'k' to "-.-",
        'l' to ".-..",
        'm' to "--",
        'n' to "-.",
        'o' to "---",
        'p' to ".--.",
        'q' to "--.-",
        'r' to ".-.",
        's' to "...",
        't' to "-",
        'u' to "..-",
        'v' to "...-",
        'w' to ".--",
        'x' to "-..-",
        'y' to "-.--",
        'z' to "--.."
    )
    val set = hashSetOf<String>()
    val code = StringBuilder()
    words.forEach { word ->
        code.clear()
        for (c in word) {
            code.append(morseMap[c] ?: '!')
        }
        set.add(code.toString())
    }
    return set.size
}

private fun main() {

}
