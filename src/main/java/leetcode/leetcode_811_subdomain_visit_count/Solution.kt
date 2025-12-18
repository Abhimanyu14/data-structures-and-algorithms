package leetcode.leetcode_811_subdomain_visit_count

/**
 * leetcode - https://leetcode.com/problems/subdomain-visit-count/?envType=company&envId=google&favoriteSlug=google-thirty-days
 *
 * Data Structure - String, List, Map
 * Algorithm - Iteration
 *
 * Difficulty - Medium
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies - Google, Microsoft
 */
private fun subdomainVisits(cpdomains: Array<String>): List<String> {
    val map = mutableMapOf<String, Int>()
    for (cpdomain in cpdomains) {
        val (domainCountString, domainsString) = cpdomain.split(" ")
        val domainCount = domainCountString.toInt()
        val domains = domainsString.split(".")
        var currentDomain = domains.last()
        map[currentDomain] = map.getOrDefault(currentDomain, 0) + domainCount
        for (i in domains.size - 2 downTo 0) {
            currentDomain = "${domains[i]}.$currentDomain"
            map[currentDomain] = map.getOrDefault(currentDomain, 0) + domainCount
        }
    }
    return map.map {
        "${it.value} ${it.key}"
    }
}
