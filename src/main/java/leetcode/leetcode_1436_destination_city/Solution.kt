package leetcode.leetcode_1436_destination_city


/**
 * leetcode - https://leetcode.com/problems/destination-city/
 *
 * Using set
 *
 * Stats
 * Runtime: 191 ms, faster than 38.78%
 * Memory Usage: 36.5 MB, less than 95.92%
 */
private fun destCity(paths: List<List<String>>): String {
    val set = mutableSetOf<String>()
    paths.forEach { path ->
        set.add(path[0])
    }
    paths.forEach { path ->
        if (!set.contains(path[1])) {
            return path[1]
        }
    }
    return ""
}

/**
 * leetcode - https://leetcode.com/problems/destination-city/
 *
 * Using set
 *
 * Stats
 * Runtime: 211 ms, faster than 8.82%
 * Memory Usage: 37.6 MB, less than 50.00%
 */
private fun destCityUsingTwoSet(paths: List<List<String>>): String {
    val from = mutableSetOf<String>()
    val to = mutableSetOf<String>()
    paths.forEach {
        from.add(it[0])
        to.add(it[1])
    }
    return (to - from).first()
}

private fun main() {

}
