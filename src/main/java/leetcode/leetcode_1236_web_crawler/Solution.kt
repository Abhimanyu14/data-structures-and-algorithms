package leetcode.leetcode_1236_web_crawler

/**
 * leetcode - https://leetcode.com/problems/web-crawler/description/?envType=company&envId=anthropic&favoriteSlug=anthropic-all
 * Premium Question
 *
 * Data Structure - Graph, [String], [StringBuilder], [Set], [List], [ArrayDeque] (Queue)
 * Algorithm - BFS
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Amazon, Meta
 */
private class HtmlParser {
    fun getUrls(url: String): List<String> {
        return emptyList()
    }
}

private fun crawl(startUrl: String, htmlParser: HtmlParser): List<String> {
    fun getHostName(url: String): String {
        var index = 7
        val result = StringBuilder()
        while (index <= url.lastIndex && url[index] != '/') {
            result.append(url[index])
            index++
        }
        return result.toString()
    }

    val result = mutableSetOf<String>()
    val rootHostName = getHostName(startUrl)
    val queue = ArrayDeque<String>()
    queue.addLast(startUrl)
    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        result.add(current)
        htmlParser.getUrls(current).forEach {
            if (!result.contains(it) && getHostName(it) == rootHostName) {
                queue.addLast(it)
            }
        }
    }

    return result.toList()
}

private fun main() {

}
