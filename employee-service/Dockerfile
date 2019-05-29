from java:8
expose 8080:8080

add /target/employee-service-0.0.1-SNAPSHOT.jar /opt/employee-service-0.0.1-SNAPSHOT.jar

workdir /opt

entrypoint ["java","-jar","employee-service-0.0.1-SNAPSHOT.jar"]
