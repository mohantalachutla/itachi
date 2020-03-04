
const __ = require("lodash");
const common = require("./webpack.config");

const prod = {

}

module.exports = __.mergeWith(common,prod,function(){
});