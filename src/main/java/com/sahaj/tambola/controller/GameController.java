package com.sahaj.tambola.controller;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;
@RestController
@Log4j2
public class GameController {
    private static final Logger logger = LogManager.getLogger(GameController.class);
    //Insecure Deserialization, deserialse without validation.
    @PostMapping("/deserialize")
    public Object deserialize(@RequestBody String data) throws IOException, ClassNotFoundException {
        logger.debug("Debug level - Hello Logback");
        logger.info("Info level - Hello Logback");
        logger.error("Error level - Hello Logback");
        byte[] decodedData = Base64.getDecoder().decode(data);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(decodedData));
        return ois.readObject();
    }
    @GetMapping("/health")
    public String test(){return "health success";}
}
