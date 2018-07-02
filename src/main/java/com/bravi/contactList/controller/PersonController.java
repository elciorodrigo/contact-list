package com.bravi.contactList.controller;

import com.bravi.contactList.entity.PersonEntity;
import com.bravi.contactList.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping()
    public List getPersons() {
        return personService.findAll();
    }


    @PostMapping()
    public ResponseEntity add(@RequestBody PersonEntity personEntity) {

        return new ResponseEntity(personService.save(personEntity), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity getPerson(@PathVariable("id") Long id) {

       return personService.findById(id).map(person -> {
            return new ResponseEntity(person, HttpStatus.OK);
        }).orElse(new ResponseEntity("No Person found for ID " + id, HttpStatus.NOT_FOUND));

    }

    @PutMapping()
    public ResponseEntity update(@RequestBody PersonEntity personEntity){

       return personService.findById(personEntity.getId()).map(type -> {
            return new ResponseEntity(personService.update(personEntity), HttpStatus.OK);
        }).orElse(new ResponseEntity("No Person found for ID " + personEntity.getId(), HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long personID){

        return personService.findById(personID).map(person -> {
            personService.delete(person);
            return new ResponseEntity("Deleted Person", HttpStatus.OK);
        }).orElse(new ResponseEntity("No Person found for ID " + personID, HttpStatus.NOT_FOUND));

    }

}
