# Maven Project Structure

## Standard Directory Structure

Normally when you join a new project

- Each development team dreams up their own directory structure
- Not ideal for new comers and not standardized
- Maven solves this problem by providing a standard directory structure

| Directory          | Description                                                             |
| ------------------ | ----------------------------------------------------------------------- |
| src/main/java      | Your Java source code                                                   |
| src/main/resources | Properties / config files used by your app                              |
| src/main/webapp    | JSP files and web config files other web assets (images, css, js, etc)  |
| src/test           | Unit testing code and properties                                        |
| target             | Destination directory for compiled code. Automatically created by Maven |

## Standard Directory Structure Benefits

For new developers joining a project

- They can easily find code, properties files, unit tests, web files etc …

Most major IDEs have built-in support for Maven

- Eclipse, IntelliJ, NetBeans etc
- IDEs can easily read/import Maven projects

Maven projects are portable

- Developers can easily share projects between IDEs
- No need to fight about which IDE is the best LOL!

## Advantages of Maven

Dependency Management

- Maven will find JAR files for you
- No more missing JARs

Building and Running your Project

- No more build path / classpath issues
- Standard directory structure

## My Personal Best Maven Benefit(s)

- Once you learn Maven, you can join a new project and be productive
- You can build and run a project with minimal local configuration
