package leetcode.leetcode_690_employee_importance

/**
 * leetcode - https://leetcode.com/problems/employee-importance/
 *
 * Using dfs
 *
 * Stats
 * Runtime: 262 ms, faster than 80.00%
 * Memory Usage: 45.7 MB, less than 86.67%
 */
private class Employee {
    var id: Int = 0
    var importance: Int = 0
    var subordinates: List<Int> = listOf()
}

private fun getImportance(employees: List<Employee?>, id: Int): Int {
    val map = mutableMapOf<Int, Employee>()
    employees.forEach {
        it?.let { employee ->
            map[employee.id] = employee
        }
    }
    fun getValue(eid: Int): Int {
        var result = map[eid]?.importance ?: 0
        map[eid]?.subordinates?.forEach {
            result += getValue(it)
        }
        return result
    }
    return getValue(id)
}

private fun main() {

}
