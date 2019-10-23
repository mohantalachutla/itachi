//app.js
const scope = require("./scope");

console.log(scope.myFun("It's myFun from scope module"));
//console.log(scope.myFun2("It's myFun2 from scope module")); /// not exported
console.log(scope.method3("It's myFun3 from scope module"));