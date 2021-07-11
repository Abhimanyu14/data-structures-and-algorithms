package hackerrank.practice.stone_division

// TODO: Not all test cases passed
fun solution(set: List<Int>, length: Int, piles: Int, moves: Int, position: Int): Int {
    return if (position >= set.size) {
        moves
    } else {
        if (length > set[position] && length % set[position] == 0) {
            solution(set, set[position], piles * length / set[position], moves + piles, position + 1)
        } else {
            solution(set, length, piles, moves, position + 1)
        }
    }
}

fun stoneDivision(n: Long, s: Array<Long>): Long {
    return solution(s.sortedArrayDescending().map { it.toInt() }, n.toInt(), 1, 0, 0).toLong()
}

fun main() {
    val result = stoneDivision(18, arrayOf(2, 3, 4))
    println(result)
}
