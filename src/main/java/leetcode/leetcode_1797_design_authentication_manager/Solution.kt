package leetcode.leetcode_1797_design_authentication_manager

/**
 * leetcode - https://leetcode.com/problems/design-authentication-manager/?envType=problem-list-v2&envId=doubly-linked-list
 *
 * Data Structure - Doubly Linked List
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 84 ms, faster than 100.00%
 * Memory Usage: 47.9 MB, less than 50.00%
 *
 * Time -
 * Space -
 */
private class DoublyLinkedListNode(
    var id: String,
    var expiryTime: Int,
    var prev: DoublyLinkedListNode? = null,
    var next: DoublyLinkedListNode? = null,
)

private class AuthenticationManager(private val timeToLive: Int) {
    private val tokens = mutableMapOf<String, DoublyLinkedListNode>()
    private var start: DoublyLinkedListNode? = null
    private var end: DoublyLinkedListNode? = null

    fun generate(tokenId: String, currentTime: Int) {
        flushExpiredTokens(currentTime)
        val newToken = DoublyLinkedListNode(tokenId, currentTime + timeToLive)
        newToken.prev = end
        end?.next = newToken
        end = newToken
        if (start == null) {
            start = newToken
        }
        tokens[tokenId] = newToken
    }

    fun renew(tokenId: String, currentTime: Int) {
        flushExpiredTokens(currentTime)
        val token = tokens[tokenId] ?: return
        token.expiryTime = currentTime + timeToLive
        when (token) {
            end -> {

            }
            start -> {
                start = start?.next
                start?.prev = null

                token.prev = end
                end?.next = token
                end = token
            }
            else -> {
                token.prev?.next = token.next
                token.next?.prev = token.prev

                token.prev = end
                end?.next = token
                end = token
            }
        }
    }

    fun countUnexpiredTokens(currentTime: Int): Int {
        flushExpiredTokens(currentTime)
        return tokens.size
    }

    private fun flushExpiredTokens(currentTime: Int) {
        while (start != null && (start?.expiryTime ?: 0) <= currentTime) {
            start?.id?.let {
                tokens.remove(it)
            }
            start = start?.next
            start?.prev = null
        }
        if (start == null) {
            end = null
        }
    }
}

private fun main() {

}
