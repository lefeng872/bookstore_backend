#~/.docker/daemon.json
#docker build -t bookstore-backend .
#mvn clean package -DskipTests

# 使用官方的 OpenJDK 镜像作为基础镜像
FROM openjdk:17-jdk

WORKDIR /app

# 将构建出来的 JAR 包添加到镜像中
COPY target/bookstore_backend-0.0.1-SNAPSHOT.jar /app/app.jar

# 设置容器启动时执行的命令
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# 暴露容器的端口（假设应用程序监听 8080 端口）
EXPOSE 8080
