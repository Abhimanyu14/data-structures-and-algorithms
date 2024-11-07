package leetcode.leetcode_2351_first_letter_to_appear_twice

/**
 * Using Set
 *
 * leetcode - https://leetcode.com/problems/first-letter-to-appear-twice/
 *
 * Stats
 * Runtime: 154 ms, faster than 91.89%
 * Memory Usage: 33.6 MB, less than 89.19%
 */
private fun repeatedCharacter(s: String): Char {
    val set = mutableSetOf<Char>()
    s.forEach {
        if(set.contains(it)){
            return it
        } else {
            set.add(it)
        }
    }
    return '.'
}

private fun main() {
    println(repeatedCharacter("abccbaacz"))
    println(repeatedCharacter("abcdd"))
}
