package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setAccount("test2");
        user.setEmail("test2@naver");
        user.setPhoneNumber("010-2222-2222");
        user.setCreateAt(LocalDateTime.now());
        user.setCreateBy("admin");

        User newUser = userRepository.save(user);
        System.out.println(newUser);
    }

}