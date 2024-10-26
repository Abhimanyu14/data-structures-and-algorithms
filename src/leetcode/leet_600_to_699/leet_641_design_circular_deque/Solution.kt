package leetcode.leet_600_to_699.leet_641_design_circular_deque

/**
 * leetcode - https://leetcode.com/problems/design-circular-deque/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty -
 *
 * Stats
 *
 * Time -
 * Space -
 */
internal class Node(`val`: Int, var next: Node?, var prev: Node?) {
    var `val`: Int = `val`
}

internal class MyCircularDeque(var capacity: Int) {
    var head: Node? = null
    var rear: Node? = null
    var size: Int = 0

    fun insertFront(value: Int): Boolean {
        if (isFull()) return false
        if (head == null) {
            // first element in list
            head = Node(value, null, null)
            rear = head
        } else {
            // add new head
            val newHead = Node(value, head, null)
            head!!.prev = newHead
            head = newHead
        }
        size++
        return true
    }

    fun insertLast(value: Int): Boolean {
        if (isFull()) return false
        if (head == null) {
            // first element in list
            head = Node(value, null, null)
            rear = head
        } else {
            // add new element to end
            rear!!.next = Node(value, null, rear)
            rear = rear!!.next
        }
        size++
        return true
    }

    fun deleteFront(): Boolean {
        if (isEmpty()) return false
        if (size == 1) {
            head = null
            rear = null
        } else {
            head = head!!.next
        }
        size--
        return true
    }

    fun deleteLast(): Boolean {
        if (isEmpty()) return false
        if (size == 1) {
            head = null
            rear = null
        } else {
            // update rear to the previous node
            rear = rear!!.prev
        }
        size--
        return true
    }

    fun getFront(): Int {
        if (isEmpty()) {
            return -1
        }
        return head!!.`val`
    }

    fun getRear(): Int {
        if (isEmpty()) return -1
        return rear!!.`val`
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun isFull(): Boolean {
        return size == capacity
    }
}


private fun main() {

}
