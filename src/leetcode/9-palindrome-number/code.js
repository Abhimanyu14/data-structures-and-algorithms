var isPalindrome = function (x) {
  const str = x.toString();
  const len = Math.floor(str.length / 2);
  for (let i = 0; i < len; i++) {
    if (str.charAt(i) !== str.charAt(str.length - i - 1)) {
      return false;
    }
  }
  return true;
};

const input = [121];
console.log(isPalindrome(...input));
