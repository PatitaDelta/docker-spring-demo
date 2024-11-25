FROM eclipse-temurin:17.0.13_11-jdk

# Port
EXPOSE 8080

# Crear directorio de trabajo en el docker
WORKDIR /app

#############################################################
# DEPENDECIAS  ##############################################
#############################################################

# Copiar archivos al docker
COPY ./pom.xml /app
COPY ./.mvn /app/.mvn
COPY ./mvnw /app

# Descargar dependencias
RUN ./mvnw dependency:go-offline

# Copiar el resto del codigo
COPY . /app/

#############################################################
# APP  ######################################################
#############################################################

# Construir aplicacion
RUN ./mvnw install -DskipTests

#############################################################
# GIT  ######################################################
#############################################################

# Argumentos git
ARG NAME
ARG EMAIL

# Instalar git
RUN apt-get update
RUN apt-get upgrade -y 
RUN apt-get install -y git

# Configurar git config con los datos del usr
RUN git init

RUN git config --global user.name ${NAME}
RUN git config --global user.email ${EMAIL}
RUN git config --global core.autocrlf input
RUN git config --global color.ui auto
# RUN git push --set-upstream origin main

#############################################################
# Claves ssh ################################################
#############################################################

RUN mkdir /root/.ssh

#############################################################
# FINAl #####################################################
#############################################################

# Lanzar app

# Production 
# ENTRYPOINT [ "java", "-jar", "./target/docker-demo-0.0.1-SNAPSHOT.jar"]

# Develop
# ENTRYPOINT [ "tail", "-F", "./logs/errors.log"]
ENTRYPOINT [ "./mvnw", "spring-boot:run"]