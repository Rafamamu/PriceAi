FROM eclipse-temurin:17-jdk
WORKDIR /app
LABEL authors="rafaroga46@gmail.com"
COPY target/PriceAi-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]