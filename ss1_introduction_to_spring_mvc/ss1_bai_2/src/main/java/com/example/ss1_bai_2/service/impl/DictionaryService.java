package com.example.ss1_bai_2.service.impl;

import com.example.ss1_bai_2.repository.IDictionaryRepository;
import com.example.ss1_bai_2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;
    @Override
    public String searchWord( String word) {
        Map<String,String>stringMap = dictionaryRepository.getDictionary();
        String result = null;
        for (String text : stringMap.keySet()) {
            if (word.equals(text.toLowerCase(Locale.ROOT))) {
                result = stringMap.get(text);
                break;
            }
        }
        if (result == null) {
            result = "Not Found!";
        }
        return result;
    }
}
