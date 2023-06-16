package com.example.displays_seasoning_with_sandwich.service.impl;

import com.example.displays_seasoning_with_sandwich.repository.ICondimentsRepository;
import com.example.displays_seasoning_with_sandwich.service.ICondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CondimentsService implements ICondimentsService {
    @Autowired
    private ICondimentsRepository condimentsRepository;

    @Override
    public List<String> getCondiment(String[] condiments) {
        List<String> stringList = new ArrayList<>();
        List<String> listCondiments = condimentsRepository.getCondiments();
        for (int i = 0; i < condiments.length; i++) {
            for (int j = 0; j < (listCondiments).size(); j++) {
                if (condiments[i].equals(listCondiments.get(j))) {
                    stringList.add(condiments[i]);
                }
            }
        }
        return stringList;
    }
}
