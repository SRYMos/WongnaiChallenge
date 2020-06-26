FROM java:8
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} Wongnai-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["./wrapper.sh", "db:3306", "--", "java", "-jar", "Wongnai-0.0.1-SNAPSHOT.jar"]
