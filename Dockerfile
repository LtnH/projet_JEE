FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw && \
    ./mvnw dependency:resolve

VOLUME src ./src

CMD ["./mvnw", "spring-boot:run"]