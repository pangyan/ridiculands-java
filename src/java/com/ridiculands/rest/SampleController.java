package com.ridiculands.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class SampleController {

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

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}