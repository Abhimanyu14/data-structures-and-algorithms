package leetcode.leet_1500_to_1599.leet_1561_maximum_number_of_coins_you_can_get

/**
 * leetcode - https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
 *
 * Using sorting
 *
 * Stats
 * Runtime: 422 ms, faster than 72.73%
 * Memory Usage: 52.6 MB, less than 63.64%
 */
private fun maxCoins(piles: IntArray): Int {
    var result = 0
    piles.sort()
    for (i in (piles.lastIndex - 1 downTo (piles.size / 3)) step 2) {
        result += piles[i]
    }
    return result
}

private fun main() {

}
