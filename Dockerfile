FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ecommerce-product-service.jar
ENTRYPOINT ["java","-jar","/ecommerce-product-service.jar"]
