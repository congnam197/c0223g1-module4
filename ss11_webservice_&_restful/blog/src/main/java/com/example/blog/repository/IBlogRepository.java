package com.example.blog.repository;


import com.example.blog.model.Blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByFlagDeleteIsFalse();

    List<Blog> findBlogByCategory_Id(Integer id);

    boolean existsBlogById(Integer id);
}
