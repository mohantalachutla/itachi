FROM openjdk:11
FROM maven
EXPOSE 5004
ARG APP_NAME=EkartPaymentApi
ARG HOME=/ekart/EkartPaymentApi
ARG DOCKER_FILE=EkartPaymentApi.jar
VOLUME ["/ekart/EkartPaymentApi"]
WORKDIR /ekart/EkartPaymentApi
COPY . .
RUN mvn install
ENTRYPOINT ["java","-jar", "EkartPaymentApi.jar"]

