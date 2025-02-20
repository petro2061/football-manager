FROM openjdk:17-jdk-slim
WORKDIR /app
RUN apt-get update && apt-get install -y netcat && rm -rf /var/lib/apt/lists/*
COPY target/football-manager-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
