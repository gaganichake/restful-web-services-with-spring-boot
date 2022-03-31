package com.gagan.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Jim Preston");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Jim", "Preston"));
    }

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 personParamV1(){
        return new PersonV1("Jim Preston");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 personParamV2(){
        return new PersonV2(new Name("Jim", "Preston"));
    }

    @GetMapping(value = "/person", headers = "X-API-VERSION=1")
    public PersonV1 personHeaderV1(){
        return new PersonV1("Jim Preston");
    }

    @GetMapping(value = "/person", headers = "X-API-VERSION=2")
    public PersonV2 personHeaderV2(){
        return new PersonV2(new Name("Jim", "Preston"));
    }

}
