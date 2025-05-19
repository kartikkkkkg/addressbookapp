package com.example.addressbookapp;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAll();
    AddressBookData getById(int id);
    AddressBookData create(AddressBookDTO dto);
    AddressBookData update(int id, AddressBookDTO dto);
    void delete(int id);
}
