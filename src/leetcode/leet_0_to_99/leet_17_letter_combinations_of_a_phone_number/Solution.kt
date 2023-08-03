package leetcode.leet_0_to_99.leet_17_letter_combinations_of_a_phone_number

/**
 * leetcode - https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 168 ms, faster than 75.88%
 * Memory Usage: 37.6 MB, less than 45.29%
 */
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
private fun letterCombinations(digits: String): List<String> {
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
