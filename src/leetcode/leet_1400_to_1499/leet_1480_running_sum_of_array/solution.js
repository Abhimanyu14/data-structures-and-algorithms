/**
 * leetcode - https://leetcode.com/problems/running-sum-of-1d-array/
 *
 * TODO(Abhi) - To complete
 *
 * Using
 *
 * Stats
 *
 */
var runningSum = function (nums) {
  for(let i = 1; i < nums.length ; i++) {
    nums[i] = nums[i] + nums[i - 1];
  }
  return nums;
};

const input = [1, 2, 3, 4];
console.log(runningSum(input));
