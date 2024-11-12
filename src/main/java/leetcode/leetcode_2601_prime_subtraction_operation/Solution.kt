package leetcode.leetcode_2601_prime_subtraction_operation

/**
 * leetcode - https://leetcode.com/problems/prime-subtraction-operation/?envType=daily-question&envId=2024-11-11
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun primeSubOperation(nums: IntArray): Boolean {
    val n = 1000
    val primes = mutableListOf<Int>()
    val prevPrimes = Array<Pair<Int, Int>?>(n) { null }
    prevPrimes[0] = Pair(-1, -1)
    prevPrimes[1] = Pair(-1, -1)
    var lastPrime = 2
    for (i in 2..<n) {
        if (prevPrimes[i] == null) {
            primes.add(i)
            lastPrime = i
            prevPrimes[i] = Pair(lastPrime, primes.lastIndex)
            for (j in 2..((n - 1) / i)) {
                prevPrimes[i * j] = Pair(-1, -1)
            }
        } else {
            prevPrimes[i] = Pair(lastPrime, primes.lastIndex)
        }
    }
    for (i in (nums.lastIndex - 1)..0) {
        if (nums[i + 1] <= nums[i]) {
            var j = 2
            while (j <= (prevPrimes[i]?.second ?: 0) && (nums[i + 1] <= nums[i] - primes[j])) {
                j++
            }
            if (j == (prevPrimes[i]?.second ?: 0)) {
                return false
            } else {
                nums[i] -= primes[j]
            }
        }
    }
    return true
}

private fun main() {

}
