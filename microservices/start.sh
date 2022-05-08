docker-compose down
docker rmi eureka-server:latest
docker rmi api-gateway:latest
docker rmi user-service:latest
docker rmi product-service:latest
docker rmi order-service:latest

mvn clean install -f ./eureka-server/pom.xml
mvn clean install -f ./api-gateway/pom.xml
mvn clean install -f ./user-service/pom.xml
mvn clean install -f ./product-service/pom.xml
mvn clean install -f ./order-service/pom.xml

docker build -t eureka-server:latest -f ./eureka-server/Dockerfile ./eureka-server
docker build -t api-gateway:latest -f ./api-gateway/Dockerfile ./api-gateway
docker build -t user-service:latest -f ./user-service/Dockerfile ./user-service
docker build -t product-service:latest -f ./product-service/Dockerfile ./product-service
docker build -t order-service:latest -f ./order-service/Dockerfile ./order-service

docker-compose up -d

echo "Docker compose up. Waiting to run migrations"
sleep 10

mvn flyway:migrate -f ./user-service/pom.xml
mvn flyway:migrate -f ./product-service/pom.xml
mvn flyway:migrate -f ./order-service/pom.xml

echo "Migrations completed. Process finished."