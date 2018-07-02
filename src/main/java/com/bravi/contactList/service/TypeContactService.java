package com.bravi.contactList.service;

import com.bravi.contactList.entity.TypeContactEntity;
import com.bravi.contactList.repository.TypeContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class TypeContactService {

    @Autowired
    private TypeContactRepository typeContactRepository;

    public TypeContactEntity save(TypeContactEntity typeContactVO){

        return typeContactRepository.save(typeContactVO);

    }

    public List findAll() {

        return typeContactRepository.findAll();

    }

    public Optional<TypeContactEntity> findById(Long id){

        return typeContactRepository.findById(id);
    }

    public TypeContactEntity update(TypeContactEntity typeContactEntity){

        return typeContactRepository.save(typeContactEntity);

    }

    public void delete(TypeContactEntity typeContactEntity){

        typeContactRepository.delete(typeContactEntity);

    }

    @PostConstruct
    void initCharge(){
        typeContactRepository.save(new TypeContactEntity("Cell Phone"));
        typeContactRepository.save(new TypeContactEntity("WhatsApp"));
        typeContactRepository.save(new TypeContactEntity("E-mail"));
    }



}
