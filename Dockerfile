# ETAPA 1: Construir el proyecto con Maven
FROM maven:3.8.5-openjdk-17 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el código del proyecto
COPY . .

# Ejecutar el comando de Maven para crear el .jar
RUN mvn clean package -DskipTests

# ETAPA 2: Ejecutar la aplicación
FROM openjdk:17-slim

# Copiar únicamente el archivo .jar de la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Comando para arrancar la aplicación
ENTRYPOINT ["java","-jar","/app.jar"]