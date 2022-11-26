package leetcode.leet_2351_first_letter_to_appear_twice

/**
 * Using LinkedHashmap
 *
 * Stats
 * Runtime: 269 ms, faster than 33.33%
 * Memory Usage: 35.4 MB, less than 12.82%
 */
private fun repeatedCharacter(s: String): Char {
    val set = HashSet<Char>()
    for (i in 0..s.lastIndex) {
        if (set.contains(s[i])) {
            return s[i]
        } else {
            set.add(s[i])
        }
    }
    return '.'
}

fun main() {
    println(repeatedCharacter("abccbaacz"))
    println(repeatedCharacter("abcdd"))
}
