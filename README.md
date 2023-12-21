**Note**
This service should be started after <b>library-api-service-registry</b> service in order to make service discovery mechanism work properly!


To run <i>library-service</i> follow this steps:
1. Open mysql console and run command ```create schema library``` and then ```use library```
2. Go to the ```src/main/resources/application.properties``` file and replace values of ```spring.datasource.username``` and ```spring.datasource.password``` with your actual mysql username and password
3. Open a terminal and run ```mvn clean package -Dskiptests```
4. Run ```java -jar library-service-0.0.1-SNAPSHOT.jar```

After completing these steps, your service will run at [```localhost:8082```](http://localhost:8082)

Also you will be able to see full API documentation at [```localhost:8082/swagger-ui/index.html```](http://localhost:8082/swagger-ui/index.html)
