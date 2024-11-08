package leetcode.leetcode_3280_convert_date_to_binary

/**
 * leetcode - https://leetcode.com/problems/convert-date-to-binary/
 *
 * TODO(Abhi) - To revisit
 *
 * Using String Builder
 * Int to Binary
 *
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 2 ms, faster than 100.00%
 * Memory Usage: 35.6 MB, less than 95.60%
 *
 * Time - O(N)
 * Space - O(M)
 */
private fun convertDateToBinary(date: String): String {
    val result = StringBuilder()
    fun intToBinary(x: Int) {
        var temp = x
        while (temp != 0) {
            result.insert(0, temp % 2)
            temp /= 2
        }
    }

    fun getInt(start: Int, end: Int): Int {
        var value = 0
        var i = start
        while (i <= end) {
            value = (value * 10) + (date[i] - '0')
            i++
        }
        return value
    }
    intToBinary(getInt(8, 9))
    result.insert(0, "-")
    intToBinary(getInt(5, 6))
    result.insert(0, "-")
    intToBinary(getInt(0, 3))
    return result.toString()
}

private fun main() {

}
