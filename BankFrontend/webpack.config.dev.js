const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyPlugin = require("copy-webpack-plugin");

// module.exports = {
//   entry: './src/index.ts',
//   mode: 'development',
//   output: {
//     filename: 'main.js',
//     path: path.resolve(__dirname, 'dist'),
//   },



module.exports = {
  entry: './src/index.ts',
  mode: 'development',
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'main.js'
},


  
  plugins: [
    
    new HtmlWebpackPlugin({
      filename: 'index.html',
      template: './src/index.html'
    }),
    // new CopyPlugin({
    //   patterns: [
    //     { from: "./src/images", to: "images" },
    //   ],
    // }),
  ],
  module: {
    rules: [
      {
        test: /\.s[ac]ss$/i,
        use: [
          // Creates `style` nodes from JS strings
          "style-loader",
          // Translates CSS into CommonJS
          "css-loader",
          // Compiles Sass to CSS
          "sass-loader",
        ],
      },
      {
        test: /\.tsx?$/,
        use: 'ts-loader',
        exclude: /node_modules/,
      },
    ],
  },
  resolve: {
    extensions: ['.tsk', '.ts', '.js'],
  },
  devServer: {
    static: {
      directory: path.join(__dirname, 'dist'),
    },
    compress: true,
    port: 4005,
  },
};