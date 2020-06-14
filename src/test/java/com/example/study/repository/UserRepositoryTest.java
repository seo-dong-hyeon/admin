package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import com.example.study.model.entity.User;
import com.example.study.model.enumclass.UserStatus;
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
        User user = User.builder()
                .account("test4")
                .password("test4")
                .status(UserStatus.REGISTERED)
                .phoneNumber("010-4444-4444")
                .build();

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);
        Assert.assertEquals(newUser.getAccount(),"test4");
    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-1111");
        Assert.assertNotNull(user);

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println(orderGroup.getArrivalDate());
            System.out.println(orderGroup.getRevName());
            orderGroup.getOrderDetailList().stream().forEach(orderDetail -> {
                System.out.println(orderDetail.getStatus());
                System.out.println(orderDetail.getArrivalDate());

                System.out.println(orderDetail.getItem().getName());
                System.out.println(orderDetail.getItem().getPartner().getBusinessNumber());
                System.out.println(orderDetail.getItem().getPartner().getCategory().getTitle());

            });
        });

    }

    @Test
    public void update(){
        /*Optional<User> optionalUser = userRepository.findById(3L);
        optionalUser.ifPresent(user -> {
            user.setPassword("test333");

            userRepository.save(user);
        });*/
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-4444-4444");
        user.setEmail("test4@naver.com").setPassword("test44");
        userRepository.save(user);

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