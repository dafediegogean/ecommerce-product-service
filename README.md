# E-commerce Product Service

An microservice with Java 11, Spring Cloud Hoxton SR4, Open Feign for 
RESTful Client, Netflix Ribbon, Netflix Hystrix, Spring Cloud Sleuth, 
Zipkin, Spring Cloud Starter Bus and Spring Cloud Config Client

## Reference Documentation

### Microservice

-   ecommerce-product-service

### Description

> **ecommerce-product-service**

Microservice responsible for providing a list or individual product.


## Installation

-   Docker: [https://docs.docker.com/get-docker/](https://docs.docker.com/get-docker/)
-   Maven: [https://maven.apache.org/install.html](https://maven.apache.org/install.html)

## Starting services

### 1. Build Project

```
$ mvn clean install -U
```

### 2. Build docker image

```
$ docker build -t ${APPLICATION_NAME}:latest
```

### 3. Run the container

```
$ docker run -d --rm --network=host ${APPLICATION_NAME}:latest
```

-   Use the host's network stack inside the container.

### 4.Removing and cleaning the containers

```
$ docker stop ${CONTAINER_ID}
```
