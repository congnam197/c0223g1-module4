package com.example.create_blog.service;

import com.example.create_blog.model.Blog;
import com.example.create_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getCategory();

    Category getCategoryById(Integer id);

    void remove(Integer id);

    void update(Category category);

    void save(Category category);

}
