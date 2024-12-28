const base = {
    get() {
        return {
            url : "http://localhost:8080/lelenongchanpinxiaoshou/",
            name: "lelenongchanpinxiaoshou",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/lelenongchanpinxiaoshou/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "助农平台后台管理系统"
        }
    }
}
export default base
