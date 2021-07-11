var isInterleave = function (s1, s2, s3) {
  if (
    s3.length !== s1.length + s2.length ||
    s3.split("").sort() !== (s1 + s2).split("").sort()
  ) {
    return false;
  }

  return true;
};

const inputs = ["aabcc", "dbbca", "aadbbcbcac"];
console.log(isInterleave(...inputs));
