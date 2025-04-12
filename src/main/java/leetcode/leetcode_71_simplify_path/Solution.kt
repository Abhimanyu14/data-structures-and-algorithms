package leetcode.leetcode_71_simplify_path

/**
 * leetcode - https://leetcode.com/problems/simplify-path/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure - [ArrayDeque], [StringBuilder]
 * Algorithm -
 *
 * Difficulty - Medium
 *
 * Stats
 * Runtime: 205 ms, faster than 92.73%
 * Memory Usage: 35.9 MB, less than 96.36%
 *
 * Time -
 * Space -
 *
 * Companies - Meta
 */
private fun simplifyPath(path: String): String {
    var index = 0
    fun getNextToken(): String {
        while (index < path.length && path[index] == '/') {
            index++
        }
        val token = StringBuilder()
        while (index < path.length && path[index] != '/') {
            token.append(path[index])
            index++
        }
        return token.toString()
    }
    val stack = ArrayDeque<String>()
    var nextToken = getNextToken()
    while (nextToken.isNotEmpty()) {
        if (nextToken == "..") {
            if (stack.isNotEmpty()) {
                stack.removeLast()
            }
        } else if (nextToken != ".") {
            stack.addLast(nextToken)
        }
        nextToken = getNextToken()
    }
    return "/${stack.joinToString("/")}"
}

private fun simplifyPathUsingSplit(path: String): String {
    val deque = ArrayDeque<String>()
    path.split("/").forEach {
        if (it == "..") {
            if (deque.isNotEmpty()) {
                deque.removeLast()
            }
        } else if (!(it.isEmpty() || it == ".")) {
            deque.addLast(it)
        }
    }
    val result = StringBuilder()
    while (deque.isNotEmpty()) {
        result.append('/')
        result.append(deque.removeFirst())
    }
    if (result.isEmpty()) {
        result.append('/')
    }
    return result.toString()
}

/**
 * leetcode - https://leetcode.com/problems/simplify-path/
 *
 * Using string iteration and deque
 *
 * Stats
 * Runtime: 236 ms, faster than 80.00%
 * Memory Usage: 37.4 MB, less than 67.27%
 */
private fun simplifyPathUsingStringIteration(path: String): String {
    val deque = ArrayDeque<String>()
    var pointer = 0
    val sb = StringBuilder()
    while (pointer < path.length) {
        if (path[pointer] == '/') {
            if (sb.isNotEmpty()) {
                deque.addLast(sb.toString())
                sb.clear()
            }
        } else if (sb.isEmpty() && path[pointer] == '.') {
            var dotCount = 1
            while (pointer + dotCount < path.length && path[pointer + dotCount] == '.') {
                dotCount++
            }
            val isSequenceComplete = if (pointer + dotCount < path.length) {
                path[pointer + dotCount] == '/'
            } else {
                true
            }
            if (dotCount == 2 && isSequenceComplete) {
                if (deque.isNotEmpty()) {
                    deque.removeLast()
                }
                pointer++
            } else if (!(dotCount == 1 && isSequenceComplete)) {
                while (dotCount > 0) {
                    sb.append(path[pointer])
                    pointer++
                    dotCount--
                }
                pointer--
            }
        } else {
            sb.append(path[pointer])
        }
        pointer++
    }
    if (sb.isNotEmpty()) {
        deque.addLast(sb.toString())
    }

    // Create from stack
    val result = StringBuilder()
    while (deque.isNotEmpty()) {
        result.append('/')
        result.append(deque.removeFirst())
    }
    if (result.isEmpty()) {
        result.append('/')
    }
    return result.toString()
}

private fun main() {
    println(simplifyPath("/home/"))
    println(simplifyPath("/../"))
    println(simplifyPath("/home//foo/"))
    println(simplifyPath("/."))
    println(simplifyPath("/..."))
    println(simplifyPath("/a/./b/../../c/"))
    println(simplifyPath("/..hidden"))
}
