package leetcode.leet_600_to_699.leet_650_2_keys_keyboard

/**
 * leetcode - https://leetcode.com/problems/2-keys-keyboard/?envType=daily-question&envId=2024-08-19
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun minSteps(n: Int): Int {
    var current = n
    var result = 0
    var d = 2
    while (current > 1) {
        // If d is prime factor, keep dividing
        // n by d until is no longer divisible
        while (current % d == 0) {
            result += d
            current /= d
        }
        d++
    }
    return result
}

private fun main() {

}
