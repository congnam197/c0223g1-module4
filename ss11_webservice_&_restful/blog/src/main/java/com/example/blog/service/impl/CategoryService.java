package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepository;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAllByFlagDeleteIsFalse();
    }

    @Override
    public Category findCategoriesById(Integer id) {
        return categoryRepository.findCategoriesById(id);
    }

    @Override
    public void create(Category category) {
        category.setFlagDelete(false);
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        Category category = categoryRepository.findCategoriesById(id);
        category.setFlagDelete(true);
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public boolean checkId(Integer id) {
        return categoryRepository.existsCategoryById(id);
    }
}
