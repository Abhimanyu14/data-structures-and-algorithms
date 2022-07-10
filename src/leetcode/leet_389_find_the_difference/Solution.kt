package leetcode.leet_389_find_the_difference

/**
 * Using XOR
 *
 * Stats
 * Runtime: 256 ms, faster than 56.79%
 * Memory Usage: 34.9 MB, less than 90.12%
 */
fun findTheDifference(s: String, t: String): Char {
    // Leetcode does not support Char.code - use toInt() instead
    var result = 0
    s.forEach {
        result = result xor it.code
    }
    t.forEach {
        result = result xor it.code
    }
    return result.toChar()
}

/**
 * Naive solution
 *
 * Stats
 * Runtime: 292 ms, faster than 30.86%
 * Memory Usage: 35.8 MB, less than 38.27%
 */
fun findTheDifferenceNaiveSolution(s: String, t: String): Char {
    val map = hashMapOf<Char, Int>()
    s.forEach {
        map[it] = map[it]?.plus(1) ?: 1
    }
    t.forEach {
        if (!map.containsKey(it)) {
            return it
        }
        if (map[it] == 1) {
            map.remove(it)
        } else {
            map[it] = map[it]?.minus(1) ?: 1
        }
    }
    return '0'
}

fun main() {
    println(findTheDifference("abcd", "abcde"))
    println(findTheDifference("", "y"))
}
