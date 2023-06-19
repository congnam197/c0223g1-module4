package com.example.program_to_store_email_configuration.repository;

import com.example.program_to_store_email_configuration.model.Email;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmailRepository {
    List<String> getLanguagesList();

    List<Integer> getPageSizeList();

    Email getEmail();
}
