package leetcode.leet_300_to_399.leet_389_find_the_difference

/**
 * leetcode - https://leetcode.com/problems/find-the-difference/
 *
 * Using Bitwise operator - XOR
 *
 * Stats
 * Runtime: 146 ms, faster than 82.69%
 * Memory Usage: 34.6 MB, less than 78.85%
 */
private fun findTheDifference(s: String, t: String): Char {
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
 * leetcode - https://leetcode.com/problems/find-the-difference/
 *
 * Using Map
 *
 * Stats
 * Runtime: 140 ms, faster than 90.38%
 * Memory Usage: 34.3 MB, less than 93.27%
 */
private fun findTheDifferenceUsingArray(s: String, t: String): Char {
    val counter = IntArray(26)
    for (i in s.indices) {
        counter[s[i] - 'a']++
    }
    for (i in t.indices) {
        counter[t[i] - 'a']--
        if (counter[t[i] - 'a'] < 0) {
            return t[i]
        }
    }
    return 'a'
}

/**
 * leetcode - https://leetcode.com/problems/find-the-difference/
 *
 * Using Map
 *
 * Stats
 * Runtime: 292 ms, faster than 30.86%
 * Memory Usage: 35.8 MB, less than 38.27%
 */
private fun findTheDifferenceUsingMap(s: String, t: String): Char {
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

private fun main() {
    println(findTheDifference("abcd", "abcde"))
    println(findTheDifference("", "y"))
}
