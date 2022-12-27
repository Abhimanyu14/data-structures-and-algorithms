package leetcode.leet_1000_to_1099.leet_1088_confusing_number_ii

/**
 * leetcode - https://leetcode.com/problems/confusing-number-ii/
 *
 * Using
 *
 * Stats
 *
 */

private fun dfs(
    s: String,
    smaller: Boolean,
    num: StringBuilder,
): Int {
    val map = linkedMapOf(
        '1' to '1',
        '6' to '9',
        '8' to '8',
        '9' to '6',
        '0' to '0',
    )
    if (num.length == s.length) {
        var zeros = 0
        while (zeros < num.length && num[zeros] == '0') {
            zeros++
        }
        // Remove the leading 0s.
        val temp = num.substring(zeros)
        var i = 0
        var j = temp.length - 1
        while (i <= j) {
            if (temp[i] != map[temp[j]]) {
                return 1
            }
            i++
            j--
        }
        return 0
    }
    var ans = 0
    for (c in map.keys) {
        if (!smaller && c > s[num.length]) {
            break
        }
        num.append(c)
        ans += dfs(s, smaller || c < s[num.length - 1], num)
        num.setLength(num.length - 1)
    }
    return ans
}

fun confusingNumberII(n: Int): Int {
    return dfs(
        s = n.toString(),
        smaller = false,
        num = StringBuilder(),
    )
}

private fun main() {
    println(confusingNumberII(20))
}
