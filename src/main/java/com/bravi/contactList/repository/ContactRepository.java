package com.bravi.contactList.repository;

import com.bravi.contactList.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

    @Query("select c from ContactEntity c where c.personEntity.id = ?1")
    List<ContactEntity> findAllByPerson(Long personId);

}
