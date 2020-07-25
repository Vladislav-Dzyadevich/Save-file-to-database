package com.company.service;

import com.company.dto.ContactDto;
import com.company.entity.Contact;
import com.company.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Override
    public void addContact(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setName(contactDto.getName());
        contact.setSurName(contactDto.getSurName());
        contact.setNumber(contactDto.getNumber());
        contactRepository.save(contact);
    }

    @Override
    public List<Contact> showContact() {
        return contactRepository.findAll();
    }
}
