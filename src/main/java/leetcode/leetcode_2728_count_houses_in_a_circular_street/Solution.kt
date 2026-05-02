package leetcode.leetcode_2728_count_houses_in_a_circular_street

/**
 * leetcode - https://leetcode.com/problems/count-houses-in-a-circular-street/
 *
 * Data Structure - [Circular Array]
 * Algorithm - Iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time - O(N)
 * Space - O(1)
 *
 * Companies -
 */
private abstract class Street(doors: IntArray) {
    abstract fun openDoor()
    abstract fun closeDoor()
    abstract fun isDoorOpen(): Boolean
    abstract fun moveRight()
    abstract fun moveLeft()
}

private fun houseCount(street: Street, k: Int): Int {
    for (i in 0..<k) {
        street.closeDoor()
        street.moveRight()
    }
    var result = 0
    while (!street.isDoorOpen()) {
        result++
        street.openDoor()
        street.moveRight()
    }
    return result
}

private fun main() {

}
