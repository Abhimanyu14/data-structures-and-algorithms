package leetcode.leetcode_204_count_primes

/**
 * leetcode - https://leetcode.com/problems/count-primes/description/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [BooleanArray]
 * Algorithm - Sieve of Eratosthenes
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time - O(N * log(log(N)))
 * Space - O(N)
 *
 * Companies - Amazon, Apple, Google, Meta, Microsoft
 */
private fun countPrimes(n: Int): Int {
    if (n < 2) {
        return 0
    }
    val nums = BooleanArray(n) { true }
    nums[0] = false
    nums[1] = false
    for (i in 2..<n) {
        if (nums[i]) {
            for (j in (i * 2)..<n step i) {
                nums[j] = false
            }
        }
    }
    return nums.count { it }
}

private fun main() {

}
