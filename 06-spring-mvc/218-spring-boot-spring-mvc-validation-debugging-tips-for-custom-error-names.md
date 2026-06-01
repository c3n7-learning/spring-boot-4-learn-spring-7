# Spring Boot - Spring MVC Validation - Debugging Tips for Custom Error Names

Hands On: `06-spring-mvc/code/02-validationdemo`

Let's print stuff out:

```java
@PostMapping("/processForm")
public String processForm(
        @Valid @ModelAttribute("customer") Customer theCustomer,
        BindingResult theBindingResult
) {

    System.out.println("Last name: |" + theCustomer.getLastName() + "|");

    System.out.println("Binding results: " + theBindingResult.toString());

    System.out.println("\n\n\n\n");

    if (theBindingResult.hasErrors()) {
        return "customer-form";
    }

    return "customer-confirmation";
}
```

We see:

```
Binding results: org.springframework.validation.BeanPropertyBindingResult: 1 errors
Field error in object 'customer' on field 'freePasses': rejected value [Quibusdam et qui eum]; codes [typeMismatch.customer.freePasses,typeMismatch.freePasses,typeMismatch.java.lang.Integer,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [customer.freePasses,freePasses]; arguments []; default message [freePasses]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'java.lang.Integer' for property 'freePasses'; For input string: "Quibusdametquieum"]
```

Of importance to us is:

```
codes [typeMismatch.customer.freePasses,typeMismatch.freePasses,typeMismatch.java.lang.Integer,typeMismatch]
```

- We can be as specific as possible (`typeMismatch.customer.freePasses`)
- Or as generic as we'd wish to be (`typeMismatch`)
