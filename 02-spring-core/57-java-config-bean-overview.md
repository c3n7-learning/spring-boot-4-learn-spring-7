# Java Config Bean - Overview

Configuring Beans with Java Code

## Our New Coach …

- We won't use special annotations on the code
- We want it to be injected though

```java
package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach {
  // …
}
```

## Development Process

1. Create @Configuration class
2. Define `@Bean` method to configure the bean
3. Inject the bean into our controller

### Step 1: Create a Java class and annotate as @Configuration

```java
package com.luv2code.springcoredemo.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
  …
}
```

### Step 2: Define `@Bean` method to configure the bean

- The bean id defaults to the method name (`swimCoach`)

```java
package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
  @Bean
  public Coach swimCoach() {
    return new SwimCoach();
  }
}
```

### Step 3: Inject the bean into our controller

- Inject the bean using the bean id: `swimCoach`

```java
package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
  private Coach myCoach;

  @Autowired
  public DemoController(@Qualifier("swimCoach") Coach theCoach) {
    System.out.println("In constructor: " + getClass().getSimpleName());
    myCoach = theCoach;
  }
  // …
}
```

## Use case for @Bean

You may wonder …

- _Using the “new” keyword … is that it???_
- _Why not just annotate the class with `@Component`???_

## Use case for @Bean

- Make an existing third-party class available to Spring framework
- You may not have access to the source code of third-party class
- However, you would like to use the third-party class as a Spring bean

## Real-World Project Example

Our project used Amazon Web Service (AWS) to store documents

- Amazon Simple Storage Service (Amazon S3)
- Amazon S3 is a cloud-based storage system
- can store PDF documents, images etc

We wanted to use the AWS S3 client as a Spring bean in our app.

The AWS S3 client code is part of AWS SDK

- We can’t modify the AWS SDK source code
- We can’t just add `@Component`
- However, we can configure it as a Spring bean using `@Bean`

### Configure AWS S3 Client using @Bean

```java
package com.luv2code.springcoredemo.config;

...
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class DocumentsConfig {

    @Bean
    public S3Client remoteClient() {

        // Create an S3 client to connect to AWS S3
        ProfileCredentialsProvider credentialsProvider = ProfileCredentialsProvider.create();
        Region region = Region.US_EAST_1;
        S3Client s3Client = S3Client.builder()
                .region(region)
                .credentialsProvider(credentialsProvider)
                .build();

        return s3Client;
    }
}
```

### Inject the S3Client as a bean

```java
package com.luv2code.springcoredemo.services;

import software.amazon.awssdk.services.s3.S3Client;
...

@Component
public class DocumentsService {

    private S3Client s3Client;

    @Autowired
    public DocumentsService(S3Client theS3Client) {
        s3Client = theS3Client;
    }

    ...
}
```

### Store our document in S3

```java
package com.luv2code.springcoredemo.services;

import software.amazon.awssdk.services.s3.S3Client;
...

@Component
public class DocumentsService {

    private S3Client s3Client;

    @Autowired
    public DocumentsService(S3Client theS3Client) {
        s3Client = theS3Client;
    }

    public void processDocument(Document theDocument) {

        // get the document input stream and file size ...

        // Store document in AWS S3
        // Create a put request for the object
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(subDirectory + "/" + fileName)
                .acl(ObjectCannedACL.BUCKET_OWNER_FULL_CONTROL).build();

        // perform the putObject operation to AWS S3 ... using our autowired bean
        s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(fileInputStream, contentLength));
    }
}
```

## Wrap Up

- We could use the Amazon S3 Client in our Spring application
- The Amazon S3 Client class was not originally annotated with `@Component`
- However, we configured the S3 Client as a Spring Bean using `@Bean`
- It is now a Spring Bean and we can inject it into other services of our application
- _Make an existing third-party class available to Spring framework_
