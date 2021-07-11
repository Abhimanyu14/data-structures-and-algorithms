var maximumWealth = function (accounts) {
  return Math.max(
    ...accounts.map((account) => {
      return account.reduce((a, b) => a + b, 0);
    })
  );
};

const input = [
  [1, 2, 3],
  [3, 2, 1],
];
console.log(maximumWealth(input));
