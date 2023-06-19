package com.example.program_to_store_email_configuration.service.impl;

import com.example.program_to_store_email_configuration.model.Email;
import com.example.program_to_store_email_configuration.repository.IEmailRepository;
import com.example.program_to_store_email_configuration.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public List<String> getLanguagesList() {
        return emailRepository.getLanguagesList();
    }

    @Override
    public List<Integer> getPageSizeList() {
        return emailRepository.getPageSizeList();
    }

    @Override
    public Email getEmail() {
        return emailRepository.getEmail();
    }
}
