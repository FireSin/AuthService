package ru.firesin.my_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface MySecured {
    String[] value();
}
