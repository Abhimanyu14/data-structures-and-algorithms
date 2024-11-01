package leetcode.leetcode_1300_to_1399.leetcode_1359_count_all_valid_pickup_and_delivery_options

/**
 * leetcode - https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
 *
 * Using permutations and combinations - Mathematics
 *
 * Stats
 * Runtime: 130 ms, faster than 100.00%
 * Memory Usage: 33.3 MB, less than 100.00%
 */
private fun countOrders(n: Int): Int {
    var ans: Long = 1
    val mod = 1_000_000_007
    for (i in 1..n) {
        // Ways to arrange all pickups, 1*2*3*4*5*...*n
        ans *= i
        // Ways to arrange all deliveries, 1*3*5*...*(2n-1)
        ans *= (2 * i - 1)
        ans %= mod.toLong()
    }
    return ans.toInt()
}

fun getAllCombinations(n: Int): List<List<String>> {
    val list = buildList {
        repeat(n) {
            add("P${it + 1}")
        }
    }

    fun createPermutations(stringsList: List<String>): List<List<String>> {
        val permutations = mutableListOf<List<String>>()
        fun getPermutation(currentList: List<String>, remainingStringsList: List<String>) {
            if (remainingStringsList.isEmpty()) {
                permutations.add(currentList)
                return
            }
            remainingStringsList.forEach {
                if (it[0] == 'P') {
                    getPermutation(currentList + it, remainingStringsList - it + "D${it[1]}")
                } else {
                    getPermutation(currentList + it, remainingStringsList - it)
                }
            }
        }
        getPermutation(emptyList(), stringsList.toList())
        return permutations
    }

    return createPermutations(list.toList())
}

private fun main() {
//    println(countOrders(1))
    println(countOrders(2))
    println(countOrders(3))
//    println(countOrders(4))
//    println(countOrders(5))
}
