package com.dss.database.practice.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface Column {
    String name() default "";
    String dataType() default "";
    int length() default 10;
    boolean unique() default false;
    boolean primaryKey() default false;
    boolean nullable() default false;
}
