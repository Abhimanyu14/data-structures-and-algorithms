package leetcode.leetcode_3483_unique_3_digit_even_numbers

/**
 * leetcode - https://leetcode.com/problems/unique-3-digit-even-numbers/description/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google
 */
private fun totalNumbers(digits: IntArray): Int {
    val set = mutableSetOf<Int>()
    for (i in digits.indices) {
        if (digits[i] == 0) {
            continue
        }
        for (j in digits.indices) {
            if (i == j) {
                continue
            }
            for (k in digits.indices) {
                if (i != k && j != k && digits[k] % 2 == 0) {
                    set.add(digits[i] * 100 + digits[j] * 10 + digits[k])
                }
            }
        }
    }
    return set.size
}

private fun main() {

}
