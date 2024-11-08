package leetcode.leetcode_3285_find_indices_of_stable_mountains

/**
 * leetcode - https://leetcode.com/problems/find-indices-of-stable-mountains/
 *
 * Using list and iteration
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 18 ms, faster than 42.86%
 * Memory Usage: 39.5 MB, less than 14.29%
 *
 * Time -
 * Space -
 */
private fun stableMountains(height: IntArray, threshold: Int): List<Int> {
    val result = mutableListOf<Int>()
    for (i in 1..height.lastIndex) {
        if (height[i - 1] > threshold) {
            result.add(i)
        }
    }
    return result
}

private fun main() {

}
