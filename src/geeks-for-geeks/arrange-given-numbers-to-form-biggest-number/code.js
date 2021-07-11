const input = [3,30,34,9,5];
const output = input.sort((a,b) => {
    return parseInt("" + a + b) > parseInt("" + b + a) ? -1: 1;
}).join('');
console.log(output);
