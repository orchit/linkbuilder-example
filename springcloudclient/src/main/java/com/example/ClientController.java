package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class ClientController {
    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

@RequestMapping
    public Link getServerLink() {
        ParameterizedTypeReference<Resource<String>> responseType = new ParameterizedTypeReference<Resource<String>>() {};
        ResponseEntity<Resource<String>> entity = restTemplate.exchange("http://springcloudserver", HttpMethod.GET, null, responseType);
        return entity.getBody().getId();
    }
}
