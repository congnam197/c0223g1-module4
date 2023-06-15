package com.example.ss1_bai_2.repository.impl;

import com.example.ss1_bai_2.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private  static Map<String,String> stringMap =new HashMap<>();
    static {
        stringMap.put("dog", "chú chó");
        stringMap.put("cat", "con mèo");
        stringMap.put("fish", "con cá");
        stringMap.put("apple", "quả táo");
        stringMap.put("orange", "quả cam");
        stringMap.put("banana", "quả chuối");
    }
    @Override
    public Map<String, String> getDictionary() {
        return stringMap;
    }
}
