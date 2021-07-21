package leetcode.leet_1920_build_array_from_permutation

fun buildArray(nums: IntArray): IntArray {
    val arr = IntArray(nums.size)
    for (i in nums.indices) {
        arr[i] = nums[nums[i]]
    }
    return arr
}

fun main() {
    val input1 = intArrayOf(0, 2, 1, 5, 3, 4)
    val input2 = intArrayOf(5, 0, 1, 2, 3, 4)
    println(buildArray(input1).joinToString(" "))
    println(buildArray(input2).joinToString(" "))
}
