package leetcode.leet_0_to_99.leet_11_container_with_most_water

// TODO: Optimize solution
fun maxArea(height: IntArray): Int {
    var result = 0
    for (i in height.indices) {
        for (j in i + 1 until height.size) {
            result = maxOf(result, (j - i) * minOf(height[i], height[j]))
        }
    }
    return result
}

fun main() {
    val input1 = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    val input2 = intArrayOf(1, 1)
    val input3 = intArrayOf(4, 3, 2, 1, 4)
    val input4 = intArrayOf(1, 2, 1)
    println(maxArea(input1))
    println(maxArea(input2))
    println(maxArea(input3))
    println(maxArea(input4))
}
