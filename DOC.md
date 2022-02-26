## BayzTracker - Design
I have designed reading is good and its project structure with the mind set of having a clean architecture and code.
To achieve this BayzTracker utilizes exception handling, and other spring boot annotations.
Services only communicate themselves in the service level because I wanted to maintain the level of abstraction between them.
In the end, I would say that the reading is good service can be considered as a giant microservice but loosely coupled on the inside because of applied SOLID principles.


## TECH STACK
    • Java 17
    • Spring Boot 2.6.3 (Please refer to the build.gradle file for the dependencies)
    • Lombok
    • Docker, Docker-Compose and Docker Hub
    • Gitkraken and GitLab

## How to use
Requires JDK17 Gradle Docker and Docker-compose to build and run. One can refer to the postman collection in order to get a knowledge about how to use the application.

Please add both admin and user roles before testing. This is a very important step.

Luckily I have pushed the latest Docker image to the Docker Hub as a public container image. Hence, only docker compose run command below is sufficient.

    > docker-compose -f docker-compose.yaml up

## Improvement ideas
    • Time did not allow to write any test cases at all. I could have used TDD at the beginning but chose not to. I skipped this because it was optional.
    
    • I also could have made 4 seperate microservices in terms of high level design, correspond to the feature branches I have opened.
    One can apply seperation of concerns and develop Currency, Alert, Authorization/User/Role, Order and Trigger microservices.
