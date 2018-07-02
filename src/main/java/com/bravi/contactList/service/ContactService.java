package com.bravi.contactList.service;

import com.bravi.contactList.entity.ContactEntity;
import com.bravi.contactList.entity.PersonEntity;
import com.bravi.contactList.entity.TypeContactEntity;
import com.bravi.contactList.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private PersonService personService;

    @Autowired TypeContactService typeContactService;

    public ContactEntity save(ContactEntity contactEntity){

        return contactRepository.save(contactEntity);

    }

    public List findAll() {

        return contactRepository.findAll();

    }

    public Optional<ContactEntity> findById(Long id){

        return contactRepository.findById(id);
    }

    public ContactEntity update(ContactEntity contactEntity){

        return this.save(contactEntity);

    }

    public List<ContactEntity> findByPerson(Long personId){

        return contactRepository.findAllByPerson(personId);
    }


    public void delete(ContactEntity contactEntity) {

        contactRepository.delete(contactEntity);
    }

    @PostConstruct
    public void initCharge(){

        PersonEntity p =personService.findById(1l).get();
        TypeContactEntity t = typeContactService.findById(1l).get();

        this.save(new ContactEntity(t, "11-3335-5125", p));


    }


}
