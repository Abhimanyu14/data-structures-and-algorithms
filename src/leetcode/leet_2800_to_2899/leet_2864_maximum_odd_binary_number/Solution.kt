package leetcode.leet_2800_to_2899.leet_2864_maximum_odd_binary_number

/**
 * leetcode - https://leetcode.com/problems/maximum-odd-binary-number/
 *
 * Using string builder and loop
 *
 * Stats
 * Runtime: 192 ms, faster than 45.45%
 * Memory Usage: 36.5 MB, less than 100.00%
 */
private fun maximumOddBinaryNumber(s: String): String {
    var oneCount = 0
    s.forEach {
        if (it == '1') {
            oneCount++
        }
    }
    val result = StringBuilder()
    repeat(oneCount - 1) {
        result.append("1")
    }
    repeat(s.length - oneCount) {
        result.append("0")
    }
    result.append("1")
    return result.toString()
}

/**
 * leetcode - https://leetcode.com/problems/maximum-odd-binary-number/
 *
 * Using string builder and string count
 *
 * Stats
 * Runtime: 201 ms, faster than 45.45%
 * Memory Usage: 36.8 MB, less than 90.91%
 */
private fun maximumOddBinaryNumberUsingCount(s: String): String {
    val oneCount = s.count { it == '1' }
    val result = StringBuilder()
    repeat(oneCount - 1) {
        result.append("1")
    }
    repeat(s.length - oneCount) {
        result.append("0")
    }
    result.append("1")
    return result.toString()
}

private fun main() {

}
