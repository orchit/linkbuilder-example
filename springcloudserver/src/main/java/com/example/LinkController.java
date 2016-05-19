package com.example;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/")
public class LinkController {
    @RequestMapping
    public Resource<String> home(){
        return new Resource<>("Linking your links",
                linkTo(methodOn(LinkController.class).home()).withSelfRel()
        );
    }
}
