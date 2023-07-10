package leetcode.leet_800_to_899.leet_888_fair_candy_swap

/**
 * leetcode - https://leetcode.com/problems/fair-candy-swap/
 *
 * Using set
 *
 * Stats
 * Runtime: 717 ms, faster than 63.16%
 * Memory Usage: 71.1 MB, less than 63.16%
 */
private fun fairCandySwap(aliceSizes: IntArray, bobSizes: IntArray): IntArray {
    val aliceSet = mutableSetOf<Int>()
    val bobSet = mutableSetOf<Int>()
    var aliceSum = 0
    var bobSum = 0
    aliceSizes.forEach {
        aliceSet.add(it)
        aliceSum += it
    }
    bobSizes.forEach {
        bobSet.add(it)
        bobSum += it
    }
    val diff = (aliceSum - bobSum) / 2
    aliceSet.forEach {
        if (bobSet.contains(it - diff)) {
            return intArrayOf(it, it - diff)
        }
    }
    return intArrayOf(-1, -1)
}

private fun main() {

}
