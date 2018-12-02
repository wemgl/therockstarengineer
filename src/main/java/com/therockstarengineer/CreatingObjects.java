package com.therockstarengineer;

import com.therockstarengineer.objects.builder.Address;
import com.therockstarengineer.objects.builder.Person;

public class CreatingObjects {

    public void run() {
        var person = new Person.Builder("Archibald", "Andrews")
                .middleInitial("G")
                .address(new Address.Builder("123 Main Street")
                                 .townName("Riverdale")
                                 .stateAbbreviation("NY")
                                 .zipCode(10463)
                                 .build())
                .build();
        System.out.println("New Person:");
        System.out.println(person);
    }
}
