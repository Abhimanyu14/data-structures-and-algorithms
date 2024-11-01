package leetcode.leetcode_100_to_199.leetcode_146_lru_cache

/**
 * leetcode - https://leetcode.com/problems/lru-cache/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
class LRUCache(capacity: Int) {
    private val arrayDeque = ArrayDeque<Int>()
    private val map = HashMap<Int, Int>()
    private val maxSize = capacity

    fun get(key: Int): Int {
        map[key]?.let {
            arrayDeque.remove(key)
            arrayDeque.addLast(key)
            return map[key]!!
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (map[key] != null) {
            arrayDeque.remove(key)
        } else {
            if (arrayDeque.size == maxSize) {
                map.remove(arrayDeque.removeFirst())
            }
        }
        arrayDeque.addLast(key)
        map[key] = value
    }

    fun print() {
        println(arrayDeque.toString())
        println(map.toString())
        println()
    }
}

private fun main() {
    val lruCache = LRUCache(2)
    lruCache.put(1, 1)
    lruCache.print()

    lruCache.put(2, 2)
    lruCache.print()

    lruCache.get(1)
    lruCache.print()

    lruCache.put(3, 3)
    lruCache.print()

    lruCache.get(2)
    lruCache.print()

    lruCache.put(4, 4)
    lruCache.print()

    lruCache.get(1)
    lruCache.print()

    lruCache.get(3)
    lruCache.print()

    lruCache.get(4)
    lruCache.print()
}
