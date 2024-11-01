package leetcode.leetcode_1300_to_1399.leetcode_1353_maximum_number_of_events_that_can_be_attended

/**
 * leetcode -
 *
 * Using
 *
 * Stats
 *
 */
private fun maxEvents(events: Array<IntArray>): Int {
    events.sortWith(compareBy({ it[1] }, { it[0] }))
    events.sortWith { a: IntArray, b: IntArray ->
        if (a[1] == b[1]) {
            a[0] - b[0]
        } else {
            a[1] - b[1]
        }
    }
    val resultSet = mutableSetOf<Int>()
    events.forEach {
        var day = it[0]
        while (day <= it[1] && resultSet.contains(day)) {
            day++
        }
        if (day <= it[1]) {
            resultSet.add(day)
        }
    }
    return resultSet.size
}

private fun main() {
    println(
        maxEvents(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
            )
        )
    )
    println(
        maxEvents(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(1, 2),
            )
        )
    )
}
