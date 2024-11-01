package leetcode.leetcode_1400_to_1499.leetcode_1404_number_of_steps_to_reduce_a_number_in_binary_representation_to_one

/**
 * leetcode - https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/?envType=daily-question&envId=2024-05-29
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun numSteps(s: String): Int {
    var result = 0
    var carry = 0
    for (i in s.lastIndex downTo 1) {
        when (s[i].digitToInt() + carry) {
            0 -> {
                result++
            }

            1 -> {
                result += 2
                carry = 1
            }

            else -> {
                result += 1
                carry = 1
            }
        }
    }
    if (carry == 1) {
        result++
    }
    return result
}

private fun main() {

}
