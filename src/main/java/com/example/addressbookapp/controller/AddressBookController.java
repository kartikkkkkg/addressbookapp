package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping
    public ResponseEntity<List<AddressBookData>> getAllEntries() {
        List<AddressBookData> list = addressBookService.getAllData();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEntryById(@PathVariable int id) {
        AddressBookData data = addressBookService.getDataById(id);
        if (data != null) {
            return ResponseEntity.ok(data);
        } else {
            return ResponseEntity.status(404).body("Entry not found");
        }
    }

    @PostMapping
    public ResponseEntity<AddressBookData> createEntry(@Valid @RequestBody AddressBookDTO dto) {
        AddressBookData newData = addressBookService.createData(dto);
        return ResponseEntity.status(201).body(newData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEntry(@PathVariable int id, @Valid @RequestBody AddressBookDTO dto) {
        AddressBookData updated = addressBookService.updateData(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.status(404).body("Entry not found");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable int id) {
        AddressBookData existing = addressBookService.getDataById(id);
        if (existing != null) {
            addressBookService.deleteData(id);
            return ResponseEntity.ok("Entry deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Entry not found");
        }
    }
    
}
