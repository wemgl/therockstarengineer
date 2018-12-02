package com.therockstarengineer.objects.builder;

import java.util.Objects;

import static java.util.Objects.isNull;

public final class Person {
    private final String firstName;
    private final String lastName;
    private final String middleInitial;
    private final Address address;

    public static class Builder {
        private String firstName;
        private String lastName;
        private String middleInitial = "";
        private Address address;

        public Builder(String firstName, String lastName) {
            if (isNull(firstName) || firstName.isEmpty()) {
                throw new IllegalArgumentException("A new person must have a first name");
            }

            if (isNull(lastName) || lastName.isEmpty()) {
                throw new IllegalArgumentException("A new person must have a last name");
            }

            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder middleInitial(String middleInitial) {
            this.middleInitial = middleInitial;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

    private Person() {
        throw new AssertionError();
    }

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.middleInitial = builder.middleInitial;
        this.lastName = builder.lastName;
        this.address = builder.address;
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

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return firstName.equals(person.firstName) &&
               lastName.equals(person.lastName) &&
               Objects.equals(middleInitial, person.middleInitial) &&
               address.equals(person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleInitial, address);
    }

    @Override
    public String toString() {
        return String.format("%s %s\n", firstName, lastName);
    }
}
