package leetcode.leetcode_841_keys_and_rooms

/**
 * leetcode - https://leetcode.com/problems/keys-and-rooms/
 *
 * TODO(Abhi) - To revisit
 *
 * Using DFS
 *
 * Stats
 * Runtime: 199 ms, faster than 24.78%
 * Memory Usage: 41 MB, less than 23.89%
 */
private fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    val visited = mutableSetOf<Int>()

    fun dfs(n: Int) {
        visited.add(n)
        rooms[n].forEach {
            if (!visited.contains(it)) {
                dfs(it)
            }
        }
    }
    dfs(0)
    return visited.size == rooms.size
}

private fun main() {

}
