package leetcode.leetcode_0_to_99.leetcode_12_integer_to_roman

/**
 * leetcode - https://leetcode.com/problems/integer-to-roman/
 *
 * Using tabulation with map
 *
 * Stats
 * Runtime: 241 ms, faster than 85.71%
 * Memory Usage: 36.6 MB, less than 89.44%
 */
private fun intToRoman(num: Int): String {
    val map = mapOf(
        0 to "",
        1 to "I",
        2 to "II",
        3 to "III",
        4 to "IV",
        5 to "V",
        6 to "VI",
        7 to "VII",
        8 to "VIII",
        9 to "IX",
        10 to "X",
        20 to "XX",
        30 to "XXX",
        40 to "XL",
        50 to "L",
        60 to "LX",
        70 to "LXX",
        80 to "LXXX",
        90 to "XC",
        100 to "C",
        200 to "CC",
        300 to "CCC",
        400 to "CD",
        500 to "D",
        600 to "DC",
        700 to "DCC",
        800 to "DCCC",
        900 to "CM",
        1000 to "M",
        2000 to "MM",
        3000 to "MMM"
    )
    var temp = num
    val result = StringBuilder()
    result.append(map[(temp / 1000) * 1000])
    temp %= 1000
    result.append(map[(temp / 100) * 100])
    temp %= 100
    result.append(map[(temp / 10) * 10])
    temp %= 10
    result.append(map[temp])
    return result.toString()
}

private fun main() {

}
