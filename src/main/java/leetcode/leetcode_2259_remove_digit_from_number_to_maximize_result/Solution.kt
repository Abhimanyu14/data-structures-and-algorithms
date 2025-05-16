package leetcode.leetcode_2259_remove_digit_from_number_to_maximize_result

/**
 * leetcode - https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/description/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 *
 * Data Structure - [String]
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun removeDigit(number: String, digit: Char): String {
    var candidate = -1
    for (i in number.indices) {
        if (number[i] == digit) {
            candidate = i
            if (i == number.lastIndex) {
                return number.substring(0, number.lastIndex)
            }
            if (number[i + 1] > number[i]) {
                return number.substring(0, i) + number.substring(i + 1, number.length)
            }
        }
    }
    return number.substring(0, candidate) + number.substring(candidate+ 1, number.length)
}

private fun main() {

}
