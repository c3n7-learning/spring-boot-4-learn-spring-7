# Spring Boot REST HTTP Basics

- Most common use of REST is over HTTP
- Leverage HTTP methods for CRUD operations

| HTTP Method | CRUD Operation                           |
| ----------- | ---------------------------------------- |
| POST        | Create a new entity                      |
| GET         | Read a list of entities or single entity |
| PUT         | Update an existing entity                |
| DELETE      | Delete an existing entity                |

## HTTP Messages

![http messages](media/90-4-http-messages.webp)

## HTTP Request Message

- Request line: the HTTP command
- Header variables: request metadata
- Message body: contents of message

```
┌─────────────────────────────────────┐
│          HTTP Request Message       │
├─────────────────────────────────────┤
│                                     │
│  ┌────────────────────────────────┐ │
│  │         Request line           │ │
│  └────────────────────────────────┘ │
│                                     │
│  ┌────────────────────────────────┐ │
│  │      Header variables          │ │
│  └────────────────────────────────┘ │
│                                     │
│  ┌────────────────────────────────┐ │
│  │        Message body            │ │
│  └────────────────────────────────┘ │
│                                     │
└─────────────────────────────────────┘
```

## HTTP Response Message

- Response line: server protocol and status code
- Header variables: response metadata
- Message body: contents of message

```
┌─────────────────────────────────────┐
│         HTTP Response Message       │
├─────────────────────────────────────┤
│                                     │
│  ┌────────────────────────────────┐ │
│  │        Response line           │ │
│  └────────────────────────────────┘ │
│                                     │
│  ┌────────────────────────────────┐ │
│  │      Header variables          │ │
│  └────────────────────────────────┘ │
│                                     │
│  ┌────────────────────────────────┐ │
│  │        Message body            │ │
│  └────────────────────────────────┘ │
│                                     │
└─────────────────────────────────────┘
```

## HTTP Response - Status Codes

| Code Range | Description   |
| ---------- | ------------- |
| 100 - 199  | Informational |
| 200 - 299  | Successful    |
| 300 - 399  | Redirection   |
| 400 - 499  | Client error  |
| 500 - 599  | Server error  |

## MIME Content Types

- The message format is described by MIME content type
- Multipurpose Internet Mail-Extension

- Basic Syntax: `type/sub-type`

Examples

- `text/html`, `text/plain`
- `application/json`, `application/xml`, …

## Client Tool

- We need a client tool
- Send HTTP requests to the REST Web Service / API
- Plenty of tools available: curl, Postman, etc …
- For our lessons, we'll use Postman
