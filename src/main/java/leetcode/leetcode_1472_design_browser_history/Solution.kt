package leetcode.leetcode_1472_design_browser_history

/**
 * leetcode - https://leetcode.com/problems/design-browser-history/
 *
 * Data Structure - Double Linked List
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 118 ms, faster than 30.43%
 * Memory Usage: 69 MB, less than 48.28%
 *
 * Time - O(N ^ 2)
 * Space - O(N)
 */
class DoubleLinkedListNode(
    var url: String = "",
    var prev: DoubleLinkedListNode? = null,
    var next: DoubleLinkedListNode? = null,
)

class BrowserHistory(homepage: String) {
    private var current = DoubleLinkedListNode(homepage)

    fun visit(url: String) {
        current.next = DoubleLinkedListNode(url).apply {
            prev = current
        }
        current.next?.let {
            current = it
        }
    }

    fun back(steps: Int): String {
        var move = steps
        while (move > 0 && current.prev != null) {
            current.prev?.let {
                current = it
            }
            move--
        }
        return current.url
    }

    fun forward(steps: Int): String {
        var move = steps
        while (move > 0 && current.next != null) {
            current.next?.let {
                current = it
            }
            move--
        }
        return current.url
    }
}

private fun main() {

}
