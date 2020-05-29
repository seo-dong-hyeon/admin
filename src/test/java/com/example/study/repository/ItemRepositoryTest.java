package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();
        item.setName("노트북2");
        item.setPrice(100000);
        item.setContent("삼성노트북2");

        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);
    }

    @Test
    public void read(){
        Optional<Item> optionalItem = itemRepository.findById(7L);
        Assert.assertTrue(optionalItem.isPresent());
    }
}
