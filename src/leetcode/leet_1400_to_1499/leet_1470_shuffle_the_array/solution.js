/**
 * leetcode - https://leetcode.com/problems/shuffle-the-array/
 *
 * TODO(Abhi) - To complete
 *
 * Using
 *
 * Stats
 *
 */
var shuffle = function (nums, n) {
    const result = [];
    for(let i = 0; i < n; i++){
        result.push(nums[i]);
        result.push(nums[n + i]);
    }
    return result;
};

const input1 = [2, 5, 1, 3, 4, 7];
const input2 = 3;
console.log(shuffle(input1, input2));
