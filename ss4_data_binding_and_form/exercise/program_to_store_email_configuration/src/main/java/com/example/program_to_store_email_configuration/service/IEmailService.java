package com.example.program_to_store_email_configuration.service;

import com.example.program_to_store_email_configuration.model.Email;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmailService {
    List<String> getLanguagesList();

    List<Integer> getPageSizeList();
    Email getEmail();
}
