## Overview

Test Automation Framework written in Java for testing [Spotify Web API.](https://developer.spotify.com/documentation/web-api)
 
> - The framework is just a showcase of a possible approach to testing Spotify Web API
> - The framework covers only a few endpoints of Artists API, but can be easily extended for other APIs
> - The framework supports only API-based testing, but can be easily adjusted for UI testing if needed
> - The framework has just a default profile with properties for **prod** env specified in application.yml (CLIENT_SECRET value has been extracted to GitHub environments secrets)
> - The framework has a simple example of CI/CD pipeline

## Technology stack

- Java 21
- Maven
- Spring Boot
- REST-Assured
- JUnit5
- Allure
- GitHub Actions

## Local test execution

Clone the repository:
```shell
git clone <repository-url>
cd <repository-name>
```

> NOTE: Make sure to set **baseApiUrl**, **clientId** and **clientSecret** values for your user in application.yml

Build the project:
```shell
mvn clean install
```

Run tests:
```shell
mvn test
```

Generate and view reports:
```shell
allure serve target/allure-results
```

## Running Tests via GitHub Actions

1. Go to the Actions tab
2. Select the On-Demand Test Execution workflow
3. Click Run workflow, choose the environment, and start the execution