package leetcode.leet_1400_to_1499.leet_1436_destination_city

/**
 * leetcode - https://leetcode.com/problems/destination-city/
 *
 * Using set
 *
 * Stats
 * Runtime: 211 ms, faster than 8.82%
 * Memory Usage: 37.6 MB, less than 50.00%
 */
private fun destCity(paths: List<List<String>>): String {
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
