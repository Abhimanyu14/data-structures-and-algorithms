package leetcode.leetcode_583_delete_operation_for_two_strings

/**
 * leetcode - https://leetcode.com/problems/delete-operation-for-two-strings/submissions/1703595066/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [Array], [IntArray]
 * Algorithm - Dynamic Programming - Memoization (Recursion)
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(M * N)
 * Space - O(M * N)
 *
 * Companies - Amazon, Google, Microsoft
 */
private fun minDistance(word1: String, word2: String): Int {
    val cache = Array(501) {
        IntArray(501) { -1 }
    }
    fun minDelete(index1: Int, index2: Int): Int {
        if (cache[index1][index2] != -1) {
            return cache[index1][index2]
        }
        if (index1 == word1.length) {
            cache[index1][index2] = word2.length - index2
            return cache[index1][index2]
        }
        if (index2 == word2.length) {
            cache[index1][index2] = word1.length - index1
            return cache[index1][index2]
        }
        if (word1[index1] == word2[index2]) {
            cache[index1][index2] = minDelete(index1 + 1, index2 + 1)
            return cache[index1][index2]
        }
        cache[index1][index2] = minOf(minDelete(index1 + 1, index2), minDelete(index1, index2 + 1)) + 1
        return cache[index1][index2]
    }
    return minDelete(0, 0)
}

private fun main() {

}
