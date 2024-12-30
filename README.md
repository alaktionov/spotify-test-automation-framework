## Overview

Test Automation Framework written in Java for testing Spotify Web [API](https://developer.spotify.com/documentation/web-api) and [UI](https://open.spotify.com/) 
 
> - The framework is just a showcase of a possible approach to testing Spotify Web UI and API
> - The framework covers only a few endpoints of Artists API, but can be easily extended for other APIs
> - The framework covers only basic Login functionality on UI, but can be easily extended for other UI functionalities
> - The framework has just a default profile with properties for **prod** env specified in application.yml (PASSWORD and CLIENT_SECRET values have been extracted to GitHub environments secrets)
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

Compile the project:
```shell
mvn clean compile
```

Run tests:
```shell
mvn test
```
> NOTE: tests are executed on Chrome by default. If you need to run them on another browser add the following parameter: `-Dbrowser=firefox` 

Generate and view reports:
```shell
allure serve target/allure-results
```

## Running Tests via GitHub Actions

1. Go to the Actions tab
2. Select the On-Demand Test Execution workflow
3. Click Run workflow, choose the environment, and start the execution
> Note: only prod is available for now 
4. When the run is complete, download attached report, unzip it and using the following command open:
```shell
allure serve allure-report
```
5. Example of Allure report:
![image](https://github.com/user-attachments/assets/75e2df33-a243-4791-855d-ba916d936add)

