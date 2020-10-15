module.exports = {
    css: {
        loaderOptions: {
            sass: {
                additionalData: '@import "@/styles/base.scss";'
            }
        }
    },
    devServer: {
        proxy: 'https://localhost:1337'
    }
}
