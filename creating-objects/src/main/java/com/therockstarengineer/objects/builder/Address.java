package com.therockstarengineer.objects.builder;

import java.util.Objects;

public final class Address {
    private final String streetName;
    private final String houseNumber;
    private final String townName;
    private final String stateAbbreviation;
    private final int zipCode;

    public static class Builder {
        private String streetName;
        private String houseNumber = "";
        private String townName = "";
        private String stateAbbreviation = "";
        private int zipCode;

        public Builder(String streetName) {
            if (Objects.isNull(streetName) || streetName.isEmpty()) {
                throw new IllegalArgumentException("address street name is missing");
            }
            this.streetName = streetName;
        }

        public Builder houseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder townName(String townName) {
            this.townName = townName;
            return this;
        }

        public Builder stateAbbreviation(String stateAbbreviation) {
            this.stateAbbreviation = stateAbbreviation;
            return this;
        }

        public Builder zipCode(int zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

    private Address() {
        throw new AssertionError();
    }

    private Address(Builder builder) {
        streetName = builder.streetName;
        houseNumber = builder.houseNumber;
        townName = builder.townName;
        stateAbbreviation = builder.stateAbbreviation;
        zipCode = builder.zipCode;
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
        if (!(o instanceof Address)) {
            return false;
        }
        Address address = (Address) o;
        return zipCode == address.zipCode &&
               Objects.equals(streetName, address.streetName) &&
               Objects.equals(houseNumber, address.houseNumber) &&
               Objects.equals(townName, address.townName) &&
               Objects.equals(stateAbbreviation, address.stateAbbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, houseNumber, townName, stateAbbreviation, zipCode);
    }

    @Override
    public String toString() {
        return String.format("%s %s\n%s, %s %s", streetName, houseNumber, townName, stateAbbreviation, zipCode);
    }
}
