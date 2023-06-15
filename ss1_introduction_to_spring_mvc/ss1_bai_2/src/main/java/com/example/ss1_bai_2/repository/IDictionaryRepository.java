package com.example.ss1_bai_2.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
public interface IDictionaryRepository {
    Map<String, String> getDictionary();
}
