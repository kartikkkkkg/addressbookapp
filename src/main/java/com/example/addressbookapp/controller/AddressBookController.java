package com.example.addressbookapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private List<Map<String, Object>> addressBookList = new ArrayList<>();
    private int currentId = 1;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAll() {
        return ResponseEntity.ok(addressBookList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id) {
        return addressBookList.stream()
                .filter(entry -> (int) entry.get("id") == id)
                .findFirst()
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry not found"));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, Object> newEntry) {
        newEntry.put("id", currentId++);
        addressBookList.add(newEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Map<String, Object> updatedEntry) {
        for (Map<String, Object> entry : addressBookList) {
            if ((int) entry.get("id") == id) {
                entry.putAll(updatedEntry);
                entry.put("id", id); // ensure ID stays the same
                return ResponseEntity.ok(entry);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        boolean removed = addressBookList.removeIf(entry -> (int) entry.get("id") == id);
        return removed ?
                ResponseEntity.ok("Entry deleted") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry not found");
    }
}
