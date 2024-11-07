package leetcode.leetcode_989_add_to_array_form_of_integer

/**
 * leetcode - https://leetcode.com/problems/add-to-array-form-of-integer/
 *
 * Using list and reversed()
 *
 * Stats
 * Runtime: 496 ms, faster than 70.00%
 * Memory Usage: 41.3 MB, less than 75.00%
 */
fun addToArrayForm(num: IntArray, k: Int): List<Int> {
    val result = mutableListOf<Int>()
    var carry = 0
    var temp = k
    var pos = num.lastIndex
    while (temp != 0 || pos >= 0 || carry > 0) {
        val x = if (pos < 0) {
            0
        } else {
            num[pos]
        }
        val sum = x + temp % 10 + carry
        carry = sum / 10
        result.add(sum % 10)
        temp /= 10
        pos--
    }
    return result.reversed()
}

private fun main() {

}
