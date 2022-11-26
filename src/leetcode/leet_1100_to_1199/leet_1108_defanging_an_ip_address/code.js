var defangIPaddr = function (address) {
  return address.split(".").join("[.]");
};

const input = "255.100.50.0";
console.log(defangIPaddr(input));
