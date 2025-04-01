package leetcode.leetcode_146_lru_cache

/**
 * leetcode - https://leetcode.com/problems/lru-cache/
 * https://leetcode.com/problems/lru-cache/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 * https://leetcode.com/problems/lru-cache/?envType=company&envId=microsoft&favoriteSlug=microsoft-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - Doubly Linked List
 * Algorithm - Doubly Linked List
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 150 ms, faster than 27.16%
 * Memory Usage: 141.8 MB, less than 15.90%
 *
 * Time - O(N)
 * Space - O(N)
 *
 * Companies - Meta
 */
class DoublyLinkedListNode(
    var key: Int,
    var value: Int,
    var prev: DoublyLinkedListNode? = null,
    var next: DoublyLinkedListNode? = null,
) {
    override fun toString(): String {
        return " Node = ($key, $value)"
    }
}

class LRUCache(capacity: Int) {
    private val cache = mutableMapOf<Int, DoublyLinkedListNode>()
    private val size = capacity
    private var start: DoublyLinkedListNode? = null
    private var end: DoublyLinkedListNode? = null

    fun get(key: Int): Int {
        val node = cache[key] ?: return -1
        moveNodeToEnd(key, node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (cache.contains(key)) {
            val node = cache[key] ?: return
            moveNodeToEnd(key, node)
            node.value = value
        } else {
            if (cache.size == size) {
                evictLruNode()
            }
            if (start == null) {
                createNewLinkedList(key, value)
            } else {
                addNodeToEnd(key, DoublyLinkedListNode(key, value))
            }
        }
    }

    private fun moveNodeToEnd(key: Int, node: DoublyLinkedListNode) {
        if (node != end) {
            removeGivenNode(node)
            addNodeToEnd(key, node)
        }
    }

    private fun evictLruNode() {
        start?.key?.let {
            cache.remove(it)
        }
        removeStartNode()
        if (start == null) {
            end = null
        }
    }

    private fun createNewLinkedList(key: Int, value: Int) {
        val newNode = DoublyLinkedListNode(key, value)
        start = newNode
        end = newNode
        cache[key] = newNode
    }

    private fun addNodeToEnd(key: Int, node: DoublyLinkedListNode) {
        node.prev = end
        node.next = null
        end?.next = node
        end = node
        cache[key] = node
    }

    private fun removeStartNode() {
        start = start?.next
        start?.prev = null
    }

    private fun removeEndNode() {
        end = end?.prev
        end?.next = null
    }

    private fun removeGivenNode(node: DoublyLinkedListNode) {
        when (node) {
            start -> removeStartNode()
            end -> removeEndNode()
            else -> {
                node.prev?.next = node.next
                node.next?.prev = node.prev
            }
        }
        if (start == null) {
            end = null
        }
    }
}

/**
 * leetcode - https://leetcode.com/problems/lru-cache/
 * https://leetcode.com/problems/lru-cache/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 * https://leetcode.com/problems/lru-cache/?envType=company&envId=microsoft&favoriteSlug=microsoft-thirty-days
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - ArrayDeque and Map
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 435 ms, faster than 14.08%
 * Memory Usage: 140.2 MB, less than 42.66%
 *
 * Time - O(N)
 * Space - O(N)
 */
private class LRUCacheUsingArrayDequeAndMap(capacity: Int) {
    private val arrayDeque = ArrayDeque<Int>()
    private val map = mutableMapOf<Int, Int>()
    private val maxSize = capacity

    fun get(key: Int): Int {
        if (map.contains(key)) {
            arrayDeque.remove(key)
            arrayDeque.addLast(key)
        }
        return map.getOrDefault(key, -1)
    }

    fun put(key: Int, value: Int) {
        if (map.contains(key)) {
            arrayDeque.remove(key)
        } else if (arrayDeque.size == maxSize) {
            map.remove(arrayDeque.removeFirst())
        }
        arrayDeque.addLast(key)
        map[key] = value
    }
}

private fun main() {
    val lruCache = LRUCache(2)
    lruCache.put(1, 1)
    lruCache.put(2, 2)
    lruCache.get(1)
    lruCache.put(3, 3)
    lruCache.get(2)
    lruCache.put(4, 4)
    lruCache.get(1)
    lruCache.get(3)
    lruCache.get(4)
}
