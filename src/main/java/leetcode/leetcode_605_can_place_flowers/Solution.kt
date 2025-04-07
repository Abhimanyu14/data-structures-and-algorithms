package leetcode.leetcode_605_can_place_flowers

/**
 * leetcode - https://leetcode.com/problems/can-place-flowers/
 *
 * Data Structure - [IntArray]
 * Algorithm - Iteration, Three Pointer
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 12 ms, faster than 24.22%
 * Memory Usage: 47.49 MB, less than 50.97%
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies - Meta
 */
private fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var remaining = n
    var index = 0
    while (remaining > 0 && index <= flowerbed.lastIndex) {
        if (flowerbed[index] == 0) {
            if (index == flowerbed.lastIndex || flowerbed[index + 1] == 0) {
                remaining--
                index += 2
            } else {
                index++
            }
        } else {
            index += 2
        }
    }
    return remaining == 0
}

private fun main() {

}
