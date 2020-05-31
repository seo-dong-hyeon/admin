package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import com.example.study.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setAccount("test1");
        user.setPassword("test1");
        user.setStatus("REGISTERED");
        user.setPhoneNumber("010-1111-1111");
        user.setRegisteredAt(LocalDateTime.now());
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("Admin");

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);
        Assert.assertEquals(newUser.getAccount(),"test1");
    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-1111");
        Assert.assertNotNull(user);
        System.out.println(user);

    }

    @Test
    public void update(){
        Optional<User> optionalUser = userRepository.findById(3L);
        optionalUser.ifPresent(user -> {
            user.setAccount("newTest");
            user.setUpdatedAt(LocalDateTime.now());
            user.setUpdatedBy("updater");

            userRepository.save(user);
        });
    }

    @Test
    @Transactional // rollback
    public void delete(){
        Optional<User> optionalUser = userRepository.findById(4L);

        optionalUser.ifPresent(user -> {
            userRepository.delete(user);
        });
    }

}