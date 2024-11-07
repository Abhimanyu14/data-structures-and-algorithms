package leetcode.leetcode_1518_water_bottles

/**
 * leetcode - https://leetcode.com/problems/water-bottles/
 *
 * Using iteration
 *
 * Difficulty - Easy
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
    var result = numBottles
    var empty = numBottles
    while (empty >= numExchange) {
        result += (empty / numExchange)
        empty = (empty % numExchange) + (empty / numExchange)
    }
    return result
}

private fun main() {

}
