package com.example.blog.service;


import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    List<Category> getCategory();

    Category findCategoriesById(Integer id);

    void create(Category category);

    void delete(Integer id);

    void update(Category category);

    boolean checkId(Integer id);
}
