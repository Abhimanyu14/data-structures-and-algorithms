package leetcode.leet_2300_to_2399.leet_2336_smallest_number_in_infinite_set

/**
 * leetcode - https://leetcode.com/problems/smallest-number-in-infinite-set/
 *
 * Using linked list
 *
 * Stats
 * Runtime: 576 ms, faster than 83.33%
 * Memory Usage: 60.3 MB, less than 83.33%
 */
class MyListNode(var `val`: Int) {
    var next: MyListNode? = null
}

class SmallestInfiniteSet() {
    val head = MyListNode(0)

    fun popSmallest(): Int {
        var temp: MyListNode? = head
        while (temp?.next != null && (temp.next?.`val` == (temp.`val` + 1))) {
            temp = temp.next
        }
        val result = (temp?.`val` ?: 0) + 1
        val resultNode = MyListNode(result).apply {
            next = temp?.next
        }
        temp?.next = resultNode
        return result
    }

    fun addBack(num: Int) {
        var prev: MyListNode? = head
        var current: MyListNode? = head.next
        while (current != null && current.`val` < num) {
            prev = current
            current = current.next
        }
        if (current?.`val` == num) {
            prev?.next = current.next
        }
    }
}

private fun main() {

}
