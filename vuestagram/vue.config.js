module.exports = {
  //CORS
  devServer: {
    // port: process.env.VUE_APP_PORT || 3000,
    // proxy: 'http://172.30.1.17:8080',
    // proxy: {
    //   // 프록시 요청을 보낼 api의 시작 부분
    //   '/jy': {
    //     // 프록시 요청을 보낼 서버의 주소
    //     target: 'http://172.30.1.17:8080',
    //   },
    //   '/api': {
    //     target: 'http://172.30.1.17:8080',
    //     pathRewrite: { '^/api': '/jy' },
    //     changeOrigin: true,
    //     secure: false,
    //   },
    // },
    // headers: { 'Access-Control-Allow-Origin': '*' },
  },
};
