var kidsWithCandies = function (candies, extraCandies) {
    const max = Math.max(...candies);
    return candies.map((ele) => ele + extraCandies >= max);
};

const input1 = [2, 3, 5, 1, 3];
const input2 = 3;
console.log(kidsWithCandies(input1, input2));
