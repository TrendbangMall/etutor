package com.etutor.annotation;

import java.lang.annotation.*;

/**
 * @author Winter
 * @date
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginCheck {

    String value() default "check";

}
