package com.serialization.service;

import com.serialization.model.SerializedUser;
import com.serialization.model.User;
import com.serialization.repository.SerializedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class SerializedService {

    @Autowired
    private SerializedUserRepository repository;

    public void persist(User user) {
        //convert user to byte[]
        byte[] serializedUser = convertToByteArray(user);

        //pesist
        SerializedUser serializedObject = new SerializedUser(serializedUser);
        repository.save(serializedObject);


    }

    private byte[] convertToByteArray(User user) {

        try (
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);) {

            objectOutputStream.writeObject(user);

            return outputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getUsers() {

        return repository.findAll()
                .stream()
                .map(serializedUser -> convertToUser(serializedUser.getSerializedUser()))
                .collect(Collectors.toList());
    }

    private User convertToUser(byte[] serializedUser) {

        try(
        ByteArrayInputStream inputStream = new ByteArrayInputStream(serializedUser);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);) {
            User user = (User) objectInputStream.readObject();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
