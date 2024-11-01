package leetcode.leetcode_700_to_799.leetcode_733_flood_fill

/**
 * leetcode - https://leetcode.com/problems/flood-fill/
 *
 * Using DFS
 *
 * Stats
 * Runtime: 377 ms, faster than 72.61%
 * Memory Usage: 47.2 MB, less than 52.70%
 */
private fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    dfs(image, image[sr][sc], color, sr, sc)
    return image
}

private fun dfs(image: Array<IntArray>, startColor: Int, paintColor: Int, x: Int, y: Int) {
    if (x < 0 || x >= image.size || y < 0 || y >= image[0].size || image[x][y] != startColor || image[x][y] == paintColor) {
        return
    }
    image[x][y] = paintColor
    dfs(image, startColor, paintColor, x, y - 1)
    dfs(image, startColor, paintColor, x, y + 1)
    dfs(image, startColor, paintColor, x - 1, y)
    dfs(image, startColor, paintColor, x + 1, y)
}

/**
 * leetcode - https://leetcode.com/problems/flood-fill/
 *
 * Using DFS - nested method
 *
 * Stats
 * Runtime: 377 ms, faster than 72.61%
 * Memory Usage: 47.2 MB, less than 52.70%
 */
private fun floodFillUsingNestedMethod(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    fun dfs(image: Array<IntArray>, startColor: Int, paintColor: Int, x: Int, y: Int) {
        if (x < 0 || x >= image.size || y < 0 || y >= image[0].size || image[x][y] != startColor || image[x][y] == paintColor) {
            return
        }
        image[x][y] = paintColor
        dfs(image, startColor, paintColor, x, y - 1)
        dfs(image, startColor, paintColor, x, y + 1)
        dfs(image, startColor, paintColor, x - 1, y)
        dfs(image, startColor, paintColor, x + 1, y)
    }
    dfs(image, image[sr][sc], color, sr, sc)
    return image
}

private fun main() {

}
