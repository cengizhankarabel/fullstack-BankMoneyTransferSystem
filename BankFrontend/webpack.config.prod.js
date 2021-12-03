const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');


// module.exports = {
//   entry: './src/index.ts',
//   mode: 'production',
//   output: {
//     filename: 'main.js',
//     path: path.resolve(__dirname, 'dist'),
//   },

module.exports = {
  entry: './src/index.ts',
  mode: 'production',
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
    ],
    resolve: {
      extensions: ['.tsk', '.ts', '.js'],
    },
  },
};