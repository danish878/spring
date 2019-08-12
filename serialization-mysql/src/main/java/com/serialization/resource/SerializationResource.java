package com.serialization.resource;

import com.serialization.model.User;
import com.serialization.service.SerializedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/serialize")
public class SerializationResource {

    @Autowired
    private SerializedService serializedService;

    @PostMapping
    public String post(@RequestBody final User user) {

        serializedService.persist(user);

        return "User data saved!!!";
    }
}
