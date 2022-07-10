package leetcode.leet_1941_check_if_all_characters_have_equal_number_of_occurrences

/**
 * Using Map
 *
 * Stats
 * Runtime: 203 ms, faster than 88.24%
 * Memory Usage: 35.8 MB, less than 58.82%
 */
fun areOccurrencesEqual(s: String): Boolean {
    val characterCounter = HashMap<Char, Int>()
    s.forEach {
        characterCounter[it] = characterCounter[it]?.plus(1) ?: 1
    }
    val firstCharCount = characterCounter[s[0]]
    return characterCounter.values.none {
        it != firstCharCount
    }
}

fun main() {
    println(areOccurrencesEqual("abacbc"))
    println(areOccurrencesEqual("aaabb"))
}
