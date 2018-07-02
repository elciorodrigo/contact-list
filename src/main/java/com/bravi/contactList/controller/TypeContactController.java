package com.bravi.contactList.controller;


import com.bravi.contactList.entity.TypeContactEntity;
import com.bravi.contactList.service.TypeContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/types")
public class TypeContactController {

    @Autowired
    private TypeContactService typeContactService;

    @GetMapping()
    public List getTypes() {
        return typeContactService.findAll();
    }


    @PostMapping()
    public ResponseEntity add(@RequestBody TypeContactEntity typeContactEntity) {

        return new ResponseEntity(typeContactService.save(typeContactEntity), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getType(@PathVariable("id") Long id) {

        return typeContactService.findById(id).map(type -> {
            return new ResponseEntity(type, HttpStatus.OK);
        }).orElse(new ResponseEntity("No Type found for ID " + id, HttpStatus.NOT_FOUND));
    }

    @PutMapping()
    public ResponseEntity update(@RequestBody TypeContactEntity typeContactEntity){

        return typeContactService.findById(typeContactEntity.getId()).map(type -> {
            return new ResponseEntity(typeContactService.update(typeContactEntity), HttpStatus.OK);
        }).orElse(new ResponseEntity("No Type found for ID " + typeContactEntity.getId(), HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long typeId){

        return typeContactService.findById(typeId).map(type -> {
            typeContactService.delete(type);
            return new ResponseEntity("Deleted Type", HttpStatus.OK);
        }).orElse(new ResponseEntity("No Type found for ID " + typeId, HttpStatus.NOT_FOUND));

    }




}
