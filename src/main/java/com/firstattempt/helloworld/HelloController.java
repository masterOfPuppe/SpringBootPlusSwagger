package com.firstattempt.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/api/hello/{name}")
    public String setHello(@PathVariable("name") String name) {
        return "Swagger Hello World " + name;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/hello", params = "name")
    public String setHello2(@RequestParam("name") String name) {
        return "Swagger Hello World " + name;
    }

}
