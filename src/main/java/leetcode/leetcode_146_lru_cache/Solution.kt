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
private class DoublyLinkedListNode(
    var key: Int,
    var value: Int,
    var prev: DoublyLinkedListNode? = null,
    var next: DoublyLinkedListNode? = null,
)

private class LRUCache(capacity: Int) {
    private val cache = mutableMapOf<Int, DoublyLinkedListNode>()
    private val maxCacheSize = capacity
    private var start: DoublyLinkedListNode? = null
    private var end: DoublyLinkedListNode? = null

    fun get(key: Int): Int {
        val node = cache[key] ?: return -1
        moveNodeToEnd(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (cache.contains(key)) {
            val node = cache[key] ?: return
            node.value = value
            moveNodeToEnd(node)
        } else {
            if (cache.size == maxCacheSize) {
                removeStartNode()
            }
            addNodeToEnd(DoublyLinkedListNode(key, value))
        }
    }

    private fun addNodeToEnd(node: DoublyLinkedListNode) {
        cache[node.key] = node
        node.prev = end
        node.next = null
        end?.next = node
        end = node
        if (start == null) {
            start = node
        }
    }

    private fun moveNodeToEnd(node: DoublyLinkedListNode) {
        if (node != end) {
            removeGivenNode(node)
            addNodeToEnd(node)
        }
    }

    private fun removeGivenNode(node: DoublyLinkedListNode) {
        when (node) {
            start -> removeStartNode()
            else -> {
                cache.remove(node.key)
                node.prev?.next = node.next
                node.next?.prev = node.prev
            }
        }
    }

    private fun removeStartNode() {
        start?.key?.let {
            cache.remove(it)
        }
        start = start?.next
        start?.prev = null
        if (start == null) {
            end = null
        }
    }
}

// List ordering - Least Recently used at first
private class LRUCacheWithAllOperations(capacity: Int) {
    private val cache = mutableMapOf<Int, DoublyLinkedListNode>()
    private val maxCacheSize = capacity
    private var start: DoublyLinkedListNode? = null
    private var end: DoublyLinkedListNode? = null

    fun get(key: Int): Int {
        val node = cache[key] ?: return -1
        moveNodeToEnd(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (cache.contains(key)) {
            val node = cache[key] ?: return
            moveNodeToEnd(node)
            node.value = value
        } else {
            if (cache.size == maxCacheSize) {
                removeNodeFromStart()
            }
            addNodeToEnd(DoublyLinkedListNode(key, value))
        }
    }

    private fun moveNodeToEnd(node: DoublyLinkedListNode) {
        if (node != end) {
            removeGivenNode(node)
            addNodeToEnd(node)
        }
    }

    private fun removeGivenNode(node: DoublyLinkedListNode) {
        when (node) {
            start -> removeNodeFromStart()
            end -> removeNodeFromEnd()
            else -> {
                cache.remove(node.key)
                node.prev?.next = node.next
                node.next?.prev = node.prev
            }
        }
    }

    private fun addNodeToEnd(node: DoublyLinkedListNode) {
        cache[node.key] = node
        node.prev = end
        node.next = null
        end?.next = node
        end = node
        if (start == null) {
            start = node
        }
    }

    private fun removeNodeFromStart() {
        start?.key?.let {
            cache.remove(it)
        }
        start = start?.next
        start?.prev = null
        if (start == null) {
            end = null
        }
    }

    private fun removeNodeFromEnd() {
        end?.key?.let {
            cache.remove(it)
        }
        end = end?.prev
        end?.next = null
        if (end == null) {
            start = null
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
