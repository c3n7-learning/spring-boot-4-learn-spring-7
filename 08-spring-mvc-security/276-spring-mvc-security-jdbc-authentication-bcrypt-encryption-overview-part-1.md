# Spring MVC Security - JDBC Authentication - BCrypt Encryption - Overview - Part 1

## Password Storage

- So far, our user passwords are stored in plaintext … yikes!
- Ok for getting started … but not for production / real-time project :-(

| username | password      | enabled |
| -------- | ------------- | ------- |
| john     | {noop}test123 | 1       |
| mary     | {noop}test123 | 1       |
| susan    | {noop}test123 | 1       |

## Password Storage - Best Practice

- The best practice is store passwords in an encrypted format

| username | password                                                               | enabled |
| -------- | ---------------------------------------------------------------------- | ------- |
| john     | `{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q` | 1       |
| mary     | `{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q` | 1       |
| susan    | `{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q` | 1       |

## Spring Security Team Recommendation

- Spring Security recommends using the popular bcrypt algorithm

`bcrypt`:

- Performs one-way encrypted hashing
- Adds a random salt to the password for additional protection
- Includes support to defeat brute force attacks

## Bcrypt Additional Information

Why you should use bcrypt to hash passwords

- https://www.luv2code.com/why-bcrypt

Detailed bcrypt algorithm analysis

- https://www.luv2code.com/bcrypt-wiki-page

Password hashing - Best Practices

- https://www.luv2code.com/password-hashing-best-practices

## How to Get a Bcrypt password

You have a plaintext password and you want to encrypt using bcrypt

- Option 1: Use a website utility to perform the encryption
- Option 2: Write Java code to perform the encryption

## How to Get a Bcrypt password - Website

Visit: https://www.luv2code.com/generate-bcrypt-password

- Enter your plaintext password
- The website will generate a bcrypt password for you
