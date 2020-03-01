const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");

const root = path.resolve(__dirname,"../");
const outputPath = path.resolve(__dirname,"../target");
const sourcePath = path.resolve(__dirname,"../source");
const contentServedFrom = path.resolve(sourcePath,"./templates");

//console.log(path.resolve(__dirname,"../target"));

/** placeholder provided by webpack
 * [hash]
 * [contenthash]
 * [name]
 * [path]
 * [ext]
 * [emoji]
 * [id]
 * [query]
 * [chunkhash]
 */ 


module.exports = {
    mode : "development",
    entry: {
        main1 : sourcePath+"/index.js"
    },
    output: {
        path: outputPath,
        filename: "[name].bundle.js",
        publicPath: "/app/" //webpack generated content will be served from, in live mode(dev server)
    },
    module:{
        rules:[
            {
                test:/\.[html,htm]$/,
                use:[
                    {
                        loader:"file-loader", // creates a file in outputPath with given name
                        options:{
                            name:"[name].[ext]",
                            //emitFile:false, will not emit file, default true
                        }
                    },
                    "extract-loader",
                    {
                        loader:"html-loader",
                        options:{
                            attrs:["img:src","link:href"],
                            minimize:true, //compress html, css, js and removes comments and whitespaces
                        }
                    }
                ]
            },
            {
                test: /\.css$/, //if finds any .css file
                use:["style-loader", // loads styled js into html 
                    "css-loader", //convert css into commonjs
                ], // then parse it using these loaders, works bottom to top
            },
            {
                test:/\.scss$/,
                use:[
                    //"style-loader",
                    {
                        loader:"file-loader", // creates a file in outputPath with given name
                        options:{
                            name:"[name].css"
                        }
                    },
                    "extract-loader", //extracts html and css code from js with help of loaders
                    "css-loader",
                    "sass-loader", // compiles sass into css
                ]
            }
        ]
    },
    plugins:[
        new HtmlWebpackPlugin(
            {
                template:  contentServedFrom+"/index.html"// to specify html template
            }
        ), // create a html file, js script tag, css link tag
    ],
    devtool: "source-map", // bundles as normal js with eval
    devServer: {
        port : 8090,
        contentBase: contentServedFrom, //normal content like index.html will be served from, default CONNECT here
        open :true, // depoly in broweser
        //hot : true, // hot reload, without actually reloading the whole page
        //openPage : "index.html", // initializes page, defualt index.html
        publicPath: "/app/",
        writeToDisk: true //default writes to RAM

    }
};