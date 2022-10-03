//package com.entity;
//
//public enum Address {
//    HANOI('H'), HAIPHONG('P'),NINHBINH('N'),HOCHIMINH('C');
//
//    private final char address;
//
//    Address(char address) {
//        this.address = address;
//    }
//
//    public char getAddress() {
//        return address;
//    }
//
//    public static Address toAddress(char address){
//        if (address == 'H'|| address == 'h'){
//            return HANOI;
//        }
//        if (address == 'N'|| address == 'n'){
//            return NINHBINH;
//        }
//        if (address == 'C'|| address == 'c'){
//            return HOCHIMINH;
//        }
//        if (address == 'P'|| address == 'p'){
//            return HAIPHONG;
//        }
//            throw  new UnsupportedOperationException("No");
//    }
//}
