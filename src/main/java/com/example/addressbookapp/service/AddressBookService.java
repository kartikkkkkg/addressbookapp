package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository repository;

    @Override
    public List<AddressBookData> getAllData() {
        return repository.findAll();
    }

    @Override
    public AddressBookData getDataById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AddressBookData createData(AddressBookDTO dto) {
        AddressBookData newEntry = new AddressBookData(0, dto);
        return repository.save(newEntry);
    }

    @Override
    public AddressBookData updateData(int id, AddressBookDTO dto) {
        AddressBookData existing = getDataById(id);
        if (existing != null) {
            existing.setName(dto.name);
            existing.setAddress(dto.address);
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteData(int id) {
        repository.deleteById(id);
    }
}
