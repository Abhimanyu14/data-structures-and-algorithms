package leetcode.leetcode_490_the_maze

/**
 * leetcode - https://leetcode.com/problems/the-maze/description/?envType=company&envId=facebook&favoriteSlug=facebook-three-months
 * Premium Question
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Grid
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Meta, Google
 */
private fun hasPath(maze: Array<IntArray>, start: IntArray, destination: IntArray): Boolean {
    fun getNextStops(x: Int, y: Int): List<Pair<Int, Int>> {
        val stops = mutableListOf<Pair<Int, Int>>()
        var currentX = x
        var currentY = y
        if (x < maze.lastIndex && maze[x + 1][y] != 1) {
            currentX = x + 1
            currentY = y
            while (currentX < maze.lastIndex && maze[currentX + 1][currentY] != 1) {
                currentX++
            }
            stops.add(Pair(currentX, currentY))
        }
        if (x > 0 && maze[x - 1][y] != 1) {
            currentX = x - 1
            currentY = y
            while (currentX > 0 && maze[currentX - 1][currentY] != 1) {
                currentX--
            }
            stops.add(Pair(currentX, currentY))
        }
        if (y < maze[0].lastIndex && maze[x][y + 1] != 1) {
            currentX = x
            currentY = y + 1
            while (currentY < maze[0].lastIndex && maze[currentX][currentY + 1] != 1) {
                currentY++
            }
            stops.add(Pair(currentX, currentY))
        }
        if (y > 0 && maze[x][y - 1] != 1) {
            currentX = x
            currentY = y - 1
            while (currentY > 0 && maze[currentX][currentY - 1] != 1) {
                currentY--
            }
            stops.add(Pair(currentX, currentY))
        }
        return stops
    }

    val stops = mutableListOf<Pair<Int, Int>>()
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.addLast(Pair(start[0], start[1]))
    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        if (stops.contains(current)) {
            continue
        }
        stops.add(current)
        getNextStops(current.first, current.second).forEach {
            if (it.first == destination[0] && it.second == destination[1]) {
                return true
            }
            if (!stops.contains(it)) {
                queue.add(it)
            }
        }
    }
    return false
}

private fun main() {

}
