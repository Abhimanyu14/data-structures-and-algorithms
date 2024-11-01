var reverse = function (x) {
  let y = x;
  const isNegative = x < 0;
  if (isNegative) {
    y *= -1;
  }
  let output = parseInt(y.toString().split("").reverse().join(""));
  if (isNegative) {
    output *= -1;
  }
  if (output > 2 ** 31 -1 || output < (-2) ** 31){
      return 0;
  }
  return output;
};

const input = 1534236469;
console.log(reverse(input));
