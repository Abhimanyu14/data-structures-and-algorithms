package leetcode_discussions.google.job_sequencing

/**
 * Question - Job Sequencing Problem
 * Given a set of N jobs where each job has a deadline and profit associated with it.
 * One job can be scheduled at a time.
 * We earn the profit associated with job if and only if the job is completed by its deadline.
 * Find the number of jobs done and the maximum profit.
 * Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.
 *
 *
 * Example
 * Input: N = 4
 * Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
 * Output = 2 60 - 2 Jobs, 60 Profit
 *
 * Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
 */

/**
 * leetcode - https://leetcode.com/discuss/interview-question/1706591/google-phone-screen-job-sequencing-problem
 *
 * Using Custom Sorting and arrays
 *
 * Difficulty - NA
 *
 * Stats
 *
 * Time -
 * Space -
 */
private class Job(
    var id: Int,
    var deadline: Int,
    val profit: Int,
)

private fun solution(jobs: Array<Job>): Pair<Int, Int> {
    var resultJobs = 0
    var resultProfit = 0
    val sortedJobs = jobs.sortedBy { it.profit }
    val maxDays = jobs.maxOf { it.deadline }
    val scheduler = IntArray(maxDays) { -1 }
    sortedJobs.forEach { job ->
        var index = job.deadline
        while (index >= 0 && scheduler[index] != -1) {
            index--
        }
        scheduler[index] = job.id
        resultJobs++
        resultProfit += job.profit
    }
    return Pair(resultJobs, resultProfit)
}

private fun main() {

}
