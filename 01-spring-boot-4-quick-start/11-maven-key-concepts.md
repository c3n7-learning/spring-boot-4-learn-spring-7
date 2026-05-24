# Maven Key Concepts

- POM File - pom.xml
- Project Coordinates

## POM File - pom.xml

- Project Object Model file: POM file
- Configuration file for your project
- Basically your “shopping list” for Maven :-)
- Located in the root of your Maven project

### POM File Structure

1. Project meta data: Project name, version etc Output file type: JAR, WAR, …
2. Dependencies: List of projects we depend on Spring, Hibernate, etc…
3. Plugins: Additional custom tasks to run: generate JUnit test reports etc…

### Simple POM File

```xml
<project ...>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.luv2code</groupId>

    <!-- ========================================================== -->
    <!-- 1. Project name, version etc Output file type: JAR, WAR, … -->
    <!-- ========================================================== -->
    <artifactId>mycoolapp</artifactId>
    <version>1.0.FINAL</version>
    <packaging>jar</packaging>

    <name>mycoolapp</name>

    <!-- ========================================================== -->
    <!-- 2. List of projects we depend on Spring, Hibernate, etc… -->
    <!-- ========================================================== -->
    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.9.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <!-- =================================================================== -->
    <!-- 3. Additional custom tasks to run: generate JUnit test reports etc… -->
    <!-- =================================================================== -->
    <!-- add plugins for customization -->
</project>
```

## Project Coordinates

- Project Coordinates uniquely identify a project
- Similar to GPS coordinates for your house: latitude / longitude
- Precise information for finding your house (city, street, house #)

```xml
<!-- city -->
<groupId>com.luv2code</groupId>

<!-- street -->
<artifactId>mycoolapp</artifactId>

<!-- house number -->
<version>1.0.FINAL</version>
```

### Project Coordinates - Elements

| Name        | Description                                                                                                          |
| ----------- | -------------------------------------------------------------------------------------------------------------------- |
| Group ID    | Name of company, group, or organization. Convention is to use reverse domain name: `com.luv2code`                    |
| Artifact ID | Name for this project: `mycoolapp`                                                                                   |
| Version     | A specific release version like: `1.0`, `1.6`, `2.0` ... If project is under active development then: `1.0-SNAPSHOT` |

### Dependency Coordinates

- To add given dependency project, we need
- **Group ID**, **Artifact ID**
- **Version** is optional …
  - Best practice is to include the **version** (repeatable builds)
- May see this referred to as: **GAV**
- **Group ID**, **Artifact ID** and **Version**

### How to Find Dependency Coordinates

- Option 1: Visit the project page (spring.io, hibernate.org etc)
- Option 2: Visit https://central.sonatype.com (easiest approach)
