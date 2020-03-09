const WebpackMerge = require("webpack-merge");
const {CleanWebpackPlugin} = require("clean-webpack-plugin");

const {common,outputPath} = require("./webpack.config.common");


const prod = {
    mode : "production",
    output: {
        path: outputPath,
        filename: "[name].[contenthash].js",
        publicPath: "/target/" //webpack generated content will be served from, in live mode(dev server)
        /**
         *  public path equivalent to output path
         * /assets/ === outputPath here
         * /assets/ relative to server
         * assets/ relative to html
         * '' relative to html
         */
    },
    plugins:[
        new CleanWebpackPlugin( //clean out dir
            {
                dry:true,
                verbose:true,
            }
        ),
    ],
}

const webpack_conf= WebpackMerge(common,prod);
console.log("webpack.config.prod.js -> "+JSON.stringify(webpack_conf));
module.exports = webpack_conf;