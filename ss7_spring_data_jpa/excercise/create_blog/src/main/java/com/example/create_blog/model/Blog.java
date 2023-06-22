package com.example.create_blog.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;

    @Column(columnDefinition = "long")
    private String description;

    @Column(columnDefinition = "long")
    private String content;

    private LocalDateTime createTime;
    private String image;

    public Blog(Integer id, String title, String description, String content, LocalDateTime createTime, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.createTime = createTime;
        this.image = image;
    }

    public Blog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
