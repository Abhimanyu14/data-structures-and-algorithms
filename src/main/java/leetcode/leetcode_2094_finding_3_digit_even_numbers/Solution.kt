package leetcode.leetcode_2094_finding_3_digit_even_numbers

/**
 * leetcode - https://leetcode.com/problems/finding-3-digit-even-numbers/?envType=daily-question&envId=2025-05-12
 *
 * Data Structure - [IntArray], [List]
 * Algorithm - Counting, Recursion
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google, Meta
 */
private fun findEvenNumbers(digits: IntArray): IntArray {
    val result = mutableListOf<Int>()
    val counter = IntArray(10)
    for (digit in digits) {
        counter[digit]++
    }
    fun generate(index: Int, current: Int) {
        var i = if (index == 0) {
            1
        } else {
            0
        }
        while (i <= 9) {
            if (counter[i] > 0) {
                counter[i]--
                if (index == 2) {
                    result.add((current * 10) + i)
                } else {
                    generate(index + 1, (current * 10) + i)
                }
                counter[i]++
            }
            if (index == 2) {
                i += 2
            } else {
                i++
            }
        }
    }
    generate(0, 0)
    return result.toIntArray()
}

private fun main() {

}
