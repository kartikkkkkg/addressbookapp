package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    private final List<AddressBookData> addressBookList = new ArrayList<>();
    private int currentId = 1;

    @Override
    public List<AddressBookData> getAllData() {
        return addressBookList;
    }

    @Override
    public AddressBookData getDataById(int id) {
        return addressBookList.stream()
                .filter(entry -> entry.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public AddressBookData createData(AddressBookDTO dto) {
        AddressBookData newEntry = new AddressBookData(currentId++, dto);
        addressBookList.add(newEntry);
        return newEntry;
    }

    @Override
    public AddressBookData updateData(int id, AddressBookDTO dto) {
        AddressBookData existing = getDataById(id);
        if (existing != null) {
            existing.setName(dto.name);
            existing.setAddress(dto.address);
        }
        return existing;
    }

    @Override
    public void deleteData(int id) {
        addressBookList.removeIf(entry -> entry.getId() == id);
    }
}
