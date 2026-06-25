# Advanced Mappings Review Guide - Cheat Sheet

## Mappings - @OneToOne

![one to one](media/345-1-one-to-one.webp)

## Mappings - @OneToMany

![one to many](media/345-2-one-to-many.webp)

## Mappings - @ManyToMany

![many to many](media/345-3-many-to-many.webp)

## Multiple Valid Designs

- For JPA/Hibernate relationships, this isn’t one “right” mapping
- JPA/Hibernate supports several ways to model
  - `@OneToOne`, `@OneToMany`/`@ManyToOne` and `@ManyToMany`
- You may find other solutions online with different approaches
- In this course,
  - Treat the examples as a general guide
  - Adapt when your application requirements and domain needs differ
