package leetcode.leet_1800_to_1899.leet_1837_sum_of_digits_in_base_k

/**
 * leetcode - https://leetcode.com/problems/sum-of-digits-in-base-k/
 *
 * TODO(Abhi) - To revisit
 *
 * Using modulo and sum
 *
 * Stats
 * Runtime: 128 ms, faster than 100.00%
 * Memory Usage: 33.1 MB, less than 100.00%
 */
private fun sumBase(n: Int, k: Int): Int {
    var result = 0
    var temp = n
    while (temp != 0) {
        result += temp % k
        temp /= k
    }
    return result
}

private fun main() {

}
