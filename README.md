docker network create my-network

docker run \
-p 3307:3306 \
--restart=always \
--name mysql-container \
--network=my-network \
--privileged=true \
-v $(pwd)/mysql/log:/var/log/mysql \
-v $(pwd)/mysql/data:/var/lib/mysql \
-v $(pwd)/mysql/conf/my.cnf:/etc/mysql/my.cnf \
-e MYSQL_ROOT_PASSWORD=headmaster \
-d mysql:8.0

docker run \
--name spring-boot-app \
--network=my-network \
-p 8080:8080 \
-d bookstore-backend


mysql -h 127.0.0.1 -P 3307 -u root -p

mysqldump -u root -p --host=127.0.0.1 --port=3306 SingleBookstore > bookstore.sql

docker cp bookstore.sql mysql-container:/tmp/bookstore.sql

docker exec -it mysql-container bash

mvn clean package -DskipTests

docker compose up --build    
