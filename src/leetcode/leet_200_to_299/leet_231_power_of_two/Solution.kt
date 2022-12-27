package leetcode.leet_200_to_299.leet_231_power_of_two

/**
 * Stats
 * Runtime: 232 ms, faster than 18.42%
 * Memory Usage: 35.4 MB, less than 94.74%
 */
fun isPowerOfTwo(n: Int): Boolean {
    var ele = n
    while (ele % 2 == 0 && ele > 0) {
        ele /= 2
    }
    return ele == 1
}

// TODO-Abhi: Using bitwise operations
fun main() {
    val input1 = 1
    val input2 = 16
    val input3 = 3
    val input4 = 4
    val input5 = 5
    println(isPowerOfTwo(input1))
    println(isPowerOfTwo(input2))
    println(isPowerOfTwo(input3))
    println(isPowerOfTwo(input4))
    println(isPowerOfTwo(input5))
}
