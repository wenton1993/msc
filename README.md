# myspringcloud
学习项目

## 常用 Maven 命令(已废弃)
### myspringcloud-demo
构建、运行和推送镜像
```
// 打包(可省略)
mvn clean package -am -pl myspringcloud-demo -Dmaven.test.skip=true
// 构建镜像
docker build -t wenton1993/myspringcloud-demo:1.0-SNAPSHOT .
// 启动
docker run -p 8771:8771 wenton1993/myspringcloud-demo
// 查看正在运行的容器
docker container ls
// 停止容器
docker container stop <containerId>
// 推送镜像到仓库
docker push wenton1993/myspringcloud-demo:1.0-SNAPSHOT
```
其它Docker命令
```
// 删除容器和镜像
docker container rm wenton1993/myspringcloud-demo
docker image rm wenton1993/myspringcloud-demo
// 查看容器和镜像
docker container ls
docker image ls
// 从镜像仓库获取镜像
docker pull wenton1993/myspringcloud-demo
// 启动容器
docker-compose up
```