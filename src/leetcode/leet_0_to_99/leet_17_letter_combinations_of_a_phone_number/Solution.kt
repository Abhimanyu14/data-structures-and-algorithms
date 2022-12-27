package leetcode.leet_0_to_99.leet_17_letter_combinations_of_a_phone_number

/**
 * leetcode - https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Using recursion
 *
 * Stats
 * Runtime: 375 ms, faster than 5.30%
 * Memory Usage: 37.5 MB, less than 51.66%
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

    fun getStrings(digits: String, index: Int, str: String, result: MutableList<String>): MutableList<String> {
        if (index > digits.lastIndex) {
            result.add(str)
            return result
        }
        (map[digits[index]] ?: arrayOf()).forEach {
            getStrings(digits, index + 1, "$str$it", result)
        }
        return result
    }
    return getStrings(digits, 0, "", mutableListOf())
}

private fun main() {

}
