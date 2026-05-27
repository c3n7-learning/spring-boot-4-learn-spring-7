# JSON Basics

## What is JSON?

- JavaScript Object Notation
- Lightweight data format for storing and exchanging data … plain text
- Language independent … not just for JavaScript
- Can use with any programming language: Java, C#, Python etc …

## Simple JSON Example

- Curley braces define objects in JSON

- Object members are name / value pairs
  - Delimited by colons

- Name is always in double-quotes

```json
{
  "id": 14,
  "firstName": "Mario",
  "lastName": "Rossi",
  "active": true
}
```

## JSON Values

- Numbers: no quotes
- String: in double quotes
- Boolean: `true`, `false`
- Nested JSON object
- Array
- `null`

## Nested JSON Objects

```json
{
  "id": 14,
  "firstName": "Mario",
  "lastName": "Rossi",
  "active": true,
  "address": {
    "street": "100 Main St",
    "city": "Philadelphia",
    "state": "Pennsylvania",
    "zip": "19103",
    "country": "USA"
  }
}
```

## JSON Arrays

```json
{
  "id": 14,
  "firstName": "Mario",
  "lastName": "Rossi",
  "active": true,
  "languages": ["Java", "C#", "Python", "Javascript"]
}
```
