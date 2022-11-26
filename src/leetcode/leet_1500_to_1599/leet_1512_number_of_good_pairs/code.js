var numIdenticalPairs = function (nums) {
  return Object.values(
    nums.reduce((acc, curr) => ((acc[curr] = (acc[curr] || 0) + 1), acc), {})
  ).reduce((acc, curr) => (acc += (curr * (curr - 1)) / 2), 0);
};

const input = [1, 1, 1, 1];
console.log(numIdenticalPairs(input));
