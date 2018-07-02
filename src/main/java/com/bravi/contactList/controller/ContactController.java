package com.bravi.contactList.controller;

import com.bravi.contactList.entity.ContactEntity;
import com.bravi.contactList.entity.PersonEntity;
import com.bravi.contactList.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping()
    public List getTypes() {
        return contactService.findAll();
    }


    @PostMapping()
    public ResponseEntity add(@RequestBody ContactEntity contactEntity) {

        return new ResponseEntity(contactService.save(contactEntity), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity getContact(@PathVariable("id") Long id) {

        return contactService.findById(id).map(contact -> {
            return new ResponseEntity(contact, HttpStatus.OK);
        }).orElse(new ResponseEntity("No contact found for ID " + id, HttpStatus.NOT_FOUND));

    }

    @PutMapping()
    public ResponseEntity update(@RequestBody ContactEntity contactEntity){

        return contactService.findById(contactEntity.getId()).map(contact -> {
            return new ResponseEntity(contactService.update(contactEntity), HttpStatus.OK);
        }).orElse(new ResponseEntity("No contact found for ID " + contactEntity.getId(), HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findAll/{personId}")
    public ResponseEntity findAllByPerson(@PathVariable("personId") Long personId){

        return new ResponseEntity(contactService.findByPerson(personId), HttpStatus.OK);
    }

}
