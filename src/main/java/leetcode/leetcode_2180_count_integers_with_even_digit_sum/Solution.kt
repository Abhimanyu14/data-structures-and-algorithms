package leetcode.leetcode_2180_count_integers_with_even_digit_sum

/**
 * leetcode - https://leetcode.com/problems/count-integers-with-even-digit-sum/
 *
 * TODO(Abhi) - To revisit to do using pattern
 * Source - https://leetcode.com/problems/count-integers-with-even-digit-sum/discuss/1784826/Java-O(1)-Solution-Only-check-one-number
 *
 * Data Structure - NA
 * Algorithm - Digit Extraction
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 */

/**
 * leetcode - https://leetcode.com/problems/count-integers-with-even-digit-sum/
 *
 * Data Structure - NA
 * Algorithm - Digit Extraction
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 1 ms, faster than 33.33%
 * Memory Usage: 34.8 MB, less than 33.33%
 *
 * Time -
 * Space -
 */
private fun countEven(num: Int): Int {
    var result = 0
    fun isDigitsSumEven(x: Int): Boolean {
        var sum = 0
        var temp = x
        while (temp != 0) {
            sum += temp % 10
            temp /= 10
        }
        return sum % 2 == 0
    }

    for (i in 1..num) {
        if (isDigitsSumEven(i)) {
            result++
        }
    }
    return result
}

private fun main() {

}
