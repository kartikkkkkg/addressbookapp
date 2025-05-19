package com.example.addressbookapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddressBookDTO {

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, message = "Name must be at least 2 characters long")
    public String name;

    @NotBlank(message = "Address must not be blank")
    public String address;

    public AddressBookDTO() {
    }

    public AddressBookDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "AddressBookDTO [name=" + name + ", address=" + address + "]";
    }
}
