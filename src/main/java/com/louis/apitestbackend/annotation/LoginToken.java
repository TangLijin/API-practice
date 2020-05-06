package com.louis.apitestbackend.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) //加了这个注解后，每次启动后都需要重新生成token
public @interface LoginToken {
    boolean required() default true;
}
