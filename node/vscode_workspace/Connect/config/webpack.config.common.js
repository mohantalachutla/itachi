const path = require("path");

const HtmlWebpackPlugin = require("html-webpack-plugin");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const Webpack = require("webpack");

const root = path.resolve(__dirname,"../");
const outputPath = path.resolve(root,"./target");
const sourcePath = path.resolve(root,"./source");
const sourceHtml = path.resolve(sourcePath,"./templates");
const sourceCss = path.resolve(sourcePath,"./css");
const sourceScss = path.resolve(sourcePath,"./scss");
const sourceJs = path.resolve(sourcePath,"./js");
const sourceTs = path.resolve(sourcePath,"./ts");

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


const common = {
    
    entry: {
        main1 : sourcePath+"/index.js"
    },
    

    module:{
        rules:[
            {
                test:/\.[html,htm]$/,
                use:[
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
                use:[
                    MiniCssExtractPlugin.loader,
                    "css-loader", //convert css into commonjs
                ], // then parse it using these loaders, works bottom to top
            },
            {
                test:/\.scss$/,
                use:[
                    MiniCssExtractPlugin.loader,
                    "css-loader",
                    "sass-loader", // compiles sass into css
                ]
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
        new MiniCssExtractPlugin(),
        new Webpack.ProvidePlugin(
            {
                _$:"jquery",
                __:"lodash"
            }
        ) // imports specified nodmodules into a global varibles.
        
    ],


    resolve:{
      extensions:['.js','.ts','.css','.scss','.sass'],  //  if webpack can not resolve the specified import it will look these extensions.
      alias:{
            __s:sourceScss,
            __c:sourceCss,
            __j:sourceJs,
            __t:sourceTs,

      }, // if webpack can resolve the files it will resolve using these path
      modules:["node_modules"] // looks for node_modules in recursive manner
    },

    
    watch:true, // re-comipiles automatically if webpack finds any chages in code,
    // watchOptions:{
    //     ignored:["node_modules/**"]
    // },


};


module.exports.common = common;
module.exports.outputPath = outputPath;
module.exports.sourceJs = sourceJs;
module.exports.sourceTs = sourceTs;