package leetcode.leet_1000_to_1099.leet_1056_confusing_number

/**
 * Using string builder
 *
 * leetcode - https://leetcode.com/problems/confusing-number/
 *
 * Stats
 * Runtime: 135 ms, faster than 92.96%
 * Memory Usage: 33.6 MB, less than 47.89%
 */
private fun confusingNumber(n: Int): Boolean {
    fun rotatedNumber(n: Int): Int {
        val confusingDigits = mapOf(
            0 to 0,
            1 to 1,
            6 to 9,
            8 to 8,
            9 to 6
        )
        var temp = n
        var rem: Int
        var result = 0
        while (temp != 0) {
            rem = temp % 10
            if (!confusingDigits.contains(rem)) {
                return n
            }
            result = result * 10 + confusingDigits.getOrDefault(rem, 0)
            temp /= 10
        }
        return result
    }
    return n != rotatedNumber(n)
}

/**
 * Using string builder
 *
 * leetcode - https://leetcode.com/problems/confusing-number/
 *
 * Stats
 * Runtime: 245 ms, faster than 28.57%
 * Memory Usage: 35 MB, less than 14.29%
 */
private fun confusingNumberUsingStringBuilder(n: Int): Boolean {
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
    return n != rotatedNumber(n)
}

private fun main() {

}
