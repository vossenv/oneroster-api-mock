# oneroster-api-mock

A mock API built to the [OneRoster specification](https://www.imsglobal.org/activity/onerosterlis#publicdocuments), for use in developing a OneRoster connector for the [Adobe User Sync Tool](https://github.com/adobe-apiplatform/user-sync.py). Visit the live [production server](https://oneroster.thenewcarag.com/) for the latest successful build. Read the [docs](https://oneroster.thenewcarag.com/swagger-ui.html) for endpoint details.

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Core application framework.
* [Gradle](https://gradle.org/) - Java build tool.
* [H2 Database Engine](http://www.h2database.com/html/main.html) - In-memory SQL database.
* [Jenkins](https://jenkins.io/) - CI/CD platform.
* [Karate](https://github.com/intuit/karate) - REST API testing framework.
* [Swagger](https://swagger.io/) - REST API documentation generator.

## Project

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

**Unit Tests**: JUnit tests are found at ```api\src\test\java\com\dm\onerosterapi\service```. Run with `./gradlew unitTest`.

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
                                    