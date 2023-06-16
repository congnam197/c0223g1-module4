package com.example.displays_seasoning_with_sandwich.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICondimentsService {
    List<String> getCondiment(String [] condiments);
}
