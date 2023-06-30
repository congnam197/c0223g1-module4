package com.example.blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorys")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "topics", unique = true, nullable = false, columnDefinition = "LongText")
    private String topic;

    private boolean flagDelete;

    public Category() {
    }

    public Category(Integer id, String topic, boolean flagDelete) {
        this.id = id;
        this.topic = topic;
        this.flagDelete = flagDelete;
    }

    public Category(String topic) {
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
