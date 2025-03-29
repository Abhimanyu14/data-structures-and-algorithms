package hackerrank.practice.icecream_parlor

/**
 * Using map = O(n)
 */
fun icecreamParlorUsingMap(m: Int, arr: Array<Int>): Array<Int> {
    val map = hashMapOf<Int, Int>()
    for (i in arr.indices) {
        if (map.containsKey(m - arr[i])) {
            return arrayOf((map[m - arr[i]] ?: -1) + 1, i + 1)
        }
        map[arr[i]] = i
    }
    return emptyArray()
}

fun icecreamParlor(m: Int, arr: Array<Int>): Array<Int> {
    for (i in arr.indices) {
        for (j in i + 1..arr.lastIndex) {
            if (arr[i] + arr[j] == m) {
                return arrayOf(i + 1, j + 1)
            }
        }
    }
    return emptyArray()
}

private fun main() {
    println(icecreamParlorUsingMap(4, arrayOf(1, 4, 5, 3, 2)).joinToString())
    println(icecreamParlorUsingMap(4, arrayOf(2, 2, 4, 3)).joinToString())
}
