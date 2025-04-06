package leetcode.leetcode_17_letter_combinations_of_a_phone_number

/**
 * leetcode - https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Data Structure - [Map]
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 16 ms, faster than 36.76%
 * Memory Usage: 46.23 MB, less than 6.58%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) {
        return emptyList()
    }
    val map = mapOf(
        '2' to listOf('a', 'b', 'c'),
        '3' to listOf('d', 'e', 'f'),
        '4' to listOf('g', 'h', 'i'),
        '5' to listOf('j', 'k', 'l'),
        '6' to listOf('m', 'n', 'o'),
        '7' to listOf('p', 'q', 'r', 's'),
        '8' to listOf('t', 'u', 'v'),
        '9' to listOf('w', 'x', 'y', 'z'),
    )

    fun getResult(index: Int, current: String): List<String> {
        if (index == digits.length) {
            return listOf(current)
        }
        val result = mutableListOf<String>()
        map[digits[index]]?.forEach {
            result.addAll(getResult(index + 1, current + it))
        }
        return result
    }
    return getResult(0, "")
}

private fun letterCombinationsRecursion(digits: String): List<String> {
    if (digits == "") {
        return emptyList()
    }
    val map = mapOf(
        '2' to arrayOf('a', 'b', 'c'),
        '3' to arrayOf('d', 'e', 'f'),
        '4' to arrayOf('g', 'h', 'i'),
        '5' to arrayOf('j', 'k', 'l'),
        '6' to arrayOf('m', 'n', 'o'),
        '7' to arrayOf('p', 'q', 'r', 's'),
        '8' to arrayOf('t', 'u', 'v'),
        '9' to arrayOf('w', 'x', 'y', 'z')
    )
    val result = mutableListOf<String>()
    fun getStrings(digits: String, index: Int, str: String): MutableList<String> {
        if (index > digits.lastIndex) {
            result.add(str)
            return result
        }
        (map[digits[index]] ?: arrayOf()).forEach {
            getStrings(digits, index + 1, "$str$it")
        }
        return result
    }
    getStrings(digits, 0, "")
    return result
}

/**
 * leetcode - https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Using backtracking
 *
 * Stats
 *
 */
private fun letterCombinationsUsingBacktracking(digits: String): List<String> {
    if (digits == "") {
        return emptyList()
    }
    val map = mapOf(
        '2' to arrayOf('a', 'b', 'c'),
        '3' to arrayOf('d', 'e', 'f'),
        '4' to arrayOf('g', 'h', 'i'),
        '5' to arrayOf('j', 'k', 'l'),
        '6' to arrayOf('m', 'n', 'o'),
        '7' to arrayOf('p', 'q', 'r', 's'),
        '8' to arrayOf('t', 'u', 'v'),
        '9' to arrayOf('w', 'x', 'y', 'z')
    )
    val result = mutableListOf<String>()
    fun getStrings(index: Int, chars: MutableList<Char>): MutableList<String> {
        if (chars.size == digits.length) {
            result.add(chars.joinToString(""))
            return result
        }
        (map[digits[index]] ?: arrayOf()).forEach {
            chars.add(it)
            getStrings(index + 1, chars)
            chars.removeAt(chars.lastIndex)
        }
        return result
    }
    getStrings(0, mutableListOf())
    return result
}

private fun main() {

}
