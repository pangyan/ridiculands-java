package com.ridiculands.rest;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController extends SpringBootServletInitializer {

    @RequestMapping("/firstspringboot")
    @ResponseBody
    String home() {
		return "Hello World!  DNLMCFH.";
	}

    @RequestMapping("/secondspringboot")
    @ResponseBody
    String home2() {
        return "Hello World!  DNLMCFH 2.";
    }

//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(SampleController.class, args);
//    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SampleController.class, RidiculandsController.class);
    }
}