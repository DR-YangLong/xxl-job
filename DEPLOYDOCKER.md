# Docker快速部署
通过docker快速进行本机部署，方便进行预研。部署仅为数据库与admin。其中数据库仅部署一个实例。admin部署3个实例。openresty/nginx一个实例。  
3个admin通过nginx进行负载，模拟集群方式，其中2为主，1为备。        
执行client部署参照[此处](#client)。  
admin启动后，默认端口为8080,8081,8082。   
nginx默认端口为80。   
mariadb为3306。

## 部署准备
在直接使用Docker部署前，需要准备Docker环境以及修改相关配置。

### Docker及Docker compose安装
部署需安装Docker，Docker compose请自行参考[官网](https://docs.docker.com/install/)。

## 启停项目

### windows
1. 运行startup.bat进行启动。
2. 运行shutdown.bat进行关闭。

### linux
1. 运行startup.sh进行启动。
2. 运行shutdown.sh进行关闭。

## 可选配置
可根据实际需要修改配置，以下仅列出关键性配置

### 数据库
启动后默认将数据库数据写入到项目下mariadb/data下。可修改docker-compose-mysql.yml中配置。
```yaml
    volumes:
      - ./doc/db/tables_xxl_job.sql:/docker-entrypoint-initdb.d/init.sql
        #本地目录:容器内目录，如果不需要将数据写到容器外，删除这一样
      - ./mariadb/data:/var/lib/mysql
```

### nginx
nginx配置在项目nginx目录下，openresty启动nginx时，会加载此目录下conf.d里的所有配置文件。

## client执行项目部署{#client}

### IDE中使用不同的环境变量启动多个组成本地集群。
如：
```text
1：
SERVER_PORT=9000;XXL_JOB_EXECUTOR_PORT=9900
2：
SERVER_PORT=9001;XXL_JOB_EXECUTOR_PORT=9901
3：
SERVER_PORT=9002;XXL_JOB_EXECUTOR_PORT=9902
```
### 使用命令行启动多个组成本地集群。

在xxl-job-executor-samples/xxl-job-executor-sample-springboot/target下运行以下命令：
```text
1: 
java -jar xxl-job-executor-sample-springboot-2.1.2-SNAPSHOT.jar --server.port=9000 --xxl.job.executor.port=9900
2: 
java -jar xxl-job-executor-sample-springboot-2.1.2-SNAPSHOT.jar --server.port=9001 --xxl.job.executor.port=9901
3: 
java -jar xxl-job-executor-sample-springboot-2.1.2-SNAPSHOT.jar --server.port=9002 --xxl.job.executor.port=9902
```
