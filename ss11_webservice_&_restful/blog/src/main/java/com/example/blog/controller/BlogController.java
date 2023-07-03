package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public ResponseEntity<List<Blog>> getList() {
        List<Blog> blogList = this.blogService.getList();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> getBlogDetail(@PathVariable Integer id) {
        if (blogService.checkId(id)) {
            return new ResponseEntity<>(this.blogService.getBlogDetail(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createBlog(@RequestBody Blog blog) {
        if (blog != null) {
            this.blogService.createBlog(blog);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateBlog(@PathVariable Integer id, @RequestBody Blog blog) {
        if (blogService.checkId(id) && blog.getId() != null) {
            blog.setId(id);
            blogService.update(blog);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable Integer id) {
        if (blogService.checkId(id)) {
            this.blogService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Blog>> searchBlog(@PathVariable String title) {
        if (blogService.searchBlog(title).size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blogService.searchBlog(title), HttpStatus.OK);
        }
    }

    @GetMapping("/more/{page}")
    public ResponseEntity<List<Blog>> loadMorePage(@PathVariable Integer page) {
        List<Blog> blogList = this.blogService.loadMore(page);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }
}
