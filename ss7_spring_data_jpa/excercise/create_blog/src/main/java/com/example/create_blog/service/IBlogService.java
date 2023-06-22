package com.example.create_blog.service;

import com.example.create_blog.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    List<Blog> getBlog();

    void createBlog(Blog blog);

    Blog getBlogDetail(Integer id);

    void delete(Integer id);

    void update(Blog blog);
}
