var maxAreaOfIsland = function (grid) {
  // Filled 2D array creation
  let islandMap = Array(grid.length)
    .fill()
    .map(() => Array(grid[0].length).fill(0));

  let islandCount = 0;
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (grid[i][j] === 1) {
        if (i - 1 >= 0 && islandMap[i - 1][j] !== 0) {
          if (
            j - 1 >= 0 &&
            islandMap[i][j - 1] !== 0 &&
            islandMap[i][j - 1] !== islandMap[i - 1][j]
          ) {
            const toReplace = islandMap[i - 1][j];
            const replaceWith = islandMap[i][j - 1];
            islandMap = islandMap.map((row) =>
              row.map((item) => {
                if (item === toReplace) {
                  return replaceWith;
                } else {
                  return item;
                }
              })
            );
          }
          islandMap[i][j] = islandMap[i - 1][j];
        } else if (j - 1 >= 0 && islandMap[i][j - 1] !== 0) {
          islandMap[i][j] = islandMap[i][j - 1];
        } else {
          islandCount++;
          islandMap[i][j] = islandCount;
        }
      }
    }
  }

  // Array element frequency
  const result = Object.values(
    islandMap
      .flat()
      .filter((item) => item !== 0)
      .reduce((acc, curr) => ((acc[curr] = (acc[curr] || 0) + 1), acc), {})
  );

  if (result.length === 0) {
    return 0;
  }
  return Math.max(...result);
};

const input = [
  [0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
  [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
  [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0],
];
console.log(maxAreaOfIsland(input));
