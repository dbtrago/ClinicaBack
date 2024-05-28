#
# Build stage
#
FROM gradle:latest AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

# Ejecutar comandos de gradle con opciones detalladas
RUN gradle clean --no-daemon --stacktrace --info
RUN gradle bootJar --no-daemon --stacktrace --info

#
# Package stage
#
FROM eclipse-temurin:17-jdk-jammy
ARG JAR_FILE=build/libs/*.jar
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
EXPOSE ${PORT}
ENTRYPOINT ["java","-jar","/app.jar"]
