package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    List<Blog> getList();

    Blog getBlogDetail(Integer id);

    List<Blog> findBlogByCategoryId(Integer id);

    void createBlog(Blog blog);

    void delete(Integer id);

    void update(Blog blog);

    boolean checkId(Integer id);
}
