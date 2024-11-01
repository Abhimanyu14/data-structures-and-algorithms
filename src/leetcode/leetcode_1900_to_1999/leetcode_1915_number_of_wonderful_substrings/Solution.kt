package leetcode.leetcode_1900_to_1999.leetcode_1915_number_of_wonderful_substrings


/**
 * leetcode - https://leetcode.com/problems/number-of-wonderful-substrings/?envType=daily-question&envId=2024-04-30
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 */
private fun wonderfulSubstrings(word: String): Long {
    // Create the frequency map
    // Key = bitmask, Value = frequency of bitmask key
    val freq: MutableMap<Int, Int> = HashMap()

    // The empty prefix can be the smaller prefix, which is handled like this
    freq[0] = 1

    var mask = 0
    var res = 0L
    for (element in word) {
        val bit = element - 'a'

        // Flip the parity of the c-th bit in the running prefix mask
        mask = mask xor (1 shl bit)

        // Count smaller prefixes that create substrings with no odd occurring letters
        res += freq.getOrDefault(mask, 0).toLong()

        // Increment value associated with mask by 1
        freq[mask] = freq.getOrDefault(mask, 0) + 1

        // Loop through every possible letter that can appear an odd number of times in a substring
        for (oddC in 0..9) {
            res += freq.getOrDefault(mask xor (1 shl oddC), 0).toLong()
        }
    }
    return res
}

private fun main() {

}
