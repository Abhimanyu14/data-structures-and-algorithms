/**
 * leetcode - https://leetcode.com/problems/roman-to-integer/
 *
 */
var romanToInt = function (s) {
  const map = { I: 1, V: 5, X: 10, L: 50, C: 100, D: 500, M: 1000 };
  let i = s.length - 1;
  let result = 0;
  let previous = 0;
  while (i >= 0) {
    if (previous > map[s.charAt(i)]) {
      result = result - map[s.charAt(i)];
    } else {
      result = result + map[s.charAt(i)];
    }
    previous = map[s.charAt(i)];
    i--;
  }
  return result;
};

const input = ["MCMXCIV"];
console.log(romanToInt(...input));
