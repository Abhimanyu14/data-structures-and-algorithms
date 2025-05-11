package leetcode.leetcode_3343_count_number_of_balanced_permutations

/**
 * leetcode - https://leetcode.com/problems/count-number-of-balanced-permutations/description/?envType=daily-question&envId=2025-05-09
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [IntArray]
 * Algorithm - Recursion
 *
 * Difficulty - Hard
 *
 * Stats
 * Time Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun countBalancedPermutations(num: String): Int {
    var sum = 0
    val digitsCounter = IntArray(10)
    for (char in num) {
        sum += char.digitToInt()
        digitsCounter[char - '0']++
    }
    if (sum % 2 == 1) {
        return 0
    }
    val cache = mutableMapOf<String, Int>()

    fun countBalancedPermutations(index: Int, odd: Int, even: Int): Int {
        cache["${digitsCounter.joinToString("#")}#$odd"]?.let {
            return it
        }
        if (odd > sum / 2 || even > sum / 2) {
            cache["${digitsCounter.joinToString("#")}#$odd"] = 0
            return 0
        }
        if (index == num.length) {
            if (odd == even) {
                cache["${digitsCounter.joinToString("#")}#$odd"] = 1
                return 1
            }
            cache["${digitsCounter.joinToString("#")}#$odd"] = 0
            return 0
        }
        var result = 0
        for (i in 0..9) {
            if (digitsCounter[i] > 0) {
                digitsCounter[i]--
                result = if (index % 2 == 0) {
                    (result + countBalancedPermutations(index + 1, odd, even + i)) % 1_000_000_007
                } else {
                    (result + countBalancedPermutations(index + 1, odd + i, even)) % 1_000_000_007
                }
                digitsCounter[i]++
            }
        }
        cache["${digitsCounter.joinToString("#")}#$odd"] = result
        return result
    }
    return countBalancedPermutations(0, 0, 0)
}

/**
 * leetcode - https://leetcode.com/problems/count-number-of-balanced-permutations/description/?envType=daily-question&envId=2025-05-09
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [StringBuilder], [List]
 * Algorithm - Recursion
 *
 * Difficulty - Hard
 *
 * Stats
 * Memory Limit Exceeded
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun countBalancedPermutationsUsingStringBuilder(num: String): Int {
    val digitsCounter = IntArray(10)
    for (char in num) {
        digitsCounter[char - '0']++
    }

    fun isBalanced(string: String): Boolean {
        var sum = 0
        for (i in string.indices) {
            if (i % 2 == 0) {
                sum += string[i].digitToInt()
            } else {
                sum -= string[i].digitToInt()
            }
        }
        return sum == 0
    }

    val permutations = mutableListOf<String>()
    fun generatePermutations(current: StringBuilder) {
        if (current.length == num.length) {
            permutations.add(current.toString())
            return
        }
        for (i in 0..9) {
            if (digitsCounter[i] > 0) {
                digitsCounter[i]--
                current.append('0' + i)
                generatePermutations(current)
                current.deleteCharAt(current.lastIndex)
                digitsCounter[i]++
            }
        }
    }

    var result = 0
    generatePermutations(StringBuilder())
    for (i in permutations.indices) {
        if (isBalanced(permutations[i])) {
            result++
        }
    }
    return result
}

private fun main() {

}
