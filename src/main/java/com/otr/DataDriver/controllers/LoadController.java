package com.otr.DataDriver.controllers;


import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.otr.DataDriver.models.Card;
import com.otr.DataDriver.repositories.CardRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@RestController
public class LoadController {

    @Autowired
    CardRepository repository;

    Resource resource = new ClassPathResource("loadSpec.json");

    InputStream input = resource.getInputStream();

    private static ObjectMapper objectMapper = new ObjectMapper();

    private final static Logger logger = LoggerFactory.getLogger(LoadController.class);

    public LoadController() throws IOException {
    }


    @PostMapping("/loads")
    public void postLoads(@RequestBody String requestBody){
        Object loads_raw = JsonUtils.jsonToObject(requestBody);
        List chainrSpecJSON = JsonUtils.jsonToList(input);
        Chainr chainr = Chainr.fromSpec(chainrSpecJSON);
        Object transformedOutput = chainr.transform(loads_raw);
        String formattedJSON = JsonUtils.toJsonString(transformedOutput);
        Card[] cards = null;
        try {
            cards = objectMapper.readValue(formattedJSON, Card[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        repository.saveAll(Arrays.asList(cards));
        System.out.println();
    }


}
