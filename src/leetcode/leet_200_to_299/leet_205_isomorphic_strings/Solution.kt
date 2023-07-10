package leetcode.leet_200_to_299.leet_205_isomorphic_strings

/**
 * Using map
 *
 * Stats
 * Runtime: 211 ms, faster than 94.22%
 * Memory Usage: 35.5 MB, less than 94.22%
 */
private fun isIsomorphic(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }
    val map = hashMapOf<Char, Char>()
    s.forEachIndexed { index, c ->
        if (map.containsKey(c) || map.containsValue(t[index])) {
            if (map[c] != t[index]) {
                return false
            }
        } else {
            map[c] = t[index]
        }
    }
    return true
}

private fun main() {
    println(isIsomorphic("egg", "add"))
    println(isIsomorphic("foo", "bar"))
    println(isIsomorphic("paper", "title"))
    println(isIsomorphic("badc", "baba"))
}
