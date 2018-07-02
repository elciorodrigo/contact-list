package com.bravi.contactList.service;
import com.bravi.contactList.entity.PersonEntity;
import com.bravi.contactList.entity.TypeContactEntity;
import com.bravi.contactList.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonEntity save(PersonEntity personEntity){

        return personRepository.save(personEntity);

    }

    public List findAll() {

        return personRepository.findAll();

    }

    public Optional<PersonEntity> findById(Long id){

        return personRepository.findById(id);
    }

    public PersonEntity update(PersonEntity personEntity){

        return personRepository.save(personEntity);

    }

    public void delete(PersonEntity personEntity){

        personRepository.delete(personEntity);
    }

    @PostConstruct
    public void initCharge(){
        personRepository.save(new PersonEntity("Bob"));
        personRepository.save((new PersonEntity("Paul")));
        personRepository.save((new PersonEntity("John")));
    }
}
