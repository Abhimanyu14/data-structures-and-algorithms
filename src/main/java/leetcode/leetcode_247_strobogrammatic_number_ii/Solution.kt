package leetcode.leetcode_247_strobogrammatic_number_ii

/**
 * leetcode - https://leetcode.com/problems/strobogrammatic-number-ii/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 *
 * Data Structure -
 * Algorithm - Recursion
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google, Meta
 */
private fun findStrobogrammatic(n: Int): List<String> {
    if (n == 1) {
        return listOf("0", "1", "8")
    }
    val result = mutableListOf<String>()
    val chars = CharArray(n) { '0' }

    fun fill(index: Int) {
        if (n % 2 == 0 && index == n / 2) {
            result.add(String(chars))
            return
        } else if (n % 2 == 1 && index > n / 2) {
            result.add(String(chars))
            return
        }
        if (n % 2 == 1 && index == n / 2) {
            chars[index] = '0'
            fill(index + 1)
            chars[index] = '1'
            fill(index + 1)
            chars[index] = '8'
            fill(index + 1)
        } else {
            if (index > 0) {
                chars[index] = '0'
                chars[n - 1 - index] = '0'
                fill(index + 1)
            }
            chars[index] = '1'
            chars[n - 1 - index] = '1'
            fill(index + 1)
            chars[index] = '6'
            chars[n - 1 - index] = '9'
            fill(index + 1)
            chars[index] = '8'
            chars[n - 1 - index] = '8'
            fill(index + 1)
            chars[index] = '9'
            chars[n - 1 - index] = '6'
            fill(index + 1)
        }
    }
    fill(0)

    return result
}

private fun main() {

}
