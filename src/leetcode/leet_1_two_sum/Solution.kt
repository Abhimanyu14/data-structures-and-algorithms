package leetcode.leet_1_two_sum

fun twoSum(m: Int, arr: Array<Int>): Array<Int> {
    val map = hashMapOf<Int, Int>()
    for (i in arr.indices) {
        if (map.containsKey(m - arr[i])) {
            return arrayOf(map[m - arr[i]] ?: -1, i)
        }
        map[arr[i]] = i
    }
    return emptyArray()
}

fun main() {
    println(twoSum(4, arrayOf(1, 4, 5, 3, 2)).joinToString())
    println(twoSum(4, arrayOf(2, 2, 4, 3)).joinToString())
}
