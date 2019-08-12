package com.danny.springbatch.batch;

import com.danny.springbatch.model.User;
import com.danny.springbatch.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor

@Component
public class DBWriter implements ItemWriter<User> {

    private final UserRepository userRepository;

    @Override
    public void write(List<? extends User> users) {

        System.out.println("Data Saved for Users: " + users);
        userRepository.saveAll(users);
    }
}