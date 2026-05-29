# Spring Boot REST: OpenAPI and Swagger - Overview

## The Problem

- There is a REST API out there … but we don’t have any documentation
- We have to review the source code to find endpoints: `@GetMapping` etc
- Then use Postman or curl to call the REST API

## My Wish

I wish we could tell our app:

- At run-time, generate API documentation
- Inspect API endpoints based on Spring Configs, annotations etc
- Provide a web UI for accessing endpoints No need for Postman

## Springdoc To The Rescue

https://www.springdoc.org:

- Springdoc is separate open-source project
- Generates API documentation
- Inspects API endpoints based on Spring Configs, annotations etc
- Provides a web UI for accessing endpoints
- No need for Postman

## Springdoc - Swagger Web UI

- Springdoc provides a Swagger web UI for accessing endpoints

## Documenting REST APIs

- OpenAPI is an industry standard format for documenting APIs
  - https://www.openapis.org
- **Swagger UI** is a browser-based UI for interacting with your API
  - Powered by Springdoc-OpenAPI

## Development Process

1. Add Maven dependency for Springdoc
2. Access Swagger UI
3. Retrieve API endpoints as JSON or YAML

### Step 1: Add Maven dependency for Springdoc

```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>x.y.z</version>
</dependency>
```

### Step 2: Access the Swagger UI

By default, Swagger UI is available at:

- http://localhost:8080/swagger-ui/index.html

#### Configure Custom Path for Swagger UI

- Can configure a custom path in application.properties

```
# configure custom path
springdoc.swagger-ui.path=/my-fun-ui.html
```

- Access Swagger UI at
  - http://localhost:8080/my-fun-ui.html

### Step 3: Retrieve API endpoints as JSON or YAML

- Docs for API endpoints available as JSON or YAML
- Useful for integration with other development tools
- Client SDK generation, API mocking, contract testing, etc
- JSON or YAML is language independent
- Can be processed by Python, Javascript, Go, C# etc

By default, JSON docs available here

- http://localhost:8080/v3/api-docs

YAML docs available here

- http://localhost:8080/v3/api-docs.yaml

#### Configure Custom Path for API docs

- Can configure a custom path in application.properties

```
# configure custom path
springdoc.api-docs.path=/my-api-docs
```

- Access API Docs at
  - http://localhost:8080/my-api-docs
  - http://localhost:8080/my-api-docs.yaml
