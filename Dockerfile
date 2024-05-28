# Utiliza la imagen base de Gradle con el JDK adecuado
FROM gradle:latest AS build

# Copia el proyecto en el contenedor
COPY --chown=gradle:gradle . /home/gradle/src

# Establece el directorio de trabajo
WORKDIR /home/gradle/src

# Limpia el proyecto (opcional)
RUN gradle clean

# Define el puerto que quieres exponer
EXPOSE ${PORT}

# Ejecuta la aplicación usando Gradle
ENTRYPOINT ["gradle", "bootRun"]