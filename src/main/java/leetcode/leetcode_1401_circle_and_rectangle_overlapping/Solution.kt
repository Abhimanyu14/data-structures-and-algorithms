package leetcode.leetcode_1401_circle_and_rectangle_overlapping

/**
 * leetcode - https://leetcode.com/problems/circle-and-rectangle-overlapping/
 *
 * Using maths
 * Distance between two points
 *
 * Stats
 * Runtime: 110 ms, faster than 100.00%
 * Memory Usage: 33.1 MB, less than 100.00%
 */
private fun Int.square() = this * this
private fun checkOverlap(radius: Int, xCenter: Int, yCenter: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    if ((yCenter >= (y1 - radius)) && (yCenter <= (y2 + radius)) && (xCenter >= x1) && (xCenter <= x2)) {
        return true
    }
    if ((xCenter >= (x1 - radius)) && (xCenter <= (x2 + radius)) && (yCenter >= y1) && (yCenter <= y2)) {
        return true
    }
    if (radius.square() >= ((xCenter - x1).square() + (yCenter - y1).square())) {
        return true
    }
    if (radius.square() >= ((xCenter - x2).square() + (yCenter - y2).square())) {
        return true
    }
    if (radius.square() >= ((xCenter - x1).square() + (yCenter - y2).square())) {
        return true
    }
    if (radius.square() >= ((xCenter - x2).square() + (yCenter - y1).square())) {
        return true
    }
    return false
}

private fun main() {

}
