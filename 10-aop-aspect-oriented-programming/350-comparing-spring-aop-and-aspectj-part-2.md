# Comparing Spring AOP and AspectJ - Part 2

## Spring AOP Comparison

**Advantages**:

- Simpler to use than AspectJ
- Uses Proxy pattern
- Can migrate to AspectJ when using `@Aspect` annotation

**Disadvantages**:

- Only supports method-level join points
- Can only apply aspects to beans created by Spring app context
- Minor performance cost for aspect execution (run-time weaving)

## AspectJ Comparison

**Advantages**:

- Support all join points
- Works with any POJO, not just beans from app context
- Faster performance compared to Spring AOP
- Complete AOP support

**Disadvantages**:

- Compile-time weaving requires extra compilation step
- AspectJ pointcut syntax can become complex

## Comparing Spring AOP and AspectJ

Spring AOP only supports

- Method-level join points
- Run-time code weaving (slower than AspectJ)

AspectJ supports

- join points: method-level, constructor, field
- weaving: compile-time, post compile-time and load-time

## Comparing Spring AOP and AspectJ

- Spring AOP is a light implementation of AOP
- Solves common problems in enterprise applications

My recommendation

- Start with Spring AOP … easy to get started with
- If you have complex requirements then move to AspectJ

## Additional Resources

- _AspectJ in Action_ by Raminvas Laddad
- _Aspect-Oriented Development with Use Cases_ by Ivar Jacobson and Pan-Wei Ng
