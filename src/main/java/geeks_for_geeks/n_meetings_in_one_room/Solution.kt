package geeks_for_geeks.n_meetings_in_one_room

/**
 * link - https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
 *
 * TODO(Abhi) - To revisit
 *
 * Using greedy
 *
 * Source - https://youtu.be/mKfhTotEguk?si=U_mDmueRf4EoHpDL
 *
 * Stats
 *
 * Time -
 * Space -
 */
private data class Meeting(
    val start: Int,
    val end: Int,
    val id: Int,
)

private fun solution(start: IntArray, end: IntArray): MutableList<Meeting> {
    val meetings = Array(start.size) {
        Meeting(start[it], end[it], it)
    }
    meetings.sortBy { it.end }
    val canHappen = mutableListOf<Meeting>()
    canHappen.add(meetings[0])
    for (i in 1..meetings.lastIndex) {
        if (canHappen.last().end < meetings[i].start) {
            canHappen.add(meetings[i])
        }
    }
    return canHappen
}

private fun main() {
}
