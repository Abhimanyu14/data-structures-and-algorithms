package leetcode.leetcode_246_strobogrammatic_number

/**
 * leetcode - https://leetcode.com/problems/strobogrammatic-number/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 * Premium Question
 *
 * Data Structure - [Map]
 * Algorithm - Iteration and Hashing
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun isStrobogrammatic(num: String): Boolean {
    val strobogrammaticCharMap = mapOf('1' to '1', '6' to '9', '8' to '8', '9' to '6', '0' to '0')
    var left = 0
    var right = num.lastIndex
    while (left <= right) {
        if (strobogrammaticCharMap.contains(num[left]) &&
            strobogrammaticCharMap.contains(num[right]) &&
            strobogrammaticCharMap[num[left]] == num[right]
        ) {
            left++
            right--
        } else {
            return false
        }
    }
    return true
}

private fun main() {

}
