package com.winter.etutor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Winter
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String testSpringBoot() {
        return "hello spring boot word!";
    }
}
