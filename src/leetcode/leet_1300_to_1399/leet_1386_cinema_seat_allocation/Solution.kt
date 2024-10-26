package leetcode.leet_1300_to_1399.leet_1386_cinema_seat_allocation

/**
 * leetcode - https://leetcode.com/problems/cinema-seat-allocation/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
private fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
    val reservedMap = mutableMapOf<Int, MutableSet<Int>>()
    reservedSeats.forEach {
        if (it[1] != 1 && it[1] != 10) {
            reservedMap.computeIfAbsent(it[0]) {
                mutableSetOf()
            }.add(it[1])
        }
    }
    var result = 0
    repeat(n) {
        if (reservedMap[it] == null) {
            result += 2
        } else {
            val set = reservedMap.getOrDefault(it, mutableSetOf())
            if ((set intersect setOf(4, 5)).isEmpty()) {
                if ((set intersect setOf(2, 3)).isEmpty()) {
                    result++
                    if ((set intersect setOf(6, 7, 8, 9)).isEmpty()) {
                        result++
                    }
                } else {
                    if ((set intersect setOf(6, 7)).isEmpty()) {
                        result++
                    }
                }
            } else {
                if ((set intersect setOf(6, 7, 8, 9)).isEmpty()) {
                    result++
                }
            }
        }
    }
    return result
}

private fun main() {

}
