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
