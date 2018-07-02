package com.bravi.contactList.repository;

import com.bravi.contactList.entity.TypeContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public interface TypeContactRepository extends JpaRepository<TypeContactEntity, Long> {



}
