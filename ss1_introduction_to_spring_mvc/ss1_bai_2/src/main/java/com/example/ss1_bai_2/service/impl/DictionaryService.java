package com.example.ss1_bai_2.service.impl;

import com.example.ss1_bai_2.repository.IDictionaryRepository;
import com.example.ss1_bai_2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;
    @Override
    public Map<String, String> getDictionary() {
        return dictionaryRepository.getDictionary();
    }
}
