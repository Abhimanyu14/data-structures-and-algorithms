package leetcode.leetcode_1088_confusing_number_ii

/**
 * Using DFS, linkedMapOf,
 *
 * leetcode - https://leetcode.com/problems/confusing-number-ii/
 *
 * Stats
 * Runtime: 314 ms, faster than 100.00%
 * Memory Usage: 38 MB, less than 100.00%
 */
private fun confusingNumberII(n: Int): Int {
    val digits = charArrayOf('0', '1', '6', '8', '9')
    fun rotatedDigit(c: Char): Char {
        return when (c) {
            '0', '1', '8' -> c
            '6' -> '9'
            '9' -> '6'
            else -> '?'
        }
    }
    fun dfs(s: String, smaller: Boolean, num: StringBuilder): Int {
        if (num.length == s.length) {
            var zeros = 0
            while (zeros < num.length && num[zeros] == '0') {
                zeros++
            }
            val temp = num.substring(zeros)
            var start = 0
            var end = temp.lastIndex
            while (start <= end) {
                if (temp[start] != rotatedDigit(temp[end])) {
                    return 1
                }
                ++start
                --end
            }
            return 0
        }
        var ans = 0
        for (c in digits) {
            if (!smaller && c > s[num.length]) {
                break
            }
            num.append(c)
            ans += dfs(s, smaller || c < s[num.lastIndex], num)
            num.setLength(num.length - 1)
        }
        return ans
    }
    return dfs(n.toString(), false, StringBuilder())
}

private fun main() {
    println(confusingNumberII(20))
}
