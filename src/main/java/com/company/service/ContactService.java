package com.company.service;

import com.company.dto.ContactDto;
import com.company.entity.Contact;

import java.util.List;

public interface ContactService {
    void addContact(ContactDto contactDto);
    List<Contact> showContact();
}
