package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAllData();
    AddressBookData getDataById(int id);
    AddressBookData createData(AddressBookDTO dto);
    AddressBookData updateData(int id, AddressBookDTO dto);
    void deleteData(int id);
}
