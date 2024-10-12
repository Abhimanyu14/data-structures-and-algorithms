package leetcode.leet_400_to_499.leet_432_all_oone_data_structure


/**
 * leetcode - https://leetcode.com/problems/all-oone-data-structure/?envType=daily-question&envId=2024-09-29
 *
 * TODO(Abhi) - To complete
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
class Node internal constructor(var freq: Int) {
    var prev: Node? = null
    var next: Node? = null
    var keys: MutableSet<String> = HashSet()
}

internal class AllOne {
    var head: Node = Node(0)
    var tail: Node = Node(0)
    var map: MutableMap<String, Node?> = HashMap()

    init {
        head.next = tail
        tail.prev = head
    }

    fun inc(key: String) {
        if (map.containsKey(key)) {
            val node = map[key]
            val freq = node!!.freq
            node.keys.remove(key)

            val nextNode = node.next
            if (nextNode === tail || nextNode!!.freq != freq + 1) {
                val newNode = Node(freq + 1)
                newNode.keys.add(key)
                newNode.prev = node
                newNode.next = nextNode
                node.next = newNode
                nextNode.prev = newNode
                map[key] = newNode
            } else {
                nextNode.keys.add(key)
                map[key] = nextNode
            }

            if (node.keys.isEmpty()) {
                removeNode(node)
            }
        } else {
            val firstNode = head.next
            if (firstNode === tail || firstNode!!.freq > 1) {
                val newNode = Node(1)
                newNode.keys.add(key)
                newNode.prev = head
                newNode.next = firstNode
                head.next = newNode
                firstNode.prev = newNode
                map[key] = newNode
            } else {
                firstNode.keys.add(key)
                map[key] = firstNode
            }
        }
    }

    fun dec(key: String) {
        if (!map.containsKey(key)) {
            return
        }

        val node = map[key]
        node!!.keys.remove(key)
        val freq = node.freq

        if (freq == 1) {
            map.remove(key)
        } else {
            val prevNode = node.prev
            if (prevNode === head || prevNode!!.freq != freq - 1) {
                val newNode = Node(freq - 1)
                newNode.keys.add(key)
                newNode.prev = prevNode
                newNode.next = node
                prevNode.next = newNode
                node.prev = newNode
                map[key] = newNode
            } else {
                prevNode.keys.add(key)
                map[key] = prevNode
            }
        }

        if (node.keys.isEmpty()) {
            removeNode(node)
        }
    }

    fun getMaxKey(): String {
        if (tail.prev === head) {
            return ""
        }
        return tail.prev!!.keys.iterator().next()
    }

    fun getMinKey(): String {
        if (head.next === tail) {
            return ""
        }
        return head.next!!.keys.iterator().next()
    }

    private fun removeNode(node: Node?) {
        val prevNode = node!!.prev
        val nextNode = node.next

        prevNode!!.next = nextNode
        nextNode!!.prev = prevNode
    }
}

private fun main() {

}
