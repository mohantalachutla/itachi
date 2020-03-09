const webpackMerge = require("webpack-merge");
const {common,outputPath,sourceJs,sourceTs} = require("./webpack.config.common");
const Webpack = require("webpack");

const dev = {
    mode : "development",
    output: {
        path: outputPath,
        filename: "[name].bundle.js",
        publicPath: "/target/" //webpack generated content will be served from, in live mode(dev server)
        /**
         *  public path equivalent to output path
         * /assets/ === outputPath here
         * /assets/ relative to server
         * assets/ relative to html
         * '' relative to html
         */
    },

    devtool: "source-map", // bundles as normal js with eval
    devServer: {
        port : 8090,
        //https:true,
        contentBase: outputPath, //normal content like index.html will be served from, default CONNECT here, looks for welcome page a.k.a index.html
        //contentBasePublicPath:outputPath,
        //open :true, // opens in browser
        hot : true, // hot reload, without actually reloading the whole page
        //openPage : "index.html", // welcome page, defualt index.html
        //publicPath: "/target/", // from where server will serve the content, default output.publicPath
        //writeToDisk: true, //default writes to HDD
    },

    module:{
        rules:[
            {
                /**
                 * pre inline post processing
                 */
                enforce:"pre", // pre process on .js files
                test:/\.(js|ts)/,
                use:[
                    "source-map-loader", //manager source maps
                    {
                        loader:"eslint-loader", // checks for syntacticall errors
                        options:{
                            //emitError:true,
                            emitWarning:true
                        }
                    }
                ],
                exclude:/node_modules/,
                include:[sourceJs,sourceTs],
            },
        ]
    },

    plugins:[
        new Webpack.ProgressPlugin(),  //shows progress of compilation
    ],
}

const webpack_conf= webpackMerge(common,dev);
console.log("webpack.config.dev.js -> "+JSON.stringify(webpack_conf));
module.exports = webpack_conf;