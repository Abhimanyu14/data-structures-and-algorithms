package leetcode.leetcode_355_design_twitter

import java.util.PriorityQueue

/**
 * leetcode - https://leetcode.com/problems/design-twitter?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=MEDIUM
 *
 * Data Structure - Map and List
 * Algorithm - Heapify, Hashing and Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 100 ms, faster than 15.00%
 * Memory Usage: 60.3 MB, less than 17.31%
 *
 * Time -
 * Space -
 */
private class Twitter() {
    private var time = 0
    private val tweets = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    private val followers = mutableMapOf<Int, MutableSet<Int>>()

    fun postTweet(userId: Int, tweetId: Int) {
        time++
        tweets.computeIfAbsent(userId) { mutableListOf() }.add(Pair(time, tweetId))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val result = mutableListOf<Int>()
        val feed = PriorityQueue<IntArray> {  a, b -> // time, tweetId, userId, index
            b[0] - a[0]
        }
        tweets[userId]?.last()?.let { (time, tweetId) ->
            feed.offer(intArrayOf(time, tweetId, userId, tweets[userId]?.lastIndex ?: 0))
        }
        followers[userId]?.forEach { followeeId ->
            tweets[followeeId]?.last()?.let { (time, tweetId) ->
                feed.offer(intArrayOf(time, tweetId, followeeId, tweets[followeeId]?.lastIndex ?: 0))
            }
        }
        var i = 0
        while (i < 10 && feed.isNotEmpty()) {
            val current = feed.poll()
            result.add(current[1])
            if (current[3] > 0) {
                tweets[current[2]]?.getOrNull(current[3] - 1)?.let { (time, tweetId) ->
                    feed.offer(intArrayOf(time, tweetId, current[2], current[3] - 1))
                }
            }
            i++
        }
        return result
    }

    fun follow(followerId: Int, followeeId: Int) {
        followers.computeIfAbsent(followerId) { mutableSetOf() }.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followers[followerId]?.remove(followeeId)
    }
}

private fun main() {

}
