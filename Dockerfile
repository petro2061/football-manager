# Builder stage
FROM openjdk:17 AS builder
WORKDIR football-manager-application
ARG JAVA_FILE=target/*.jar
COPY ${JAVA_FILE} book-store-app.jar
RUN java -Djarmode=layertools -jar football-manager-app.jar extract

# Final stage
FROM openjdk:17
WORKDIR football-manager-application
COPY --from=builder football-manager-application/dependencies/ ./
COPY --from=builder football-manager-application/spring-boot-loader/ ./
COPY --from=builder football-manager-application/snapshot-dependencies/ ./
COPY --from=builder football-manager-application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
EXPOSE 8080