# Spring Boot - GetMapping and PostMapping - Overview

## Most Commonly Used HTTP Methods

| Method | Description                       |
| ------ | --------------------------------- |
| GET    | Requests data from given resource |
| POST   | Submits data to given resource    |
| others | ...                               |

## Sending Data with GET method

```html
<form th:action=“@{/processForm}” method="GET" …>
…
</form>
```

Form data is added to end of URL as name/value pairs

- `theUrl?field1=value1&field2=value2…`

## Handling Form Submission

```java
@RequestMapping("/processForm")
public String processForm(...) {
  ...
}
```

This mapping handles ALL HTTP methods

- GET, POST, etc …

## Constrain the Request Mapping - GET

```java
@RequestMapping(path="/processForm", method=RequestMethod.GET)
public String processForm(...) {
  ...
}
```

- This mapping ONLY handles GET method
- Any other HTTP REQUEST method will get rejected

## Annotation Short-Cut

```java
@GetMapping("/processForm")
public String processForm(...) {
  ...
}
```

- `@GetMapping`: this mapping ONLY handles GET method
- Any other HTTP REQUEST method will get rejected

## Sending Data with POST method

```html
<form th:action=“@{/processForm}” method="POST" …>
…
</form>
```

- Form data is passed in the body of HTTP request message

## Constrain the Request Mapping - POST

```java
@RequestMapping(path="/processForm", method=RequestMethod.POST)
public String processForm(...) {
  ...
}
```

- This mapping ONLY handles POST method
- Any other HTTP REQUEST method will get rejected

## Annotation Short-Cut

```java
@PostMapping("/processForm")
public String processForm(...) {
  ...
}
```

- `@PostMapping`: This mapping ONLY handles POST method
- Any other HTTP REQUEST method will get rejected

## Well …. which one???

GET:

- Good for debugging
- Bookmark or email URL
- Limitations on data length

POST

- Can’t bookmark or email URL
- No limitations on data length
- Can also send binary data
