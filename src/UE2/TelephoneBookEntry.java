package UE2;

import kapitel_3.vl.SList;

public class TelephoneBookEntry {
    protected String name;
    protected String surName;
    protected SList numbers;
    protected String address;

    public TelephoneBookEntry(String name, String sureName, SList numbers,String address) {
        this.name = name;
        this.surName = sureName;
        this.numbers=numbers;
        this.address =address;
    }
    
    public String toString() {
        return "Name: " + name + "\nSurname: " + surName + "\nPhone numbers: " + numbers.toString() + "\nAddress: " + address;
    }

    public String getName() { return name; }
    public String getSurName() { return surName; }
    public SList getNumbers() { return numbers; }
    public String getAddress() { return address; }
}