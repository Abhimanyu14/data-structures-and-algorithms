/**
 * leetcode - https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 *
 * TODO(Abhi) - To revisit
 *
 * Using
 *
 * Stats
 *
 */
var subtractProductAndSum = function (n) {
  let sum = 0;
  let product = 1;
  for (let i = 0; i < n.toString().length; i++) {
    sum += parseInt(n.toString()[i]);
    product *= parseInt(n.toString()[i]);
  }
  return product - sum;
};

const input = 4421;
console.log(subtractProductAndSum(input));
