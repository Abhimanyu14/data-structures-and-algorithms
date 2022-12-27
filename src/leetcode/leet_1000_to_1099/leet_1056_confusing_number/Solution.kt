package leetcode.leet_1000_to_1099.leet_1056_confusing_number

/**
 * leetcode - https://leetcode.com/problems/confusing-number/
 *
 * Using
 *
 * Stats
 * Runtime: 245 ms, faster than 28.57%
 * Memory Usage: 35 MB, less than 14.29%
 */
private fun confusingNumber(n: Int): Boolean {
    return n != rotatedNumber(n)
}

fun rotatedNumber(n: Int): Int {
    val confusingDigits = mapOf(
        '0' to '0',
        '1' to '1',
        '6' to '9',
        '8' to '8',
        '9' to '6'
    )
    val result = StringBuilder()
    for (char in n.toString().reversed()) {
        if (!confusingDigits.contains(char)) {
            return n
        }
        result.append(confusingDigits[char])
    }
    return result.toString().toInt()
}

private fun main() {

}
