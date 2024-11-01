package leetcode.leetcode_800_to_899.leetcode_832_flipping_an_image

/**
 * leetcode - https://leetcode.com/problems/flipping-an-image/
 * Using loops
 *
 * Stats
 * Runtime: 381 ms, faster than 58.62%
 * Memory Usage: 43.6 MB, less than 27.59%
 */
private fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
    var temp: Int
    image.forEach { row ->
        for (i in 0..(row.lastIndex / 2)) {
            if (i == (row.lastIndex / 2) && row.size % 2 == 1) {
                row[i] = invert(row[i])
            } else {
                temp = 1 xor row[i]
                row[i] = invert(row[row.lastIndex - i])
                row[row.lastIndex - i] = temp
            }
        }
    }
    return image
}

private fun invert(x: Int): Int {
    if (x == 1) {
        return 0
    }
    return 1
}

private fun main() {

}
