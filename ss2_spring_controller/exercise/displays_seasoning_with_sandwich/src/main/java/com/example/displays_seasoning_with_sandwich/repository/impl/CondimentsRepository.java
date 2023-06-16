package com.example.displays_seasoning_with_sandwich.repository.impl;

import com.example.displays_seasoning_with_sandwich.repository.ICondimentsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CondimentsRepository implements ICondimentsRepository {
    private static List<String> stringList = new ArrayList<>();

    static {
        stringList.add("Lettuce");
        stringList.add("Tomato");
        stringList.add("Mustard");
        stringList.add("Sprouts");
    }

    @Override
    public List<String> getCondiments() {
        return stringList;
    }
}
