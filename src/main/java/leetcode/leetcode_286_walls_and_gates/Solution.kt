package leetcode.leetcode_286_walls_and_gates

/**
 * leetcode - https://leetcode.com/problems/walls-and-gates/description/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 * Premium question
 *
 * Data Structure - Grid, ArrayDeque(Queue)
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Google, Meta, Microsoft
 */
private fun wallsAndGates(rooms: Array<IntArray>) {
    val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    val queue = ArrayDeque<IntArray>()
    val visited = Array(rooms.size) {
        BooleanArray(rooms[0].size)
    }
    for (i in rooms.indices) {
        for (j in rooms[i].indices) {
            if (rooms[i][j] == -1) {
                visited[i][j] = true
            } else if (rooms[i][j] == 0) {
                queue.addLast(intArrayOf(i, j))
            }
        }
    }
    var dist = 0
    while (queue.isNotEmpty()) {
        val queueSize = queue.size

        for (i in 0..<queueSize) {
            val current = queue.removeFirst()
            val x = current[0]
            val y = current[1]
            if (visited[x][y]) {
                continue
            }
            visited[x][y] = true
            if (rooms[x][y] >= dist) {
                rooms[x][y] = dist
                directions.forEach {
                    val newX = x + it[0]
                    val newY = y + it[1]
                    if (newX in 0..rooms.lastIndex && newY in 0..rooms[0].lastIndex && !visited[newX][newY]) {
                        queue.addLast(intArrayOf(newX, newY))
                    }
                }
            }
        }
        dist++
    }
}

private fun main() {

}
