package com.example.ss1_bai_2.service;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface IDictionaryService {
    Map<String,String> getDictionary();
}
