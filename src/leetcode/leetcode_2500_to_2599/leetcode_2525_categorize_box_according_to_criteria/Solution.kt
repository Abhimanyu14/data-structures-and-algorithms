package leetcode.leetcode_2500_to_2599.leetcode_2525_categorize_box_according_to_criteria

import kotlin.math.pow

/**
 * leetcode - https://leetcode.com/problems/categorize-box-according-to-criteria/
 *
 * Using conditional operators
 *
 * Stats
 * Runtime: 156 ms, faster than 100.00%
 * Memory Usage: 33.3 MB, less than 100.00%
 */
private fun categorizeBox(length: Int, width: Int, height: Int, mass: Int): String {
    val isBulky = (length >= 10.0.pow(4) ||
            width >= 10.0.pow(4) ||
            height >= 10.0.pow(4) ||
            (length.toDouble() * width * height) >= 10.0.pow(9)
            )
    val isHeavy = mass >= 100
    return if (isBulky) {
        if (isHeavy) {
            "Both"
        } else {
            "Bulky"
        }
    } else {
        if (isHeavy) {
            "Heavy"
        } else {
            "Neither"
        }
    }
}

private fun main() {
    println(
        categorizeBox(
            1000,
            1000,
            1000,
            1000,
        )
    )
}
