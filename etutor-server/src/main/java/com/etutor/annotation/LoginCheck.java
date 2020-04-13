package com.etutor.annotation;

import java.lang.annotation.*;

/**
 * @author ：Lion
 * @date ：2020/01/07
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginCheck {

    String value() default "check";

}
