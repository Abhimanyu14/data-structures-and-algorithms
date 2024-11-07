package leetcode.leetcode_771_jewels_and_stones

/**
 * leetcode - https://leetcode.com/problems/jewels-and-stones/
 *
 * Using string contains()
 *
 * Stats
 * Runtime: 336 ms, faster than 8.66%
 * Memory Usage: 35.9 MB, less than 28.85%
 */
private fun numJewelsInStonesUsingContains(jewels: String, stones: String): Int {
    var result = 0
    for (s in stones) {
        if (jewels.contains(s)) {
            result++
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/jewels-and-stones/
 *
 * Using string contains() and count()
 *
 * Stats
 * Runtime: 186 ms, faster than 77.88%
 * Memory Usage: 35.5 MB, less than 38.46%
 */
private fun numJewelsInStonesUsingCount(jewels: String, stones: String): Int {
    return stones.count { jewels.contains(it) }
}

/**
 * leetcode - https://leetcode.com/problems/jewels-and-stones/
 *
 * Using set contains() and string count()
 *
 * Stats
 * Runtime: 229 ms, faster than 72.12%
 * Memory Usage: 36.5 MB, less than 12.50%
 */
private fun numJewelsInStones(jewels: String, stones: String): Int {
    val set = jewels.toSet()
    return stones.count { set.contains(it) }
}

private fun main() {

}
