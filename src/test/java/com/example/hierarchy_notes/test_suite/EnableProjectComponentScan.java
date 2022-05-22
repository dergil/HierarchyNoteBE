package com.example.hierarchy_notes.test_suite;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@ComponentScan("com.example.hierarchy_notes")
public @interface EnableProjectComponentScan {
}
