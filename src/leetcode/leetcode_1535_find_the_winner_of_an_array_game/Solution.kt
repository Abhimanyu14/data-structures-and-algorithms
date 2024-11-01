package leetcode.leetcode_1535_find_the_winner_of_an_array_game

/**
 * leetcode - https://leetcode.com/problems/find-the-winner-of-an-array-game/
 *
 * TODO(Abhi) - To revisit
 *
 * Using array deque
 *
 * Stats
 * Runtime: 420 ms, faster than 66.67%
 * Memory Usage: 53.9 MB, less than 100.00%
 */
private fun getWinner(arr: IntArray, k: Int): Int {
    val maxElement = arr.max()
    var curr = arr[0]
    var winstreak = 0
    for (i in 1 until arr.size) {
        val opponent = arr[i]
        if (curr > opponent) {
            winstreak++
        } else {
            curr = opponent
            winstreak = 1
        }
        if (winstreak == k || curr == maxElement) {
            return curr
        }
    }
    return -1
}

/**
 * leetcode - https://leetcode.com/problems/find-the-winner-of-an-array-game/
 *
 * Using array deque
 *
 * Stats
 * Runtime: 486 ms, faster than 33.33%
 * Memory Usage: 57 MB, less than 33.33%
 */
private fun getWinnerWithQueue(arr: IntArray, k: Int): Int {
    if (k > arr.size) {
        return arr.max()
    }

    val arrayDeque = ArrayDeque<Int>()
    arr.forEach {
        arrayDeque.addLast(it)
    }
    var winCount = 0
    var result = 0
    var first: Int
    var second: Int
    while (winCount < k) {
        first = arrayDeque.removeFirst()
        second = arrayDeque.removeFirst()
        if (first > second) {
            result = first
            winCount++
            arrayDeque.addFirst(first)
            arrayDeque.addLast(second)
        } else {
            result = second
            winCount = 1
            arrayDeque.addFirst(second)
            arrayDeque.addLast(first)
        }
    }
    return result
}

/**
 * leetcode - https://leetcode.com/problems/find-the-winner-of-an-array-game/
 *
 * Using array deque
 *
 * Stats
 * Time Limit Exceeded
 */
private fun getWinnerUsingArrayDeque(arr: IntArray, k: Int): Int {
    val queue = ArrayDeque<Int>()
    arr.forEach {
        queue.addLast(it)
    }
    var winCount = 0
    var result: Int = 0
    var first: Int
    var second: Int
    while (winCount < k) {
        result = queue.first()
        first = queue.removeFirst()
        second = queue.removeFirst()
        if (first > second) {
            winCount++
            queue.addFirst(first)
            queue.addLast(second)
        } else {
            winCount = 1
            queue.addFirst(second)
            queue.addLast(first)
        }
    }
    return result
}

private fun main() {

}
