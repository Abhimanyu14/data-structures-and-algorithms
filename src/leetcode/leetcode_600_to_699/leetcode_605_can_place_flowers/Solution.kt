package leetcode.leetcode_600_to_699.leetcode_605_can_place_flowers

/**
 * leetcode - https://leetcode.com/problems/can-place-flowers/
 *
 * Using loops and conditionals
 *
 * Stats
 * Runtime: 226 ms, faster than 24.17%
 * Memory Usage: 39.6 MB, less than 12.50%
 */
private fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var remaining = n
    var i = 0
    while (remaining > 0 && i < flowerbed.size) {
        if (flowerbed[i] == 0) {
            if (i == flowerbed.lastIndex) {
                remaining--
            } else {
                if (flowerbed[i + 1] == 0) {
                    remaining--
                    i++
                }
            }
            i++
        } else {
            i += 2
        }
    }
    return remaining == 0
}

private fun main() {

}
