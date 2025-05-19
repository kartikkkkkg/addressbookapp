package com.example.addressbookapp.model;

import com.example.addressbookapp.dto.AddressBookDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "address_book")
public class AddressBookData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;

    public AddressBookData() {}

    public AddressBookData(int id, AddressBookDTO dto) {
        this.id = id;
        this.name = dto.name;
        this.address = dto.address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AddressBookData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
