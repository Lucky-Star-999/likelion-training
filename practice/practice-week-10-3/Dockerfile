FROM maslick/minimalka:jdk11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} practice-week-10-3-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/practice-week-10-3-0.0.1-SNAPSHOT.jar"]