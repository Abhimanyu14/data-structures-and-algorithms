package leetcode.leetcode_609_find_duplicate_file_in_system

/**
 * leetcode - https://leetcode.com/problems/find-duplicate-file-in-system/?envType=company&envId=netflix&favoriteSlug=netflix-all
 *
 * Data Structure - Graph, [List], [Map]
 * Algorithm - Building Graph
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google, Meta
 */
private fun findDuplicate(paths: Array<String>): List<List<String>> {
    val result = mutableListOf<List<String>>()
    val graph = mutableMapOf<String, MutableList<String>>()
    for (path in paths) {
        val current = StringBuilder()
        var index = 0

        // directory path
        while (path[index] != ' ') {
            current.append(path[index])
            index++
        }
        index++
        val directoryPath = current.toString()
        current.clear()

        while (index <= path.lastIndex) {
            // file name
            while (path[index] != '(') {
                current.append(path[index])
                index++
            }
            index++
            val fileName = current.toString()
            current.clear()

            // file content
            while (path[index] != ')') {
                current.append(path[index])
                index++
            }
            index++
            index++
            val fileContent = current.toString()
            current.clear()

            graph.computeIfAbsent(fileContent) {
                mutableListOf()
            }.add("${directoryPath}/${fileName}")
        }
    }
    for ((_, value) in graph) {
        if (value.size > 1) {
            result.add(value)
        }
    }
    return result
}

private fun main() {

}
