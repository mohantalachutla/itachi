const path = require("path");

const HtmlWebpackPlugin = require("html-webpack-plugin");
const webpack = require("webpack");

const root = path.resolve(__dirname,"../");
const outputPath = path.resolve(root,"./target");
const sourcePath = path.resolve(root,"./source");
const sourceHtml = path.resolve(sourcePath,"./templates");
const sourcecss = path.resolve(sourcePath,"./css");
const sourceScss = path.resolve(sourcePath,"./scss");
const sourcejs = path.resolve(sourcePath,"./js");
const sourcets = path.resolve(sourcePath,"./ts");

console.log('root--'+root);
console.log('outputPath--'+outputPath);
console.log('sourcePath--'+sourcePath);
console.log('sourceHtml--'+sourceHtml);

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



    module:{
        rules:[
            {
                test:/\.[html,htm]$/,
                use:[
                    {
                        loader:"file-loader", // creates a file in outputPath with given name
                        options:{
                            name:"[name][contenthash].[ext]",
                            //publicPath:"/target/",
                            //emitFile:false, will not emit file, default true
                        }
                    },
                    "extract-loader",
                    {
                        loader:"html-loader",
                        options:{
                            attrs:["img:src","link:href","script:src"],
                            //minimize:true, //compress html, css, js and removes comments and whitespaces
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
                    {
                        loader:"style-loader",
                        options:{
                            injectType:"linkTag",
                            insert:"head",
                        }
                    },
                    {
                        loader:"file-loader", // creates a file in outputPath with given name
                        options:{
                            name:"[name][contenthash].css",
                            publicPath:"/target/"
                        }
                    },
                    "extract-loader", //extracts html and css code from js with help of loaders
                    "css-loader",
                    "sass-loader", // compiles sass into css
                ]
            },
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
                include:[sourcejs,sourcets],
            },
            {
                test:/\.js/,
                use:[
                    {
                        loader:"babel-loader", // to transform es2015(es6) and above into es5(browser compatible)
                        options:{
                            presets:["@babel/preset-env"]
                        }
                    }
                ]
            },
            {
                test:/\.ts$/,
                loader:"awesome-typescript-loader",
                exclude:/node_modules/
            }
        ]
    }, 

    
    plugins:[
        new HtmlWebpackPlugin(
            {
                template:  sourceHtml+"/index.html"// to specify html template and will create a file as output after injecting links and scripts
                //filename: "signIn.html",
            }
        ), // create a html file, js script tag, css link tag
        new webpack.ProvidePlugin(
            {
                _$:"jquery",
                __:"lodash"
            }
        ) // imports specified nodmodules into a global varibles.
    ],


    resolve:{
      extensions:['.js','.ts','.css','.scss','.sass'],  //  if webpack can not resolve the specified import it will look these extensions.
      alias:{

      }, // if webpack can resolve the files it will resolve using these path
      modules:["node_modules"] // looks for node_modules in recursive manner
    },

    devtool: "source-map", // bundles as normal js with eval
    // watch:true, // re-comipiles automatically if webpack finds any chages in code,
    // watchOptions:{
    //     ignored:["node_modules/**"]
    // },


    devServer: {
        port : 8090,
        //https:true,
        //contentBase: outputPath, //normal content like index.html will be served from, default CONNECT here
        //contentBasePublicPath:outputPath,
        //open :true, // opens in browser
        hot : true, // hot reload, without actually reloading the whole page
        //openPage : "index.html", // initializes page, defualt index.html
        publicPath: "./target/",
        writeToDisk: true, //default writes to HDD

    }
};