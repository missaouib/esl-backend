FROM maven:3.6.1-jdk-11 AS MAVEN_BUILD
COPY pom.xml /tmp/
COPY ./ /tmp
WORKDIR /tmp
RUN mvn package

# FROM openjdk:11
# COPY --from=MAVEN_BUILD /tmp/eladmin-system/target/eladmin-system-2.6-jar-with-dependencies.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/tmp/eladmin-system/target/eladmin-system-2.6-jar-with-dependencies.jar"]