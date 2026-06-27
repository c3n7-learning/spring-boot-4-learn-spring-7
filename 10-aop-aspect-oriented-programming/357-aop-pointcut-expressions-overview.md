# AOP - Pointcut Expressions - Overview

## AOP Terminology

- **Pointcut**: A predicate expression for where advice should be applied

## Pointcut Expression Language

- Spring AOP uses AspectJ’s pointcut expression language
- We will start with **execution** pointcuts
  - Applies to **execution** of methods

## Match on Method Name

### Pointcut Expression Language

```
execution(modifiers-pattern? return-type-pattern declaring-type-pattern?
          method-name-pattern(param-pattern) throws-pattern?)
```

The pattern is optional if it has “?”:

- `modifiers-pattern?`: public, protected and (default/none: package-visible)
- `return-type-pattern`: void, boolean, String, `List<Customer>`, ...
- `declaring-type-pattern?`: the class name
- `method-name-pattern`: Method name to match
  - `(param-pattern)`: Parameter types to match
- `throws-pattern?`: Exception types to match

### Pointcut Expression Examples

#### Example #1

Match on method names

- Match only **addAccount()** method in **AccountDAO** class

![example 1](media/357-1-example-1.webp)

#### Example #2

Match on method names

- Match any **addAccount()** method in **any** class

![example 2](media/357-2-example-2.webp)

#### Example #3

Match on method names (using wildcards)

- Match methods **starting** with **add** in any class

![example 3](media/357-3-example-3.webp)

#### Example #4

Match on method names (using wildcards)

- Match methods **starting** with **processCreditCard** in any class

![example 4](media/357-4-example-4.webp)

#### Example #5

Use wildcards on return type:

![example 5](media/357-5-example-5.webp)

#### Example #6

Modifier is optional … so you don’t have to list it

![example 6](media/357-6-example-6.webp)
