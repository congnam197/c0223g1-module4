package com.example.create_blog.controller;

import com.example.create_blog.model.Blog;
import com.example.create_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String displayBlog(Model model) {
        model.addAttribute("blogs", blogService.getBlog());
        return "home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setCreateTime(LocalDateTime.now());
        blogService.createBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Một blog đã được thêm mới");
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String detailBlog(@PathVariable Integer id, Model model) {
        if (blogService.getBlogDetail(id) == null) {
            model.addAttribute("message", "Không tìm thấy blog nào");
            return "error";
        }
        model.addAttribute("blog", blogService.getBlogDetail(id));
        return "detail";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Integer id, Model model) {
        if (blogService.getBlogDetail(id) == null) {
            model.addAttribute("message", "Không tìm thấy blog nào");
            return "error";
        }
        model.addAttribute("blog", blogService.getBlogDetail(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes attributes, Model model) {
        if (blogService.getBlogDetail(blog.getId()) == null) {
            model.addAttribute("message", "Không Tìm Thấy Blog nào");
            return "error";
        }
        blogService.update(blog);
        attributes.addFlashAttribute("message", "Blog đã được cập nhật");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.getBlogDetail(id) == null) {
            model.addAttribute("message", "Không tìm thấy Blog nào");
        }
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Thành Công!Blog đã được xóa");
        return "redirect:/blog";
    }
}
