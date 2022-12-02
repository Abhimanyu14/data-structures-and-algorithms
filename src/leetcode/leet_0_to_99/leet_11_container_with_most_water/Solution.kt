package leetcode.leet_0_to_99.leet_11_container_with_most_water

/**
 * Using loops
 *
 * Stats
 * Time limit exceeded
 */
private fun maxAreaNaive(height: IntArray): Int {
    var result = 0
    for (i in height.indices) {
        for (j in i + 1 until height.size) {
            result = maxOf(result, (j - i) * minOf(height[i], height[j]))
        }
    }
    return result
}

/**
 * Using two pointers
 *
 * Stats
 * Runtime: 967 ms, faster than 7.24%
 * Memory Usage: 82.9 MB, less than 51.46%
 */
private fun maxArea(height: IntArray): Int {
    var max = 0
    var left = 0
    var right = height.lastIndex
    var vol: Int
    while (left < right) {
        vol = minOf(height[left], height[right]) * (right - left)
        if (max < vol) {
            max = vol
        }
        if (height[right] <= height[left]) {
            right--
        } else {
            left++
        }
    }
    return max
}

private fun main() {
    val input1 = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    val input2 = intArrayOf(1, 1)
    val input3 = intArrayOf(4, 3, 2, 1, 4)
    val input4 = intArrayOf(1, 2, 1)
    println(maxArea(input1))
    println(maxArea(input2))
    println(maxArea(input3))
    println(maxArea(input4))
}
