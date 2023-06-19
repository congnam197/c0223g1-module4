package com.example.program_to_store_email_configuration.repository.impl;

import com.example.program_to_store_email_configuration.model.Email;
import com.example.program_to_store_email_configuration.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static List<String> listLanguages = new ArrayList<>();
    private static List<Integer> listPageSize = new ArrayList<>();

    static {
        listLanguages.add("English");
        listLanguages.add("Vietnamese");
        listLanguages.add("Japanese");
        listLanguages.add("Chinese");
        listPageSize.add(5);
        listPageSize.add(10);
        listPageSize.add(15);
        listPageSize.add(25);
        listPageSize.add(50);
    }

    @Override
    public List<String> getLanguagesList() {
        return listLanguages;
    }

    @Override
    public List<Integer> getPageSizeList() {
        return listPageSize;
    }

    // public Email(String language, int pageSize, boolean spamsFilter, String signature) {
    @Override
    public Email getEmail() {
        Email email = new Email(listLanguages.get(0), listPageSize.get(2), false, "Thor, King,Asgard");
        return email;
    }
}
