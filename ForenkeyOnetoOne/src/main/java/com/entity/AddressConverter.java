//package com.entity;
//
//import javax.persistence.AttributeConverter;
//
//public class AddressConverter implements AttributeConverter<Address,Character> {
//    @Override
//    public Character convertToDatabaseColumn(Address address) {
//        return address.getAddress();
//    }
//
//    @Override
//    public Address convertToEntityAttribute(Character character) {
//        return Address.toAddress(character);
//    }
//}
