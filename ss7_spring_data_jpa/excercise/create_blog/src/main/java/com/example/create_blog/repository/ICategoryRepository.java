package com.example.create_blog.repository;

import com.example.create_blog.model.Blog;
import com.example.create_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByFlagDeleteIsFalse();
}
