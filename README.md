# oneroster-api-mock

A RESTful API built to the [OneRoster specification](https://www.imsglobal.org/activity/onerosterlis#publicdocuments), for use in developing a OneRoster connector for the [Adobe User Sync Tool](https://github.com/adobe-apiplatform/user-sync.py). Visit the live [production server](https://oneroster.thenewcarag.com/) for the latest successful build. Read the [docs](https://oneroster.thenewcarag.com/swagger-ui.html) for endpoint details. 

This API exists to facilitate an update the User Sync Tool to be able to read from OneRoster implementations like it does other directories. Now that this API is created, building the python connector for the User Sync Tool becomes feasible as this API provides a set of endpoints to test new UST code against.

## Documentation

The [documentation](https://oneroster.thenewcarag.com/swagger-ui.html) describes the suite of resource endpoints, however the OAuth-related endpoints are discussed here instead:

`oa/{any resource endpoint}`: All resource endpoints  are also available as secured endpoints requiring authentication. 

`/oauth/token`: POST Using basic authentication (Username: *oruser*, Password: *secret*) to obtain a token. This token is used to access the secured endpoints described above.

## How to Use

This API makes available a suite of read-only endpoints that respond with sample data meant to simulate a live OneRoster system. To quickly sample an API endpoint, you can enter a resource endpoint URL (found in the [documentation](https://oneroster.thenewcarag.com/swagger-ui.html)) into a browser window or use the documentation's 'Try it out!' feature. 

If you want to try out the secured, `oa/` endpoints, you'll need to use an application such as Postman. Here's how:

Prepare a POST request in Postman to the URL `https://oneroster.thenewcarag.com/oauth/token`:

![Step01](https://raw.githubusercontent.com/janssenda-adobe/oneroster-api-mock/master/images/step01.PNG)

Under the Authorization tab, select Basic Auth supplying the oa username and password. Your POST request should now look like this:

![Step02](https://raw.githubusercontent.com/janssenda-adobe/oneroster-api-mock/master/images/step02.PNG)

Next, under the Body tab, select x-www-form-urlencoded and enter a key-value pair of **key**: *grant_type* and **value:** *client_credentials*, as such:

![Step03](https://raw.githubusercontent.com/janssenda-adobe/oneroster-api-mock/master/images/step03.PNG)

Submit the POST request, and you will receive a response that contains your token:

![Step04](https://raw.githubusercontent.com/janssenda-adobe/oneroster-api-mock/master/images/step04.PNG)

Now we'll create a GET request with the type Bearer Token pointed at a secured resource endpoint, such as `oa/teachers/`. Enter the "access_token" you received from the call to `oauth/token`:

![Step05](https://raw.githubusercontent.com/janssenda-adobe/oneroster-api-mock/master/images/step05.PNG)

The API response will be the same as the unsecured resource endpoint as long as the bearer_token is valid.

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Core application framework.
* [Gradle](https://gradle.org/) - Java build tool.
* [H2 Database Engine](http://www.h2database.com/html/main.html) - In-memory SQL database.
* [Jenkins](https://jenkins.io/) - CI/CD platform.
* [Karate](https://github.com/intuit/karate) - REST API testing framework.
* [Swagger](https://swagger.io/) - REST API documentation generator.
* [Showdown](http://showdownjs.com/), [jQuery](https://jquery.com/), [Bootstrap](https://getbootstrap.com/) - Frontend shenanigans.

## Structure

```
├───api                                    # Core Spring Boot API Project
|    ├───src/main/java/com.dm.onerosterapi/
|    |  ├───apiconfig                      # Core API configuration
|    |  ├───controller                     # Resource controllers
|    |  ├───doc                            # Swagger configuration
|    |  ├───exceptions                     # Custom exceptions
|    |  ├───model                          # Java data models
|    |  ├───repository                     # DAOs and JPA repositories
|    |  ├───service                        # Resource-oriented service layer
|    |  ├───utility                        # General utility classes
├───data                                   # Database files (CSV and SQL)
├───enrollment-generator                   # Utility for generating enrollment data
```
## Tests

**Unit Tests**: JUnit tests are found at ```api\src\test\java\com\dm\onerosterapi\service```. Run with `./gradlew unitTest` from the ```api``` directory.

**Integration Tests**: Karate integration tests are found at `api\src\test\resources\features`. Run with `./gradlew karateTest -Dkarate.env={env}'` and supply the proper environment. See `karate-config.js` in the above directory for base URL details based on environment.

## Deployment

This project leverages a Jenkins CI/CD pipeline for orchestrated build and deployment. Access to the [Jenkins server](69.180.163.254:8080) available on request.

### Pipeline Workflow

What follows is a high level overview of the pipeline actions taken on every commit for this project. See the Jenkinsfile for specific details.

* Perform unit tests.
* Build project and obtain .jar file.
* Deploy .jar file to stage server.
* Perform integration tests against stage server.
* Deploy .jar file to production server *if and only if* all tests passed and the commit is on master branch.

## Acknowledgments

* [ClassLink's example API](https://developer.classlink.com/) was invaluable in the development of this project.
                                    