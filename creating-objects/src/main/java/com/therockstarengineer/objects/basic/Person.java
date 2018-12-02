package com.therockstarengineer.objects.basic;

import java.util.Objects;

public final class Person {
    private final String firstName;
    private final String lastName;
    private final String middleInitial;
    private final String streetName;
    private final String houseNumber;
    private final String townName;
    private final String stateAbbreviation;
    private final int zipCode;

    public Person(String firstName, String middleInitial, String lastName, String streetName, String houseNumber,
                  String townName, String stateAbbreviation, int zipCode) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.townName = townName;
        this.stateAbbreviation = stateAbbreviation;
        this.zipCode = zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getTownName() {
        return townName;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public int getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof com.therockstarengineer.objects.basic.Person)) {
            return false;
        }
        com.therockstarengineer.objects.basic.Person person = (com.therockstarengineer.objects.basic.Person) o;
        return zipCode == person.zipCode &&
               firstName.equals(person.firstName) &&
               lastName.equals(person.lastName) &&
               middleInitial.equals(person.middleInitial) &&
               streetName.equals(person.streetName) &&
               houseNumber.equals(person.houseNumber) &&
               townName.equals(person.townName) &&
               stateAbbreviation.equals(person.stateAbbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleInitial, streetName, houseNumber, townName, stateAbbreviation,
                            zipCode);
    }

    @Override
    public String toString() {
        return String.format("%s %s", lastName, firstName);
    }
}
