package leetcode.leetcode_1603_design_parking_system

/**
 * leetcode - https://leetcode.com/problems/design-parking-system/
 *
 * Using array
 *
 * Difficulty - Easy
 *
 * Stats
 * Runtime: 61 ms, faster than 47.06%
 * Memory Usage: 46.7 MB, less than 72.50%
 *
 * Time -
 * Space -
 */
private class ParkingSystem(big: Int, medium: Int, small: Int) {
    private val spaces = intArrayOf(big, medium, small)

    fun addCar(carType: Int): Boolean {
        if (spaces[carType - 1] > 0) {
            spaces[carType - 1]--
            return true
        }
        return false
    }
}

private fun main() {

}
