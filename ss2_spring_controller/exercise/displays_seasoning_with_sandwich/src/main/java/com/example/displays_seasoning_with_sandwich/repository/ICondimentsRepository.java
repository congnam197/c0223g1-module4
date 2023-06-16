package com.example.displays_seasoning_with_sandwich.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICondimentsRepository {
    List<String> getCondiments();
}
