package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());
        //orderDetail.setUserId(7L);
        //orderDetail.setItemId(7L);

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);
    }

    @Test
    public void read(){
        Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(2L);
        Assert.assertTrue(optionalOrderDetail.isPresent());
    }
}
