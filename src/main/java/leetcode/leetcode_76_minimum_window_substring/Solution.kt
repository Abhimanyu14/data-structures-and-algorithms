package leetcode.leetcode_76_minimum_window_substring

/**
 * leetcode - https://leetcode.com/problems/minimum-window-substring/
 *
 * Data Structure - Map and Two Pointers
 * Algorithm - - Sliding window
 *
 * Difficulty - Hard
 *
 * Stats
 * Runtime: 94 ms, faster than 39.44%
 * Memory Usage: 43.7 MB, less than 25.14%
 *
 * Time -
 * Space -
 */
private fun minWindow(s: String, t: String): String {
    var minWindowSize = Int.MAX_VALUE
    var start = -1
    var end = -1
    val tCounter = mutableMapOf<Char, Int>()
    val currentCounter = mutableMapOf<Char, Int>()
    t.forEach {
        tCounter[it] = tCounter.getOrDefault(it, 0) + 1
    }
    fun isValid(): Boolean {
        for ((key, value) in tCounter) {
            if (currentCounter.getOrDefault(key, 0) < value) {
                return false
            }
        }
        return true
    }
    var left = 0
    var right = 0
    while (right <= s.lastIndex) {
        currentCounter[s[right]] = currentCounter.getOrDefault(s[right], 0) + 1
        while (isValid()) {
            if ((right - left + 1) < minWindowSize) {
                start = left
                end = right
                minWindowSize = (right - left + 1)
            }
            currentCounter[s[left]] = currentCounter.getOrDefault(s[left], 0) - 1
            left++
        }
        right++
    }

    return if (start != -1) {
        s.substring(start, end + 1)
    }  else {
        ""
    }
}

private fun minWindowUsingSlidingWindow(s: String, t: String): String {
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
    while ((left < right) && (windowCounter.getOrDefault(s[left], 0) > tCounter.getOrDefault(s[left], 0))) {
        windowCounter[s[left]] = windowCounter.getOrDefault(s[left], 0) - 1
        left++
    }

    var temp = s.substring(left, right + 1)
    var result = temp

    while (right < s.lastIndex) {
        right++
        windowCounter[s[right]] = windowCounter.getOrDefault(s[right], 0) + 1
        while ((left < right) && (windowCounter.getOrDefault(s[left], 0) > tCounter.getOrDefault(s[left], 0))) {
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
