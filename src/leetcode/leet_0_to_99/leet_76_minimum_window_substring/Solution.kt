package leetcode.leet_0_to_99.leet_76_minimum_window_substring

/**
 * leetcode - https://leetcode.com/problems/minimum-window-substring/
 *
 * Using map - Sliding window
 *
 * Stats
 * Runtime: 474 ms, faster than 24.24%
 * Memory Usage: 42 MB, less than 26.41%
 */
private     fun minWindow(s: String, t: String): String {
    if (t.length > s.length) {
        return ""
    }

    val tCounter = mutableMapOf<Char, Int>()
    t.forEach {
        tCounter[it] = tCounter.getOrDefault(it, 0) + 1
    }
    var left = 0
    while (left < s.length && !tCounter.contains(s[left])) {
        left++
    }
    if (left == s.length) {
        return ""
    }

    var right = left
    val windowCounter = mutableMapOf<Char, Int>()
    windowCounter[s[left]] = 1

    fun isValid(): Boolean {
        for ((key, value) in tCounter) {
            if (windowCounter.getOrDefault(key, 0) < value) {
                return false
            }
        }
        return true
    }

    while (right < s.lastIndex && !isValid()) {
        right++
        windowCounter[s[right]] = windowCounter.getOrDefault(s[right], 0) + 1
    }
    if (!isValid()) {
        return ""
    }
    while ( (left < right) && (windowCounter.getOrDefault(s[left], 0) > tCounter.getOrDefault(s[left], 0)) ) {
        windowCounter[s[left]] = windowCounter.getOrDefault(s[left], 0) - 1
        left++
    }

    var temp = s.substring(left, right + 1)
    var result = temp

    while (right < s.lastIndex) {
        right++
        windowCounter[s[right]] = windowCounter.getOrDefault(s[right], 0) + 1
        while ( (left < right) && (windowCounter.getOrDefault(s[left], 0) > tCounter.getOrDefault(s[left], 0)) ) {
            windowCounter[s[left]] = windowCounter.getOrDefault(s[left], 0) - 1
            left++
        }

        temp = s.substring(left, right + 1)
        if (temp.length < result.length) {
            result = temp
        }
    }
    return result
}

private fun main() {

}
