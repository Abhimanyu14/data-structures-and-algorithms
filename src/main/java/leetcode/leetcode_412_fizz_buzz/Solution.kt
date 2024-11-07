package leetcode.leetcode_412_fizz_buzz

/**
 * leetcode - https://leetcode.com/problems/fizz-buzz/
 *
 * Using loop
 *
 * Stats
 * Runtime: 275 ms, faster than 77.65%
 * Memory Usage: 41.7 MB, less than 74.50%
 */
private fun fizzBuzzBruteForce(n: Int): List<String> {
    val result = mutableListOf<String>()
    for (i in 1..n) {
        if (i % 15 == 0) {
            result.add("FizzBuzz")
        } else if (i % 5 == 0) {
            result.add("Buzz")
        } else if (i % 3 == 0) {
            result.add("Fizz")
        } else {
            result.add("$i")
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/fizz-buzz/
 *
 * Using string concatenation and map
 *
 * Stats
 * Runtime: 451 ms, faster than 5.46%
 * Memory Usage: 49.1 MB, less than 5.13%
 */
private fun fizzBuzz(n: Int): List<String> {
    val map = mapOf(
        3 to "Fizz",
        5 to "Buzz"
    )
    val divisors = listOf(3, 5)
    val result = mutableListOf<String>()
    val sb = StringBuilder()
    for (i in 1..n) {
        divisors.forEach {
            if (i % it == 0) {
                sb.append(map[it])
            }
        }
        if (sb.toString() == "") {
            sb.append("$i")
        }
        result.add(sb.toString())
        sb.clear()
    }
    return result
}

private fun main() {

}
