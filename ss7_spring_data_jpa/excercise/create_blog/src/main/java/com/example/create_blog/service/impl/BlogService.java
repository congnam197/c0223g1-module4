package com.example.create_blog.service.impl;

import com.example.create_blog.model.Blog;
import com.example.create_blog.repository.IBlogRepository;
import com.example.create_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> getBlog() {
        return blogRepository.findAll();
    }

    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog getBlogDetail(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }
}
