package com.example.blog.service.impl;


import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> getList() {
        return blogRepository.findAllByFlagDeleteIsFalse();
    }

    @Override
    public Blog getBlogDetail(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findBlogByCategoryId(Integer id) {
        return blogRepository.findBlogByCategory_Id(id);
    }

    @Override
    public void createBlog(Blog blog) {
        blog.setCreateTime(LocalDateTime.now());
        blog.setFlagDelete(false);
        blogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        Blog blog = getBlogDetail(id);
        blog.setFlagDelete(true);
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public boolean checkId(Integer id) {
        return blogRepository.existsBlogById(id);
    }

    @Override
    public List<Blog> searchBlog(String title) {
        return blogRepository.findAllByTitleContainsAndFlagDeleteIsFalse(title);
    }

    @Override
    public List<Blog> loadMore(Integer number) {
        return blogRepository.loadMore(number);
    }
}
