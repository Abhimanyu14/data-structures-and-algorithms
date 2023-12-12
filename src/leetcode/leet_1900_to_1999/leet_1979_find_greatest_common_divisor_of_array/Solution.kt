package leetcode.leet_1900_to_1999.leet_1979_find_greatest_common_divisor_of_array

/**
 * leetcode - https://leetcode.com/problems/find-greatest-common-divisor-of-array/
 *
 * Using GCD
 *
 * Stats
 * Runtime: 231 ms, faster than 25.00%
 * Memory Usage: 38.7 MB, less than 35.00%
 */
private fun findGCD(nums: IntArray): Int {
    tailrec fun gcd(a: Int, b: Int): Int {
        return if (b == 0) {
            a
        } else {
            gcd(b, a % b)
        }
    }

    var smallest = nums[0]
    var largest = nums[0]
    for (i in 1..nums.lastIndex) {
        if (nums[i] > largest) {
            largest = nums[i]
        }
        if (nums[i] < smallest) {
            smallest = nums[i]
        }
    }
    return gcd(largest, smallest)
}

private fun main() {

}
