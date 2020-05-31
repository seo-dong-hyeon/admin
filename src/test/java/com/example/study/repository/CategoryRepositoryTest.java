package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends StudyApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        Category category = new Category();
        category.setType("COMPUTER");
        category.setTitle("컴퓨터");
        category.setCreatedAt(LocalDateTime.now());
        category.setCreatedBy("Admin");

        Category newCategory = categoryRepository.save(category);
        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getType(),"COMPUTER");
        Assert.assertEquals(newCategory.getTitle(),"컴퓨터");
    }

    @Test
    public void read(){
        Optional<Category> optionalCategory = categoryRepository.findByType("COMPUTER");
        optionalCategory.ifPresent(category -> {
            System.out.println(category);
        });
    }

}
