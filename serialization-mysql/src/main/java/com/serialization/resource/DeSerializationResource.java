package com.serialization.resource;

import com.serialization.model.User;
import com.serialization.service.SerializedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/deserialize")
public class DeSerializationResource {

    @Autowired
    private SerializedService serializedService;

    @GetMapping
    public List<User> getUsers() {
        return serializedService.getUsers();
    }

}
