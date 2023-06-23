package com.example.create_blog.service.impl;

import com.example.create_blog.model.Category;
import com.example.create_blog.repository.ICategoryRepository;
import com.example.create_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> getCategory() {
        return this.categoryRepository.findAll();
    }
}
